package projlab;

public class Shovel extends Item{ // TODO: Comments
	public void Use() {
		Writer.Write(objName + ".Use()");;

		Field f = GetPlayer().GetField();
		f.AddSnow(-2);
		Writer.Deregister("e");
		Writer.Deregister(objName);
	}
}
