package projlab;

import java.util.ArrayList;

public class Field {
	private int snow;
	private Igloo igloo;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Item item;
	private ArrayList<Field> neighbours = new ArrayList<Field>(); //kelett, hogy a tesztben fusson a .size() miatt
	protected String objName;
	
	public void AddPlayer(Player p) {
		Writer.Write(objName + ".AddPlayer(" + p.GetObjName() +")");
		Writer.Deregister(objName);
		
		players.add(p);
	}
	
	public Field GetNeighbour(int dir) {
		Writer.Write(objName + ".GetNeighbour(" + dir +")");
		Writer.Deregister(objName);
		
		return neighbours.get(dir);
	}
	
	public void RemovePlayer(Player p) {
		Writer.Write(objName + ".RemovePlayer(" + p.GetObjName() +")");
		Writer.Deregister(objName);
		
		players.remove(p);
	}
	
	public void AddSnow(int s) {
		System.out.println(objName + ".AddSnow(" + s +")");
		
		if(igloo != null) {
			boolean destroy  = igloo.Destroy(s);
			if(destroy) {
				this.RemoveIgloo();
			}
		}
		
		snow += s;
		
		if(igloo == null) {
			for(Player p : players) {
				p.AddTemp(-1);
			}
		}
	}
	
	public int GetMaxPlayers() {
		System.out.println(objName + ".GetMaxPlayers()");
		
		return -1;
	}
	
	public void BuildIgloo(Igloo i) {
		System.out.println(objName + ".UseAbility(" + i.GetObjName() +")");
		
		this.igloo = i;
	}
	
	public void RemoveIgloo() {
		System.out.println(objName + ".RemoveIgloo()");
		
		this.igloo = null;
	}
	
	public void SetNeighbour(int dir, Field f) {
		Writer.Write(objName + ".SetNeighbour(" + dir + "," + f.GetObjName() + ")");
		
		int n = neighbours.size();
		for(int i = 0; i < (dir + 1 - n); i++) {
			if(n == 0) {
				neighbours.add(null);
			}
			if(neighbours.get(i) == null) {
				neighbours.add(null);
			}
		}
		neighbours.set(dir, f);
	}
	
	public void RemoveItem() {
		System.out.println(objName + ".RemoveItem()");
		
		this.item = null;
	}
	
	public Item GetItem() {
		System.out.println(objName + ".GetItem()");
		
		return item;
	}
	
	public ArrayList<Player> GetPlayers(){
		System.out.println(objName + ".GetPlayers()");
		
		return players;
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public void SetObjName(String name) {
		objName = name;
	}
}
