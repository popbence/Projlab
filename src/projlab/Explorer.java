package projlab;

/**
 * Extends the Player class
 * Implements the Explorer character
 */
public class Explorer extends Player{
	
	/**
	 * Defines the Player class' abstract UseAbility() method
	 * Displays the number of players that can stand on the neighbouring field in 
	 * dir direction
	 * @param The direction of the neighbour field
	 */
	public void UseAbility(int dir) {
		Writer.Write(objName + ".UseAbility(" + dir +")");
		
		Field neighbour = this.GetField().GetNeighbour(dir);
		int nMaxPlayers = neighbour.GetMaxPlayers();
	}
}
