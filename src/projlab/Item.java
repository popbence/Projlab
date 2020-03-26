package projlab;

public abstract class Item {
	private Player player;
	
	protected String objName;
	
	public abstract void Use();
	
	public void SetPlayer(Player p) {}
	
}
