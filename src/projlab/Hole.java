package projlab;
 /**
  * Extends the Field class
  * Represents a hole in the game space
  */
public class Hole extends Field{
	
	/**
	 * Adds p Player to the list of players that arte in the hole 
	 * @param p The player to be added to the hole
	 */
	public void AddCharacter(Character c) {
		super.AddCharacter(c);
		c.FellInWater();
	}
	
	/**
	 * Removes the player from the hole
	 * @param p The player to be removed from the hole
	 */
	public void RemoveCharacter(Character c) {
		this.GetCharacters().remove(c);
	}
	
	/**
	 * Returns the max amount of players the field can safely carry
	 * @return The max number of players the field can carry
	 */
	public int GetMaxCharacter() {
		return 0;
	}
	 /**
	  * Doesn't do anything because an igloo can't be built on a hole
	  */
	public void BuildIgloo(Igloo i) {
	}
}
