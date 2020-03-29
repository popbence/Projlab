package projlab;

public class Suit extends Item{ //TODO: Comments
	public void Use() {
		Writer.Write(objName + ".Use()");

		Writer.Deregister(objName); // Skeleton last minute fixes
		Writer.DummyGive("d");     
		
		Player p = this.GetPlayer();
		
		Writer.Deregister("d");
		
		p.SetDrowning(-1);
	
		
	}
}
