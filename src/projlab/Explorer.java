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
		Writer.Deregister(objName);
		Writer.DummyGive("d");
		
		Field f = this.GetField();
		Writer.Deregister("e");
		Field neighbour = f.GetNeighbour(dir);
		int nMaxPlayers = neighbour.GetMaxPlayers();
		this.AddWork(-1);
	}
}
