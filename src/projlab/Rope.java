package projlab;

import java.util.ArrayList;
/**
 * Extends the Item class
 * Implements the Rope item
 */
public class Rope extends Item {
	/**
	 * Moves every drowning player from neighbouring fields
	 * to the field of the user, and sets their drowning
	 * statuses to 0
	 */
	public void Use() {
		
		Player player = this.GetPlayer();
		
		Field f1 = player.GetField();
		
		for(int i = 0; i < f1.GetNeighboursSize(); i++) {
			Field fi = f1.GetNeighbour(i);
			if(fi != null) {
				ArrayList<Character> characters = fi.GetCharacters();
				ArrayList<Character> cToRescue = new ArrayList<>();
				for(Character c : characters) {
					if(c.Rescuable()) {
						cToRescue.add(c);
					}
				}
				for (Character c : cToRescue){
					fi.RemoveCharacter(c);
					Player p = (Player)c;
					p.SetDrowning(0);
					f1.AddCharacter(c);
				}
			}
			
		}

	}
}
