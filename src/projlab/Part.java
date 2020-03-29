package projlab;

import java.util.ArrayList;
/**
 * Represent the items that the players need to collect to win the game
 * This class extends the Item class
 */
public class Part extends Item {
	
	/**
	 * The type of the item
	 */
	private int type;
	
	/**
	 * When called the method check the conditions if the players have won
	 */
	public void Use() {
		Writer.Write(objName + ".Use()");
		
		Writer.Deregister(objName);
		Writer.DummyGive("d");
		
		Player p = this.GetPlayer();
		
		Writer.Deregister("d");
		
		Field f = p.GetField();
		Writer.Deregister("e");
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
