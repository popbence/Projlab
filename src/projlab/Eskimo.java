package projlab;

/**
 * Extends the Player class
 * Implements the Eskimo character
 */
public class Eskimo extends Player{
	
	/**
	 * Defines the Player class' abstract UseAbility() method
	 * Builds an igloo and gives it to the field the player is standing on
	 * @param Not used
	 */
	public void UseAbility(int dir) {
		Writer.Write(objName + ".UseAbility(" + dir +")");
		
		Igloo i = new Igloo();
		this.GetField().BuildIgloo(i);
		this.AddWork(-1);
	}
}
