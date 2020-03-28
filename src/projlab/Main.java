package projlab;

public class Main {

	public static String GetMethodName(){
		/*
		Returns the name of the method where this function was called.
		getStackTrace()[0] -> getStackTrace, getStackTrace()[1] -> GetMethodName, getStackTrace()[2] -> caller
		Was tested on the virtual machine the program's supposed to run on.
		 */
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
