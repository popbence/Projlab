package projlab;

public class Eskimo extends Player{
	public void UseAbility(int dir) {
		System.out.println(objName + ".UseAbility(" + dir +")");
		
		Igloo i = new Igloo();
		this.GetField().BuildIgloo(i);
		this.AddWork(-1);
	}
}
