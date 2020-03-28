package projlab;

import java.util.ArrayList;

public abstract class Player {
	private int work;
	private int temperature;
	private int drowning;
	private Field field;
	private ArrayList<Item> items;
	protected String objName;
	
	public void Step(int dir) {
		System.out.println(objName + ".Step("+dir+")");
		Field f2 = field.GetNeighbour(dir);
		if(f2 != null) {
			field.RemovePlayer(this);
			f2.AddPlayer(this);
			this.AddWork(-1);
		}
	}
	
	public void UseItem(int item) {
		System.out.println(objName + ".UseItem(" + item +")");
		Item i = items.get(item);
		i.Use();
		this.AddWork(-1);
		
	}
	
	public abstract void UseAbility(int dir);
	
	public void AddItem(Item item) {
		System.out.println(objName + ".AddItem("+ item.GetObjName() +")");
		items.add(item);
	}
	
	public void AddTemp(int t) {
		System.out.println(objName + ".AddTemp(" + t +")");
		temperature += t;
		if(temperature <= 0)
			Controller.GameOver();
	}
	
	public void AddWork(int w) {
		System.out.println(objName + ".AddWork(" + w +")");
		work += w;
		if(work < 0)
			work = 0;
	}
	
	public void SetTempToOne() {
		System.out.println(objName + ".SetTempToOne()");
		temperature = 1;
	}
	
	public void SetWork(int w) {
		System.out.println(objName + ".SetWork("+w+")");
		work = w;
	}
	
	public void Dig() {
		System.out.println(objName +".Dig()");
		field.AddSnow(-1);
		this.AddWork(-1);
	}
	
	public void Pick() {
		System.out.println(objName + ".Pick()");
		Item i = field.GetItem();
		if (i != null) {
			field.RemoveItem();
			i.SetPlayer(this);
			this.AddWork(-1);
		}
	}
	
	public void EndRound() {
		System.out.println(objName + ".EndRound()");
		work = 0;
		Controller.RoundCheck();
	}
	
	public void SetField(Field f) {
		System.out.println(objName + ".SetField(" + f.GetObjName() +")");
		this.field = f;
	}
	
	public Field GetField() {
		System.out.println(objName + ".GetField()");
		return field;
	}
	
	public void SetDrowning(int number) {
		System.out.println(objName + ".SetDrowning(" + number +")");
		if(drowning == 0 && number == 1)
			drowning = 1;
		if(drowning == 1 && number == 2)
			drowning = 2;
		if(number == -1)
			drowning = -1;
	}

	public int GetDrowning(){
		System.out.println(objName + ".GetDrowning()");
		return drowning;
	}
	
	public void DeleteItem(Item item) {
		System.out.println(objName + ".DeleteItem(" + item.GetObjName() +")");
		items.remove(item);
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public void SetObjName(String name) {
		objName = name;
	}
	
	public int GetWork() {
		System.out.println(objName + ".GetWork()");
		return work;
	}
	
	public ArrayList<Item> GetItems(){
		System.out.println(objName + ".GetItems()");
		return items;
	}
}
