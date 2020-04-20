package projlab;

import java.util.ArrayList;

/**
 * Implements the base unit of the game space
 */
public class Field {
	/**
	 * The layers of snow on the field
	 */
	protected int snow = 0;
	/**
	 * The igloo thats built on the field
	 */
	protected Igloo igloo;
	/**
	 * The list of players standing on the field
	 */
	private ArrayList<Character> characters = new ArrayList<Character>();
	/**
	 * The item, that buried in the field
	 */
	private Item item;
	/**
	 * List of the neighbourning fields
	 */
	private ArrayList<Field> neighbours = new ArrayList<Field>();
	
	private boolean deadly = false;
	
	/**
	 * Adds p player to the list of players
	 * @param p The player to be added
	 */
	public void AddCharacter(Character c) {
		c.SetField(this);
		characters.add(c);
		if(deadly) {
			Controller.GameOver();
		}
	}
	
	/**
	 * Returns the field's neighbour in the given direction 
	 * @param dir The direction
	 * @return The neighbour field in dir direction
	 */
	public Field GetNeighbour(int dir) {
		return neighbours.get(dir);
	}
	
	/**
	 * Removes the given player from the list of players
	 * @param p The player to be removed
	 */
	public void RemoveCharacter(Character c) {
		characters.remove(c);
	}
	
	/**
	 * Adds s amount of snow to the field
	 * @param s The amount of snow
	 */
	public void AddSnow(int s) {
		snow += s;
		if(igloo != null) {
			boolean destroy  = igloo.Destroy(s);
			if(destroy) {
				this.RemoveIgloo();
			}
		}
		if(igloo == null && s > 0){
			for(Character c : characters) {
				c.SnowFall();
			}
		}
	}
	
	/**
	 * Returns the max amount of players the field can safely carry
	 * Because this is a stable field this will return -1
	 * @return The max number of players the field can carry
	 */
	public int GetMaxCharacters() {
		return -1;
	}
	
	/**
	 * Add i igloo to the field
	 * @param i The igloo
	 */
	public void BuildIgloo(Igloo i) {
		this.igloo = i;
	}
	
	/**
	 * Destroys the igloo that is on the field
	 */
	public void RemoveIgloo() {
		this.igloo = null;
	}
	
	/**
	 * Sets the neighbouring field in the dir direction
	 * The given direction matches the index in the neighbours list
	 * It may contain null values
	 * @param dir The direction to set the neighbour in
	 * @param f The neighbouring field
	 */
	public void SetNeighbour(int dir, Field f) {
		int n = neighbours.size();
		for(int i = 0; i < (dir + 1 - n); i++) {
			if(n == 0) {
				neighbours.add(null);
			}
			if(neighbours.get(i) == null) {
				neighbours.add(null);
			}
		}
		neighbours.set(dir, f);
	}
	
	/**
	 * Removes the item that is buried in the field
	 */
	public void RemoveItem() {
		this.item = null;
	}
	
	/**
	 * Returns the item that is buried in the field
	 * @return The buried item
	 */
	public Item GetItem() {
		return item;
	}
	
	public void SetItem(Item i) {
		item = i;
	}
	
	/**
	 * Returns the list of players standing on the field
	 * @return The list of players
	 */
	public ArrayList<Character> GetCharacters(){
		return characters;
	}
	
	public void SetDeadly() {
		deadly = !deadly;
	}
	
	public Igloo GetIgloo() {
		return igloo;
	}
}
