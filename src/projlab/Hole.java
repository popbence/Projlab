package projlab;
 /**
  * Extends the Field class
  * Represents a hole in the game space
  */
public class Hole extends Field{
	
	/**
	 * Adds p Player to the list of players that arte in the hole 
	 * @param p The player to be added to the hole
	 */
	public void AddPlayer(Player p) {
		Writer.Write(objName + ".AddPlayer(" + p.GetObjName() +")");
		
		Writer.DummyGive(objName);
		this.GetPlayers().add(p);
		p.SetField(this);
		p.SetTempToOne();
		p.SetDrowning(1);
		p.EndRound();
		Writer.Deregister(objName);
		
	}
	
	/**
	 * Removes the player from the hole
	 * @param p The player to be removed from the hole
	 */
	public void RemovePlayer(Player p) {
		Writer.Write(objName + ".RemovePlayer(" + p.GetObjName() +")");
		Writer.Deregister(objName);
		this.GetPlayers().remove(p);
	}
	
	/**
	 * Returns the max amount of players the field can safely carry
	 * @return The max number of players the field can carry
	 */
	public int GetMaxPlayer() {
		Writer.Write(objName + ".GetMaxplayer()");
		Writer.Deregister(objName);
		return 0;
	}
	 /**
	  * Doesn't do anything because an igloo can't be built on a hole
	  */
	public void BuildIgloo(Igloo i) {
		Writer.Write(objName + ".BuildIgloo(" + i.GetObjName() +")");
		Writer.Deregister(objName);
	}
}
