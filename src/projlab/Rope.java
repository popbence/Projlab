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
		
		int i = 0; boolean has_more_neighbours = true;
		while(has_more_neighbours) {
			try {
				Field fi = f1.GetNeighbour(i);
				if(fi != null) {
					ArrayList<Character> characters = fi.GetCharacters();
					for(Character c : characters) {
						if(c.Rescuable()) {
							fi.RemoveCharacter(c);
							Player p = (Player)c;
							p.SetDrowning(0);
							f1.AddCharacter(c);
						}
					}
				}
				++i;
			}
			catch(IndexOutOfBoundsException e) {
				has_more_neighbours = false;
			}
		}

	}
}
