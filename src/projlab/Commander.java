package projlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Commander {

	Controller c;
	Hashtable<String,Object> objects;
	Hashtable<String,String> positions;
	ArrayList<String> neighbours;
	int itemNum;
	
	public Commander() {
		c = new Controller();
		objects = new Hashtable<String, Object>();
		positions = new Hashtable<String,String>();
		neighbours = new ArrayList<String>();
		itemNum = 0;
	}
	
	public void interpret(String input) {
		String[] params = input.split(" ");
		if((objects.isEmpty() && !params[0].equalsIgnoreCase("createmap")) && (!params[0].equalsIgnoreCase("load"))) System.out.println("please, create a map first!");
		else {
			switch (params[0]) {
			case "createmap": createmap(params); break;
			case "character": character(params); break;
			case "setfield": setfield(params); break;
			case "setitem": setitem(params); break;
			case "setsnow": setsnow(params); break;
			case "step": step(params); break;
			case "playeruse": playeruse(params); break;
			case "data": data(params); break;
			case "load": load(params); break;
			case "setneig": setneig(params); break;
			case "makestorm": makestorm(params); break;
			case "endround": endround(params); break;
			case "": break;
			default: System.out.println("wrong command, please try again");
			}
		}
	}
	
	private void createmap(String[] params) {
		try {
			if(params.length%2 != 0 || Integer.parseInt(params[1]) < 1) System.out.println("wrong parameters");
			else {
				c.Init();
				objects = new Hashtable<String, Object>();
				for(int i=0;i<Integer.parseInt(params[1]);i++) {
					Field f = new Field();
					objects.put("f_" + (i+1), f);
					c.AddField(f);
				}
			}
		}catch(Exception e) {
			System.out.println("The second parameter is not a number!");
		}
	}
	
	private void character(String[] params) {
		if(params.length!=4) System.out.println("Wrong parameters!");
		else {
			switch(params[2]) {
			case "e": {
					Eskimo e = new Eskimo();
					Field f = (Field)objects.get(params[3]);
					f.AddCharacter(e);
					e.SetField(f);
					c.AddPlayer(e);
					objects.put(params[1], e);
					positions.put(params[1], params[3]);
					break;
				}
			case "ex": {
					Explorer ex = new Explorer();
					Field f = (Field)objects.get(params[3]);
					f.AddCharacter(ex);
					ex.SetField(f);
					c.AddPlayer(ex);
					objects.put(params[1], ex);
					positions.put(params[1], params[3]);
					break;
				}
			case "p": {
					PolarBear p = new PolarBear();
					Field f = (Field)objects.get(params[3]);
					f.AddCharacter(p);
					p.SetField(f);
					objects.put("@" + params[1], p);
					positions.put("@" + params[1], params[3]);
					System.out.println("Your Polarbear has been named: @" + params[1] );
					break;
				}
			}
		}
	}
	
	private void setfield(String[] params) {
		try {
			if(params.length<3) System.out.println("wrong parameters!");
			else {
				switch(params[2]) {
				case "hole": {
						if(objects.containsKey(params[1])) {
							objects.put(params[1].replace("f", "h"), new Hole());
							objects.remove(params[1]);
							System.out.println(params[1] + "has been renamed:" + params[1].replace("f", "h"));
						}
						else System.out.println("there's no field with this ID: " + params[1]);
						break;
					}
				case "unstable": {
					if(params.length!=4) System.out.println("not enough parameters for *unstable*");
					else {
							Unstable u = new Unstable();
							u.SetMaxCharacter(Integer.parseInt(params[3]));
							if(objects.containsKey(params[1])) {
								objects.put(params[1].replace("f", "u"), u);
								objects.remove(params[1]);
								System.out.println(params[1] + " has been renamed: " + params[1].replace("f", "u"));
							}
							else System.out.println("there's no field with this ID: " + params[1]);
							break;
						}
					}
				}
			}
		}catch(Exception e) {
			System.out.println("The fourth parameter is not a number!");
		}
		
	}
	
	private void setitem(String[] params) {
		if(params.length<3) System.out.println("wrong parameters!");
		else {
			if(objects.containsKey(params[1])) {
				Field f = (Field)objects.get(params[1]);
				switch(params[2]) {
				case "shovel": {
					Shovel s = new Shovel();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
					}
				case "food": {
					Food s = new Food();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
					}
				case "fragileshovel": {
					FragileShovel s = new FragileShovel();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
					}
				case "part": {
					Part s = new Part();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
					}
				case "rope": {
					Rope s = new Rope();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
					}
				case "suit": {
					Suit s = new Suit();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
				}
				case "tentbuilder": {
					TentBuilder s = new TentBuilder();
					f.SetItem(s);
					objects.put("*" + itemNum, s);
					break;
				}
				case "igloo": {
					f.BuildIgloo(new Igloo());
					break;
				}
				default: {
					System.out.println("wrong item name parameter!");
					break;
				}
				}
				System.out.println("This item created is named: *" + itemNum);
				itemNum++;
			}
			else System.out.println("there's no field with this ID: " + params[1]);
		}
	}
	
	private void setsnow(String[] params) {
		try {
			if(params.length<3) System.out.println("wrong parameters!");
			else {
				if(params[2].equalsIgnoreCase("all")) {
					Set<String> keys = objects.keySet();
					Field f;
					for(String key: keys) {
						if(key.contains("f_") || key.contains("h_") || key.contains("u_")) {
							f = (Field)objects.get(key);
							f.AddSnow(Integer.parseInt(params[1]));
						}
					}
				}
				else {
					if(objects.containsKey(params[2])) {
						Field f = (Field)objects.get(params[2]);
						f.AddSnow(Integer.parseInt(params[1]));
					}
					else System.out.println("there's no field with this ID: " + params[2]);
				}
			}
		}catch(Exception e) {
			System.out.println("The second parameter is not a number!");
		}
	}
	
	private void step(String[] params) {
		if(params.length<3) System.out.println("wrong parameters!");
		else {
			if(objects.containsKey(params[1])) {
				Character ch = (Character)objects.get(params[1]);
				ch.Step(Integer.parseInt(params[2]));
				for(String s : neighbours) {
					String[] tmp = s.split(" ");
					if(tmp[0].equalsIgnoreCase(positions.get(params[1]))) {
						if(params[2].equalsIgnoreCase(tmp[2])) {
							positions.put(params[1], tmp[1]);
							break;
						}
					}
					else if (tmp[1].equalsIgnoreCase(positions.get(params[1]))) {
						if(params[2].equalsIgnoreCase(tmp[3])) {
							positions.put(params[1], tmp[0]);
							break;
						}
					}
				}
			}
			else System.out.println("there's no field with this ID: " + params[2]);
		}
	}
	
	private void playeruse(String[] params) {
		try {
			if(params.length<3) System.out.println("wrong parameters!");
			else {
				if(objects.containsKey(params[1])) {
					Player pl = (Player)objects.get(params[1]);
					switch(params[2]) {
					case "item": {
						pl.UseItem(Integer.parseInt(params[3]));
						break;
					}
					case "ability": {
						if(params.length<4) pl.UseAbility(1);
						else pl.UseAbility(Integer.parseInt(params[3]));
						break;
					}
					case "dig": {
						pl.Dig();
						break;
					}
					case "pick": {
						pl.Pick();
						break;
					}
					}
				}
				else System.out.println("there's no player with this ID: " + params[2]);
			}
		}catch(Exception e) {
			System.out.println("The fourth parameter is not a number!");
		}
	}
	
	private void data(String[] params) {
		if(params.length<2) System.out.println("wrong parameters!");
		else {
			if (params[1].contains("_")) {	
				Field f = (Field)objects.get(params[1]);
				String fields = "";
				String player = "";
				for(String s : neighbours) {
					String[] tmp = s.split(" ");
					if(tmp[0].equalsIgnoreCase(params[1])) {
						fields += " " + tmp[1];
					}
					else if (tmp[1].equalsIgnoreCase(params[1])) {
						fields += " " + tmp[0];
					}
				}
				ArrayList<Character> players = f.GetCharacters();
				Set<String> keys = objects.keySet();
				for(String key: keys) {
					if(players.contains(objects.get(key))) {
						player += " " + key;
					}
				}
				String snow = " " + f.snow;
				
				System.out.println("\n\tneighbours:" + fields +
								"\n\tplayers:" + player +
								"\n\tsnow:" + snow);
				if(params[1].contains("f_") || params[1].contains("u_")) {
					System.out.println("\tigloo: " + (f.GetIgloo()!=null? 1 : 0) +
										"\n\ttent: " + (f.GetIgloo()!=null && f.GetIgloo().Invadable()? 1 : 0));
				}
				if(params[1].contains("u_")) {
					System.out.println("\tmaxPlayers: " + f.GetMaxCharacter());
				}
			} else if(params[1].contains("@")){
			    System.out.println("\tfield: " + positions.get(params[1]));
			} else if(params[1].contains("*")) {
				Item it = (Item)objects.get(params[1]);
				String player = "";
				Set<String> keys = objects.keySet();
				for(String key: keys) {
					if(objects.get(key).equals(it.GetPlayer())) {
						player = key;
						break;
					}
				}
				System.out.println("\tplayer: " + player);
			} else {
				Player pl = (Player)objects.get(params[1]);
				System.out.println("\tfield: " + positions.get(params[1]) +
									"\n\twork: " + pl.GetWork() +
									"\n\ttemperature: " + pl.GetTemp() +
									"\n\tdrowning: " + pl.GetDrowning());
				ArrayList<Item> items = pl.GetItems();
				String item = "";
				Set<String> keys = objects.keySet();
				for(String key: keys) {
					if(items.contains(objects.get(key))) {
						 item += " " + key;
					}
				}
				System.out.println("\titems:" + item);
			}
		}
	}
	
	private void load(String[] params) {
			if(params[1].equalsIgnoreCase("all")) {
				int i = 1;
				File f = new File("tests/teszt-" + i + "-inp.txt");
				while(f.exists()) {
					try
					  {
						System.out.println("\tteszt-" + i + "-inp.txt file:");
						BufferedReader reader = new BufferedReader(new FileReader("tests/teszt-" + i + "-inp.txt"));
					    if(reader!=null) {
					    	String line;
						    while ((line = reader.readLine()) != null)
						    {
						      System.out.println("\t\t" + line);
						      interpret(line);
						    }
						    reader.close();
					    }
					  }
					  catch (Exception e)
					  {
					    System.err.format("Exception occurred trying to read " + params[1]);
					    e.printStackTrace();
					  } 
					i++;
					f = new File("tests/teszt-" + i + "-inp.txt");
				}
			}
			else {
				if(!params[1].contains(".txt")) params[1] = params[1].concat(".txt");
				File f = new File(params[1]);
				if(f.exists()) {
					try
					  {
						BufferedReader reader = new BufferedReader(new FileReader(params[1]));
					    if(reader!=null) {
					    	String line;
						    while ((line = reader.readLine()) != null)
						    {
						      System.out.println("\t" + line);
						      interpret(line);
						    }
						    reader.close();
					    }
					  }
					  catch (Exception e)
					  {
					    System.err.format("Exception occurred trying to read " + params[1]);
					    e.printStackTrace();
					  }  
				}
				else System.out.println("The specified file doesn't exist in the project folder!: " + params[1]);
			}
	}
	
	private void setneig(String[] params) {
		try {
			if(params.length<5) System.out.println("wrong parameters!");
			else {
				if(objects.containsKey(params[1])) {
					if(objects.containsKey(params[2])) {
					Field f1 = (Field)objects.get(params[1]);
					Field f2 = (Field)objects.get(params[2]);
					
					f1.SetNeighbour(Integer.parseInt(params[3]), f2);
					f2.SetNeighbour(Integer.parseInt(params[4]), f1);
					
					neighbours.add(params[1] + " " + params[2] + " " + params[3] + " " + params[4]);
					}
					else System.out.println("there's no field with this ID: " + params[2]);
					}
				else System.out.println("there's no field with this ID: " + params[1]);
				}
		}catch(Exception e) {
			System.out.println("The fourth/fifth parameter is not a number!: " + params[3] + " " + params[4]);
		}
	}
	
	private void makestorm(String[] params) {
		c.SnowStormAll();
	}
	
	private void endround(String[] params) {
		if(params.length<2) System.out.println("wrong parameters!");
		else {
			Player pl = (Player)objects.get(params[1]);
			pl.EndRound();
		}
	}
	
	
}
