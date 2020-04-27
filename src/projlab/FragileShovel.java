package projlab;
/**
 * Defines the behaviour of the FragileShovel Item
 *
 */
public class FragileShovel extends Item{
	/**
	 * Uses left
	 */
	int usesLeft = 3;
	/**
	 * Digs with FragileShovel. With every use,
	 * the usesLeft attribute gets reduced.
	 */
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
