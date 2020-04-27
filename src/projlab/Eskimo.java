package projlab;

/**
 * Extends the Player class
 * Implements the Eskimo character
 */
public class Eskimo extends Player{
	
	/**
	 * ctor
	 */
	public Eskimo() {
		SetTemp(5);
		SetWork(4);
	}
	/**
	 * Defines the Player class' abstract UseAbility() method
	 * Builds an igloo and gives it to the field the player is standing on
	 * @param Not used
	 */
	public void UseAbility(int dir) {
		if(GetWork() > 0) {
			Igloo i = new Igloo();
			Field f = this.GetField();
			f.BuildIgloo(i);
			this.AddWork(-1);
		}
	}
}
