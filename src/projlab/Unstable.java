package projlab;

import java.util.ArrayList;

/**
 * Extends the Field class
 * Implements Unstable fields
 */
public class Unstable extends Field { // TODO: Comments
	private int maxPlayer;
	private boolean flipped;

	/**
	 * Flips the unstable field:
	 * Sets the temperature of the players on this field to 0, if not stabilized
	 * Removes the snow and igloo on this field, if not stabilized
	 */
	public void Flip() {

		flipped = !flipped;

		if (flipped) {
			for (Player p : GetPlayers()) {
				p.SetTempToOne();
				p.SetDrowning(1);
				//p.EndRound(); a teszt 12 eset�ben ez nem fontos itt.
			}
			igloo = null;
			snow = 0;
		}
	}

	/**
	 * Adds p player to the list of players
	 * Checks the number of players on the field after addition
	 * and flips, if applicable (more players on the field than maxPlayers)
	 * @param p The player to be added
	 */
	public void AddPlayer(Player p) {
		super.AddPlayer(p); // should include the method call print
		
		if (flipped){
			/*p.SetTempToOne();
			p.SetDrowning(1);
			p.EndRound();*/// a teszt 13 eset�ben nem fontos itt.
		} else if (GetPlayers().size() > maxPlayer)
			Flip();
	}

	/**
	 * Removes the given player from the list of players
	 * Checks the number of players on the field after removal
	 * and flips back, if applicable (no players on the field)
	 * @param p The player to be removed
	 */
	public void RemovePlayer(Player p) {
		super.RemovePlayer(p); // should include the method call print
		
		if (GetPlayers().size() == 0)
			Flip();
	}

	/**
	 * Returns the max amount of players the field can safely carry
	 * @return The max number of players the field can carry
	 */
	public int GetMaxPlayer() {
		return maxPlayer;
	}

	/**
	 * Sets the max amount of players the field can safely carry
	 * @param players the new max number of players the field can carry
	 */
	public void SetMaxPlayer(int players) {
		maxPlayer = players;
	}
	
}
