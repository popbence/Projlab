package projlab;

public class Suit extends Item{
	public void Use() {
		GetPlayer().SetDrowning(-1);
	}
}
