package projlab;

/**
 * Extends the Player class
 * Implements the Explorer character
 */
public class Explorer extends Player{
	
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
			int nMaxCharacters = neighbour.GetMaxCharacter(); //Ezzel kéne csinálni valamit
			this.AddWork(-1);
		}
	}
}
