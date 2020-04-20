package projlab;

public abstract class Characters {
	private Field field;
	
	public abstract void Step(int dir);
	
	public void SetField(Field f) {
		
	}
	
	public Field GetField() {
		return field;
	}
	
	public abstract void FellInWater();
	
	public abstract boolean Rescuable();
	
}
