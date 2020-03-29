package projlab;

public class Hole extends Field{
	
	public void AddPlayer(Player p) {
		System.out.println(objName + ".AddPlayer(" + p.GetObjName() +")");
		
		this.GetPlayers().add(p);
		p.SetField(this);
		p.SetTempToOne();
		p.SetDrowning(1);
		p.EndRound();
	}
	
	public void RemovePlayer(Player p) {
		System.out.println(objName + ".RemovePlayer(" + p.GetObjName() +")");
		
		this.GetPlayers().remove(p);
	}
	
	public int GetMaxPlayer() {
		System.out.println(objName + ".GetMaxplayer()");
		
		return 0;
	}
	
	public void BuildIgloo(Igloo i) {
		System.out.println(objName + ".BuildIgloo(" + i.GetObjName() +")");
	}
}
