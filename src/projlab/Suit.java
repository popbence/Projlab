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
		Writer.Write(objName + ".Use()");

		Writer.Deregister(objName);
		Writer.DummyGive("d");     
		
		Player p = this.GetPlayer();
		
		Writer.Deregister("d");
		
		p.SetDrowning(-1);
	
		
	}
}
