package projlab;

/**
 * Abstract class, defines the common behavior for the items
 */
public abstract class Item {
	private Player player;
	
	/**
	 * It's necessary for the skeleton so the object name can be printed out
	 */
	protected String objName;
	
	/**
	 * The item being used
	 * Every child must overwrite this method
	 */
	public abstract void Use();
	
	/**
	 * Set to the player which the item belongs to
	 * @param p The player
	 */
	public void SetPlayer(Player p) {
		Writer.Write(objName + ".SetPlayer(" + p.GetObjName()+")");
		Writer.Deregister(objName);
		player = p;
	}
	
	/**
	 * Get the player which the item belongs to
	 * @return player
	 */
	public Player GetPlayer() {
		Writer.Write(objName + ".GetPlayer()");
		return player;
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
