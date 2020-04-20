package projlab;
/**
 * 
 * 
 */
public abstract class Character {
	private Field field;
	
	public abstract void Step(int dir);
	
	public void SetField(Field f) {
		field = f;
	}
	
	public Field GetField() {
		return field;
	}
	
	public abstract void FellInWater();
	
	public abstract boolean Rescuable();
	
	public abstract void SnowFall();
	
}
