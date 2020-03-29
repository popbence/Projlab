package projlab;

public class Shovel extends Item{ // TODO: Comments
	public void Use() {
		Writer.Write(objName + ".Use()");;

		Writer.Deregister(objName);
		Writer.DummyGive("d");
		
		Player p = this.GetPlayer();
		
		Writer.Deregister(objName);
		
		Field f = p.GetField();
		
		Writer.Deregister("d");
		
		f.AddSnow(-2);
		
		Writer.Deregister("e");
		Writer.DummyGive("d");
	}
}
