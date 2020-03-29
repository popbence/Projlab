package projlab;

public class Suit extends Item{ //TODO: Comments
	public void Use() {
		Writer.Write(objName + ".Use()");

		GetPlayer().SetDrowning(-1);

		Writer.Deregister(objName);
	}
}
