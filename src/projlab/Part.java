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
		
		Player p = this.GetPlayer();
		
		Field f = p.GetField();
		ArrayList<Player> playersOnField = new ArrayList<Player>();
		ArrayList<Character> charactersOnField = f.GetCharacters();
		
		for(int i = 0; i < charactersOnField.size(); i++) {
			if(charactersOnField.get(i) instanceof Player)
				playersOnField.add((Player)charactersOnField.get(i));
		}
		
		ArrayList<Player> allPlayers = Controller.GetPlayers();
			
		if(playersOnField.equals(allPlayers)) {
			ArrayList<Item> allItems = new ArrayList<Item>();
			for(Player pi : allPlayers) {
				allItems.addAll(pi.GetItems());
			}
			int j = 0;
			for (Item i : allItems) {
				if(i instanceof Part) {
					j++;
				}
			}
			if(j == 3) {
				Controller.Win();
			}
		}
	}
}
