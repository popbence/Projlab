package projlab;

public class Shovel extends Item{
	public void Use() {
		String methodCall = objName + "." + Main.GetMethodName() + "()";
		System.out.println(methodCall);

		Field f = GetPlayer().GetField();
		f.AddSnow(-2);
	}
}
