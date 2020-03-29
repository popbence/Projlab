package projlab;

import java.util.ArrayList;

/**
 * Implements the base unit of the game space
 */
public class Field {
	/**
	 * The layers of snow on the field
	 */
	private int snow;
	/**
	 * The igloo thats built on the field
	 */
	private Igloo igloo;
	/**
	 * The list of players standing on the field
	 */
	private ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * The item, that buried in the field
	 */
	private Item item;
	/**
	 * List of the neighbourning fields
	 */
	private ArrayList<Field> neighbours = new ArrayList<Field>(); //kelett, hogy a tesztben fusson a .size() miatt
	/**
	 * It's necessary for the skeleton so the object name can be printed out
	 */
	protected String objName;
	
	/**
	 * Adds p player to the list of players
	 * @param p The player to be added
	 */
	public void AddPlayer(Player p) {
		Writer.Write(objName + ".AddPlayer(" + p.GetObjName() +")");
		Writer.Deregister(objName);
		
		players.add(p);
	}
	
	/**
	 * Returns the field's neighbour in the given direction 
	 * @param dir The direction
	 * @return The neighbour field in dir direction
	 */
	public Field GetNeighbour(int dir) {
		Writer.Write(objName + ".GetNeighbour(" + dir +")");
		
		return neighbours.get(dir);
	}
	
	/**
	 * Removes the given player from the list of players
	 * @param p The player to be removed
	 */
	public void RemovePlayer(Player p) {
		Writer.Write(objName + ".RemovePlayer(" + p.GetObjName() +")");
		Writer.Deregister(objName);
		
		players.remove(p);
	}
	
	/**
	 * Adds s amount of snow to the field
	 * @param s The amount of snow
	 */
	public void AddSnow(int s) {
		Writer.Write(objName + ".AddSnow(" + s +")");
		
		if(igloo != null) {
			boolean destroy  = igloo.Destroy(s);
			if(destroy) {
				this.RemoveIgloo();
			}
		}
		
		snow += s;
		
		if(igloo == null) {
			for(Player p : players) {
				p.AddTemp(-1);
			}
		}
		Writer.Deregister(objName);
	}
	
	/**
	 * Returns the max amount of players the field can safely carry
	 * Because this is a stable field this will return -1
	 * @return The max number of players the field can carry
	 */
	public int GetMaxPlayers() {
		Writer.Write(objName + ".GetMaxPlayers()");
		return -1;
	}
	
	/**
	 * Add i igloo to the field
	 * @param i The igloo
	 */
	public void BuildIgloo(Igloo i) {
		Writer.Write(objName + ".UseAbility(" + i.GetObjName() +")");
		Writer.Deregister(objName);
		this.igloo = i;
	}
	
	/**
	 * Destroys the igloo that is on the field
	 */
	public void RemoveIgloo() {
		Writer.Write(objName + ".RemoveIgloo()");
		Writer.Deregister(objName);
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
		Writer.Write(objName + ".SetNeighbour(" + dir + "," + f.GetObjName() + ")");
		
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
		Writer.Deregister(objName);
	}
	
	/**
	 * Removes the item that is burried in the field
	 */
	public void RemoveItem() {
		Writer.Write(objName + ".RemoveItem()");
		Writer.Deregister(objName);
		this.item = null;
	}
	
	/**
	 * Returns the item that is burried in the field
	 * @return The burried item
	 */
	public Item GetItem() {
		Writer.Write(objName + ".GetItem()");
		return item;
	}
	
	/**
	 * Returns the list of players standing on the field
	 * @return The list of players
	 */
	public ArrayList<Player> GetPlayers(){
		Writer.Write(objName + ".GetPlayers()");
		return players;
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
}
