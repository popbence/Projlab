package projlab;

public abstract class Item {
	private Player player;
	
	protected String objName;
	
	public abstract void Use();
	
	public void SetPlayer(Player p) {
		System.out.println(objName + "SetPlayer(" + p.GetObjName()+")");
		player = p;
	}
	
	public Player GetPlayer() {
		System.out.println(objName + "GetPlayer()");
		return player;
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public void SetObjName(String name) {
		objName = name;
	}
}
