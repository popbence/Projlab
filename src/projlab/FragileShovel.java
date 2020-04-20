package projlab;

public class FragileShovel extends Item{
	int usesLeft = 3;
	
	public void Use() {
		Player p = this.GetPlayer();
		Field f = p.GetField();
		f.AddSnow(-2);
		usesLeft--;
		if(usesLeft == 0) {
			p.DeleteItem(this);
		}
	}
}
