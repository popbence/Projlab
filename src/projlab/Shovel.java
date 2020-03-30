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
		Writer.Write(objName + ".Use()");

		Writer.Deregister(objName);
		Writer.DummyGive("d");
		
		Player p = this.GetPlayer();
		
		Writer.Deregister(objName);
		
		Field f = p.GetField();
		
		Writer.Deregister("d");
		
		f.AddSnow(-2);
		
		Writer.Deregister("e");
		Writer.DummyGive("d");
	}
}
