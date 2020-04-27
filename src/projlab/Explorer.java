package projlab;

/**
 * Extends the Player class
 * Implements the Explorer character
 */
public class Explorer extends Player{
	/**
	 * The last explored field's capacity
	 */
	int lastExploredFieldCapacity = 0;
	/**
	 * ctor
	 */
	public Explorer() {
		SetTemp(4);
		SetWork(4);
	}
	/**
	 * Defines the Player class' abstract UseAbility() method
	 * Displays the number of players that can stand on the neighbouring field in 
	 * dir direction
	 * @param The direction of the neighbour field
	 */
	public void UseAbility(int dir) {
		if(GetWork() > 0) {
			Field f = this.GetField();
			Field neighbour = f.GetNeighbour(dir);
			lastExploredFieldCapacity = neighbour.GetMaxCharacter(); //Ezzel k�ne csin�lni valamit
			this.AddWork(-1);
		}
	}
	/**
	 * Returns with the last explored field's capacity
	 * @return lastExploredFieldCapacity
	 */
	public int GetLastExploredFieldCapacity() {
		return lastExploredFieldCapacity;
	}
}
