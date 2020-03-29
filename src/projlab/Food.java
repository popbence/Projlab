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
		Writer.Write(objName + ".Use()");
		Writer.Deregister(objName);
		Writer.DummyGive("d");
		
		Player p = this.GetPlayer();
		
		Writer.Deregister("d");
		p.AddTemp(1);
		p.DeleteItem(this);
	}
}
