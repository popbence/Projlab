package projlab;

/**
 * Extends the Item class
 * Implements the Shovel item
 */
public class Shovel extends Item {

	/**
	 * Removes 2 units of snow
	 * from the field of the user
	 */
	public void Use() {
		
		Player p = this.GetPlayer();
		
		Field f = p.GetField();
		
		f.AddSnow(-2);
	}
}
