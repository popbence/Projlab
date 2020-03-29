package projlab;

/**
 * Represent the igloo's behavior
 */
public class Igloo {
	
	/**
	 * the igloo's current health
	 */
	private int health;
	
	/**
	 * It's necessary for the skeleton so the object name can be printed out
	 */
	private String objName;
	
	/**
	 * Decreases the igloo's health by the given amount
	 * @param s The given amount
	 * @return true if the igloo is completely destroyed, false if it's not
	 */
	public boolean Destroy(int s) {
		System.out.println(objName + ".Destroy(" + s +")");
		health -= s;
		if(health <= 0) {
			return true;
		}
		return false;
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
