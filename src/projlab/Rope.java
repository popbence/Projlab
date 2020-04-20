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
		while (has_more_neighbours) {
			try {
				Field fi = f1.GetNeighbour(i);
				// Neighbours might be nulls
				if(fi != null){
					ArrayList<Player> players = fi.GetPlayers();
					ArrayList<Player> toRemove = new ArrayList<Player>();
	
					for (Player p : players) {
						if (p.GetDrowning() == 1) {
							toRemove.add(p);
						}
					}
					for (Player p : toRemove){
						fi.RemovePlayer(p); 
						p.SetDrowning(0);
						f1.AddPlayer(p);
					}
				}
				i++;
			} catch (IndexOutOfBoundsException e){
				has_more_neighbours = false;
			}
		}

	}
}
