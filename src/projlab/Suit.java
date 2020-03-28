package projlab;

public class Suit extends Item{
	public void Use() {

		String methodCall = objName + "." + Main.GetMethodName() + "()";
		System.out.println(methodCall);

		GetPlayer().SetDrowning(-1);
	}
}
