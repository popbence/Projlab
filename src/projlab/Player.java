package projlab;

import java.util.ArrayList;

public abstract class Player {
	private int work;
	private int temperature;
	private int drowning;
	private Field field;
	private ArrayList<Item> items;
	protected String objName;
	
	public void Step(int dir) {
		
	}
	
	public void UseItem(int item) {
		
	}
	
	public abstract void UseAbility(int dir);
	
	public void AddItem(Item item) {
		
	}
	
	public void AddTemp(int t) {
		
	}
	
	public void AddWork(int w) {
		
	}
	
	public void SetTempToOne() {
		
	}
	
	public void SetWork(int w) {
		
	}
	
	public void Dig() {
		
	}
	
	public void Pick() {
		
	}
	
	public void voidEndRound() {
		
	}
	
	public void SetField(Field f) {
		
	}
	
	public Field GetField() {
		return field;
	}
	
	public void SetDrowning(int number) {
		
	}
	
	public void DeleteItem(Item item) {
		
	}
}
