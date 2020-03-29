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
	 * It's necessary for the skeleton so the object name can be printed out
	 */
	protected String objName;
	
	/**
	 * Moves the player to a given direction
	 * @param dir The direction where the player wants to move
	 */
	public void Step(int dir) {
		Writer.Write(objName + ".Step("+dir+")");
		Field f2 = field.GetNeighbour(dir);
		if(f2 != null) {
			field.RemovePlayer(this);
			f2.AddPlayer(this);
			
			Writer.Deregister(objName); // Skeleton last minute fixes
			Writer.DummyGive("d");		//
			
			this.AddWork(-1);
		}
	}
	
	/**
	 * The player uses one of the items that can be found at the index item
	 * @param item The index of the item which the player wants to use
	 */
	public void UseItem(int item) {
		Writer.Write(objName + ".UseItem(" + item +")");
		Item i = items.get(item);
		i.Use();
		Writer.Deregister(objName);
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
		Writer.Write(objName + ".AddItem("+ item.GetObjName() +")");
		Writer.Deregister(objName);
		items.add(item);
	}
	
	/**
	 * Increases the temperature points by t
	 * @param t The amount of the temperature points being added
	 */
	public void AddTemp(int t) {
		Writer.Write(objName + ".AddTemp(" + t +")");
		temperature += t;
		if(temperature <= 0)
			Controller.GameOver();
		Writer.Deregister(objName);
	}
	
	/**
	 * Increases the work points by w
	 * @param w The amount of the work points being added
	 */
	public void AddWork(int w) {
		Writer.Write(objName + ".AddWork(" + w +")");
		work += w;
		if(work < 0)
			work = 0;
		Writer.Deregister(objName);
	}
	
	/**
	 * Set the temperature to 1
	 */
	public void SetTempToOne() {
		Writer.Write(objName + ".SetTempToOne()");
		Writer.Deregister(objName);
		temperature = 1;
	}
	
	/**
	 * Set the work points to the given amount
	 * @param w The set amount
	 */
	public void SetWork(int w) {
		Writer.Write(objName + ".SetWork("+w+")");
		Writer.Deregister(objName);
		work = w;
	}
	
	/**
	 * Removes 1 snow pile from the field where the player at
	 */
	public void Dig() {
		Writer.Write(objName +".Dig()");
		field.AddSnow(-1);
		
		Writer.Deregister(objName); // Skeleton last minute fixes
		Writer.DummyGive("d");		//
		
		this.AddWork(-1);
	}
	
	/**
	 * The player picks up the item
	 */
	public void Pick() {
		Writer.Write(objName + ".Pick()");
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
		Writer.Write(objName + ".EndRound()");
		work = 0;
		Controller.RoundCheck();
		Writer.Deregister(objName);
	}
	
	/**
	 * Sets the player's position
	 * @param f The position
	 */
	public void SetField(Field f) {
		Writer.Write(objName + ".SetField(" + f.GetObjName() +")");
		Writer.Deregister(objName);
		this.field = f;
	}
	
	/**
	 * Gets the field where the player currently is at
	 * @return field
	 */
	public Field GetField() {
		Writer.Write(objName + ".GetField()");
		return field;
	}
	
	/**
	 * Set the drowning value to the given value
	 * @param number The value
	 */
	public void SetDrowning(int number) {
		Writer.Write(objName + ".SetDrowning(" + number +")");
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
		Writer.Deregister(objName);
	}
	
	/**
	 * Get the drowning value
	 * @return drowning
	 */
	public int GetDrowning(){
		Writer.Write(objName + ".GetDrowning()");
		Writer.Deregister(objName);
		return drowning;
	}
	
	/**
	 * Deletes an item from the inventory
	 * @param item The item that will be removed
	 */
	public void DeleteItem(Item item) {
		Writer.Write(objName + ".DeleteItem(" + item.GetObjName() +")");
		Writer.Deregister(objName);
		items.remove(item);
	}
	
	/**
     * Skeleton only
     * Returns the name of the object
     * @return the name of the object
     */
	public String GetObjName() {
		return objName;
	}
	
	/**
     * Skeleton only
     * Sets the name of the object
     * @param name the name of the object
     */
	public void SetObjName(String name) {
		objName = name;
	}
	
	/**
	 * Returns the work points
	 * @return work
	 */
	public int GetWork() {
		Writer.Write(objName + ".GetWork()");
		Writer.Deregister(objName);
		return work;
	}
	
	/**
	 * Returns the item list
	 * @return items
	 */
	public ArrayList<Item> GetItems(){
		Writer.Write(objName + ".GetItems()");
		Writer.Deregister(objName);
		return items;
	}
}
