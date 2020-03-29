package projlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Writer writer;
	
	public static void main(String[] args){
		writer = Writer.Writer();
        Welcomer();
	}
	
	public static void Welcomer() {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
        
		System.out.println("Welcome to the Jégmezõ game skeleton program\n"
				+ "please, select a Test case you would like to run:\n"
				+ "1. Player moves\n"
				+ "2. Player steps on hole\n"
				+ "3. Player digs\n"
				+ "4. Player uses food\n"
				+ "5. Player uses suit\n"
				+ "6. Player uses rope\n"
				+ "7. Player uses shovel\n"
				+ "8. Player uses parts\n"
				+ "9. Player picks up item\n"
				+ "10. Eskimo uses ability\n"
				+ "11. Explorer uses ability\n"
				+ "12. Unstable field flips\n"
				+ "13. Unstable field flips back\n"
				+ "14. Player ends turn\n");
		 
		boolean error=false;
		do
		{
			try
			{
				Scanner scan = new Scanner(System.in);

				System.out.print("Your answer: ");
				int x = scan.nextInt();
				if(x>14) {
					System.out.print("Please, enter a valid case number!\n");
					error = true;
					continue;
				}
				error = false;
				TestStarter(x);
				System.out.println("do you want to run another test?(Y/N):");
				String s = scan.next();
				if(s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("yes")) 
					error=true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please, enter only an integer!\n");
				error = true;
			}
		}
		while(error);
	}
	
	private static void TestStarter(int tcase) {
		switch(tcase) {
		case 1: Test1();break;
		case 2: Test2();break;
		case 3: Test3();break;
		case 4: Test4();break;
		case 5: Test5();break;
		case 6: Test6();break;
		case 7: Test7();break;
		case 8: Test8();break;
		case 9: Test9();break;
		case 10: Test10();break;
		case 11: Test11();break;
		case 12: Test12();break;
		case 13: Test13();break;
		case 14: Test14();break;
		default: break;
		}
	}
	
	private static void Test1() {
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Field f1 = new Field();
		Field f2 = new Field();
		e.SetObjName("e");
		f1.SetObjName("f1");
		f2.SetObjName("f2");
		e.SetField(f1);
		f1.AddPlayer(e);
		f1.SetNeighbour(1, f2);
		Writer.wipe();
		System.out.println("test 1:");
		e.Step(1);
	}
	// Fel lett véve egy Controller példány, és hozzáadtam a Controllerhez az Eszkimót
	private static void Test2() {
		Controller c = new Controller();
		c.SetObjName("c");
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		c.AddPlayer(e);
		Field f1 = new Field();
		Hole h = new Hole();
		e.SetObjName("e");
		f1.SetObjName("f1");
		h.SetObjName("h");
		e.SetField(f1);
		f1.SetNeighbour(1, h);
		Writer.wipe();
		System.out.println("test 1:");
		e.Step(1);
		
	}
	
	private static void Test3() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test4() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test5() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test6() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test7() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test8() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test9() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test10() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test11() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test12() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test13() {
		System.out.println("initialization steps:");
		
		Writer.wipe();
		System.out.println("test 1:");
		
	}
	
	private static void Test14() {
		System.out.println("initialization steps:");
		Eskimo e1 = new Eskimo();
		Eskimo e2 = new Eskimo();
		Controller c = new Controller();
		c.AddPlayer(e1);
		c.AddPlayer(e2);
		e1.SetObjName("e1");
		e2.SetObjName("e2");
		c.SetObjName("c");
		e1.SetWork(0);
		Writer.wipe();
		System.out.println("test 14:");
		e2.EndRound();
	}

	public static String GetMethodName(){
		/*
		Returns the name of the method where this function was called.
		getStackTrace()[0] -> getStackTrace, getStackTrace()[1] -> GetMethodName, getStackTrace()[2] -> caller
		Was Tested on the virtual machine the program's supposed to run on.
		 */
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
