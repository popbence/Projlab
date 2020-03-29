package projlab;

public class Suit extends Item{ //TODO: Comments
	public void Use() {

		String methodCall = objName + "." + Main.GetMethodName() + "()";
		System.out.println(methodCall);

		GetPlayer().SetDrowning(-1);
	}
}
