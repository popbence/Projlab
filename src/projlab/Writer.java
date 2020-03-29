package projlab;

import java.util.ArrayList;

class Writer 
{ 
	private static Writer single_instance=null; 

 	private static ArrayList<String> usednames;
	private static int indent;

	private Writer() 
	{ 
		usednames = new ArrayList<String>();
		indent = 0; 
	} 

	public static Writer Writer() 
	{ 
		if (single_instance == null) 
     	{ 
         	single_instance = new Writer(); 
     	} 
     	return single_instance; 
	} 
	
	public static void Write(String name) {
		String objName = name.split("\\.")[0];
		if(usednames.isEmpty()) {
			usednames.add(objName);
		}
		else if(!usednames.get(usednames.size()-1).equalsIgnoreCase(objName)) {
			usednames.add(objName);
		}
		for(int i=0;i<usednames.lastIndexOf(objName);i++) {
			System.out.print("\t");
		}
		System.out.print(name + "\n");
	}
	
	public static void Deregister(String name) {
		usednames.remove(usednames.lastIndexOf(name));
	}
	
	public static void wipe() {
		indent = 0;
		usednames.clear();
	}
} 
