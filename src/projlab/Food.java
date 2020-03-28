package projlab;

public class Food extends Item{
	public void Use() {
		System.out.println(objName + ".Use()");
		
		this.GetPlayer().AddTemp(1);
		this.GetPlayer().DeleteItem(this);
	}
}
