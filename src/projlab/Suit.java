package projlab;

/**
 * Extends the Item class
 * Implements the Suit item
 */
public class Suit extends Item {

	/**
	 * Sets the user's drowning attribute to -1
	 * From that point on, that value cannot be changed
	 */
	public void Use() {
		Player p = this.GetPlayer();
		p.SetDrowning(-1);
	}
}
