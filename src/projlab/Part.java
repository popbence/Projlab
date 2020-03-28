package projlab;

import java.util.ArrayList;

public class Part extends Item {
	private int type;
	
	public void Use() {
		System.out.println(objName + ".Use()");
		Player p = this.GetPlayer().
		Field f = p.GetField();
		ArrayList<Player> playersOnField = new ArrayList<Player>();
		playersOnField = f.GetPlayers();
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		allPlayers = Controller.GetPlayers();
		playersOnField.equals(allPlayers);
		ArrayList<Item> items = p.GetItems();
		int j = 0;
		for (Item i : items) {
			if(i instanceof Part) {
				j++;
			}
		}
		if(j == 3)
			Controller.Win();
	}
}
