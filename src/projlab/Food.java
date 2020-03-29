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
		
		this.GetPlayer().AddTemp(1);
		this.GetPlayer().DeleteItem(this);
		Writer.Deregister(objName);
	}
}
