package projlab;

import java.util.ArrayList;
/**
 * Abstract class, defines the common behavior for a Playable character
 */
public abstract class Player {
	
	/**
	 * Work points
	 * If it runs out the player's turn ends
	 */
	private int work;
	
	/**
	 * Temperature. If it runs out a the player dies and the game ends
	 */
	private int temperature;
	
	/**
	 * The state of the player
	 * if the value 0, it means he is not in the water but doesn't have a suit
	 * The value changes to 1 if the player falls into the water and doesn't have a suit equipped
	 * The value changes to 2 if the player stays in the water for the next round
	 * The value changes to -1 if the player equips the suit
	 */
	private int drowning;
	
	/**
	 * The field where the player is at right now
	 */
	private Field field;
	
	/**
	 * The player's inventory
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
	
	/**
	 * Moves the player to a given direction
	 * @param dir The direction where the player wants to move
	 */
	public void Step(int dir) {
		Field f2 = field.GetNeighbour(dir);
		if(f2 != null) {
			field.RemovePlayer(this);
			f2.AddPlayer(this);
			
			this.AddWork(-1);
		}
	}
	
	/**
	 * The player uses one of the items that can be found at the index item
	 * @param item The index of the item which the player wants to use
	 */
	public void UseItem(int item) {
		Item i = items.get(item);
		i.Use();
		this.AddWork(-1);
	}
	
	/**
	 * The player uses his/her ability
	 * This method must be overwritten in the class Eskimo and Explorer
	 */
	public abstract void UseAbility(int dir);
	
	/**
	 * Add the item to the inventory
	 * @param item The item that will be added to the inventory
	 */
	public void AddItem(Item item) {
		items.add(item);
	}
	
	/**
	 * Increases the temperature points by t
	 * @param t The amount of the temperature points being added
	 */
	public void AddTemp(int t) {
		temperature += t;
		if(temperature <= 0)
			Controller.GameOver();
	}
	
	/**
	 * Increases the work points by w
	 * @param w The amount of the work points being added
	 */
	public void AddWork(int w) {
		work += w;
		if(work < 0)
			work = 0;
	}
	
	/**
	 * Set the temperature to 1
	 */
	public void SetTempToOne() {
		temperature = 1;
	}
	
	/**
	 * Set the work points to the given amount
	 * @param w The set amount
	 */
	public void SetWork(int w) {
		work = w;
	}
	
	/**
	 * Removes 1 snow pile from the field where the player at
	 */
	public void Dig() {
		field.AddSnow(-1);
		
		this.AddWork(-1);
	}
	
	/**
	 * The player picks up the item
	 */
	public void Pick() {
		Item i = field.GetItem();
		if (i != null) {
			field.RemoveItem();
			i.SetPlayer(this);
			
			this.AddWork(-1);
		}
		
	}
	
	/**
	 * The player ends his own turn
	 */
	public void EndRound() {
		work = 0;
		Controller.RoundCheck();
	}
	
	/**
	 * Sets the player's position
	 * @param f The position
	 */
	public void SetField(Field f) {
		this.field = f;
	}
	
	/**
	 * Gets the field where the player currently is at
	 * @return field
	 */
	public Field GetField() {
		return field;
	}
	
	/**
	 * Set the drowning value to the given value
	 * @param number The value
	 */
	public void SetDrowning(int number) {
		switch(number) {
		case 0:
			if(drowning != -1)
				drowning = 0;
		break;
		case 1: 
			if(drowning == 0)
				drowning = 1;
		break;
		case 2:
			if(drowning == 1)
				drowning = 2;
			else
				if(drowning == 2)
					Controller.GameOver();
		break;
		case -1:
			drowning = -1;
		break;
		default: break;
		}
	}
	
	/**
	 * Get the drowning value
	 * @return drowning
	 */
	public int GetDrowning(){
		return drowning;
	}
	
	/**
	 * Deletes an item from the inventory
	 * @param item The item that will be removed
	 */
	public void DeleteItem(Item item) {
		items.remove(item);
	}
	
	
	
	/**
	 * Returns the work points
	 * @return work
	 */
	public int GetWork() {
		return work;
	}
	
	/**
	 * Returns the item list
	 * @return items
	 */
	public ArrayList<Item> GetItems(){
		return items;
	}
}
