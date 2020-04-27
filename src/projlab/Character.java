package projlab;
/**
 * Abstract class defines the common behavior of a Character
 * 
 */
public abstract class Character {
	/**
	 * Store the position of the character
	 */
	private Field field;
	/**
	 * Abstact method, moves the Character to the given direction
	 * @param dir the given direction
	 */
	public abstract void Step(int dir);
	/**
	 * Set the position of the Character to the given Field
	 * @param f the given Field
	 */
	public void SetField(Field f) {
		field = f;
	}
	/**
	 * Returns with the field
	 * @return field
	 */
	public Field GetField() {
		return field;
	}
	/**
	 * Abstract method, modifies the attributes when the Character fells in water
	 */
	public abstract void FellInWater();
	/**
	 * Abstract method, return true if the Character can be saved with a rope
	 * @return 
	 */
	public abstract boolean Rescuable();
	/**
	 * Abstract method, modifies the Temperature of the Character when it gets caught
	 * by snowstorm
	 */
	public abstract void SnowFall();
	
}
