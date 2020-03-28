package projlab;

import java.util.ArrayList;

public class Controller {
	private static ArrayList<Field> fields;
	private static ArrayList<Player> players;
	private static String objName;
	
	public void Init(){}
	
	public static void RoundCheck() {
		System.out.println(objName + ".RoundCheck()");
		
		boolean allWorkZero = true;
		for(Player p : players ) {
			if(p.GetWork() <= 0) {
				allWorkZero = false;
			}
		}
		if(allWorkZero) {
			NextRound();
		}
	}
	
	public static void GameOver() {
		System.out.println(objName + ".GameOver()");
	}
	
	public static void Win() {
		System.out.println(objName + ".Win()");
	}
	
	public static void NextRound() {
		System.out.println(objName + ".NextRound()");
		//TODO megkérdezni a felhasználót, hogy legyen-e snowstorm
		
		for(Player p : players ) {
			p.AddWork(4);
			p.SetDrowning(2);
		}
	}
	
	public static void SnowStorm() {
		System.out.println(objName + ".SnowStorm()");
		
		for(Field f : fields) {
			f.AddSnow(3);
		}
	}
	
	public ArrayList<Player> GetPlayers(){
		return players;
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public void SetObjName(String name) {
		objName = name;
	}
}
