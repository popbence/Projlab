package projlab;

/**
 * Abstract class, defines the common behavior for the items
 */
public abstract class Item {
	private Player player;
	
	
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
		player = p;
	}
	
	/**
	 * Get the player which the item belongs to
	 * @return player
	 */
	public Player GetPlayer() {
		return player;
	}
	
}
