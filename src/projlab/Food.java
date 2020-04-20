package projlab;

/**
 * Extends the Item class
 * Implements the Food item
 */
public class Food extends Item{
	/**
	 * Adds one temperature to the player that uses it
	 */
	public void Use() {
		Player p = this.GetPlayer();
		p.AddTemp(1);
		p.DeleteItem(this);
	}
}
