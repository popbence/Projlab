package projlab;

/**
 * Represent the igloo's behavior
 */
public class Igloo {
	
	/**
	 * the igloo's current health
	 */
	private int health = 5;
	
	
	/**
	 * Decreases the igloo's health by the given amount
	 * @param s The given amount
	 * @return true if the igloo is completely destroyed, false if it's not
	 */
	public boolean Destroy(int s) {
		health -= s;
		return (health <= 0);
	}
	
	public boolean Invadable() {
		return false;
	}
}
