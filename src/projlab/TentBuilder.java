package projlab;

public class TentBuilder extends Item{
	
	public void Use() {
		Player p = this.GetPlayer();
		Field f = p.GetField();
		Tent t = new Tent();
		f.BuildIgloo(t);
	}
}
