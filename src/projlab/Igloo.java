package projlab;

public class Igloo {
	private int health;
	private String objName;
	
	public boolean Destroy(int s) {
		System.out.println(objName + ".Destroy(" + s +")");
		health -= s;
		if(health <= 0) {
			return true;
		}
		return false;
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public void SetObjName(String name) {
		objName = name;
	}
	
}
