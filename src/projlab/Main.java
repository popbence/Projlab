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
		Writer.wipe();
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
		Writer.wipe();
		System.out.println("initialization steps:");
		Controller c = new Controller();
		c.SetObjName("c");
		Eskimo e = new Eskimo();
		e.SetObjName("e");
		Field f1 = new Field();
		f1.SetObjName("f1");
		Hole h = new Hole();
		h.SetObjName("h");
		c.AddPlayer(e);
		e.SetField(f1);
		f1.SetNeighbour(1, h);
		Writer.wipe();
		System.out.println("test 2:");
		e.Step(1);
	}
	
	private static void Test3() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Field f = new Field();
		e.SetObjName("e");
		f.SetObjName("f");
		e.SetField(f);
		f.AddPlayer(e);
		Writer.wipe();
		System.out.println("test 3:");
		e.Dig();
		
	}
	
	private static void Test4() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Food f = new Food();
		e.SetObjName("e");
		f.SetObjName("f");
		e.AddItem(f);
		f.SetPlayer(e);
		Writer.wipe();
		System.out.println("test 4:");
		e.UseItem(0);
	}
	
	private static void Test5() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Suit s = new Suit();
		e.SetObjName("e");
		s.SetObjName("s");
		e.AddItem(s);
		s.SetPlayer(e);
		Writer.wipe();
		System.out.println("test 5:");
		e.UseItem(0);
	}
	
	private static void Test6() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Controller c = new Controller();
		c.SetObjName("c");
		Eskimo e = new Eskimo();
		Explorer ex1 = new Explorer();
		Explorer ex2 = new Explorer();
		e.SetObjName("e");
		ex1.SetObjName("ex1");
		ex2.SetObjName("ex2");
		Hole h1 = new Hole();
		Hole h2 = new Hole();
		Field f1 = new Field();
		Field f2 = new Field();
		f1.SetObjName("f1");
		f2.SetObjName("f2");
		h1.SetObjName("h1");
		h2.SetObjName("h2");
		f1.SetNeighbour(1, h1);
		f1.SetNeighbour(2, f2);
		f1.SetNeighbour(3, h2);
		c.AddPlayer(e);
		c.AddPlayer(ex1);
		c.AddPlayer(ex2);
		e.SetField(f1);
		f1.AddPlayer(e);
		ex1.SetField(h1);
		h1.AddPlayer(ex1);
		ex2.SetField(h2);
		h2.AddPlayer(ex2);

		Rope r = new Rope();
		r.SetObjName("r");
		e.AddItem(r);
		r.SetPlayer(e);
		Writer.wipe();
		System.out.println("test 6:");
		e.UseItem(0);
	}
	
	private static void Test7() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Field f1 = new Field();
		Shovel s = new Shovel();
		e.SetObjName("e");
		f1.SetObjName("f1");
		s.SetObjName("s");
		f1.AddSnow(3);
		f1.AddPlayer(e);
		e.SetField(f1);
		e.AddItem(s);
		s.SetPlayer(e);
		Writer.wipe();
		System.out.println("test 7:");
		e.UseItem(0);
	}
	
	private static void Test8() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Controller c = new Controller();
		Eskimo e = new Eskimo();
		Field f1 = new Field();
		Part p1 = new Part();
		c.SetObjName("c");
		e.SetObjName("e");
		f1.SetObjName("f1");
		c.AddPlayer(e);
		p1.SetObjName("p1");
		p1.SetPlayer(e);
		e.AddItem(p1);
		e.SetField(f1);
		Writer.wipe();
		System.out.println("test 8:");
		e.UseItem(0);
	}
	
	private static void Test9() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Field f = new Field();
		Shovel p = new Shovel();
		e.SetObjName("e");
		f.SetObjName("f");
		p.SetObjName("p");
		f.SetItem(p);
		p.SetPlayer(e);
		e.AddItem(p);
		e.SetField(f);
		Writer.wipe();
		System.out.println("test 9:");
		e.Pick();
		
	}
	
	private static void Test10() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Field f = new Field();
		e.SetObjName("e");
		f.SetObjName("f");
		e.SetField(f);
		Writer.wipe();
		System.out.println("test 10:");
		e.UseAbility(1);
	}
	
	private static void Test11() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Explorer e = new Explorer();
		Field f1 = new Field();
		Field f2 = new Field();
		e.SetObjName("e");
		f1.SetObjName("f1");
		f2.SetObjName("f2");
		e.SetField(f1);
		f1.SetNeighbour(1, f2);
		Writer.wipe();
		System.out.println("test 11:");
		e.UseAbility(1);
	}
	
	private static void Test12() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Unstable uf = new Unstable();
		e.SetObjName("e");
		uf.SetObjName("uf");
		uf.SetMaxPlayer(0);
		Writer.wipe();
		System.out.println("test 12:");
		uf.AddPlayer(e);
	}
	
	private static void Test13() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e = new Eskimo();
		Unstable uf = new Unstable();
		e.SetObjName("e");
		uf.SetObjName("uf");
		uf.SetMaxPlayer(0);
		uf.AddPlayer(e);
		Writer.wipe();
		System.out.println("test 13:");
		uf.RemovePlayer(e);
	}
	
	private static void Test14() {
		Writer.wipe();
		System.out.println("initialization steps:");
		Eskimo e1 = new Eskimo();
		Eskimo e2 = new Eskimo();
		Controller c = new Controller();
		c.SetActivateNextRound(true);
		e1.SetObjName("e1");
		e2.SetObjName("e2");
		c.SetObjName("c");
		c.AddPlayer(e1);
		c.AddPlayer(e2);
		e1.SetWork(0);
		Writer.wipe();
		System.out.println("test 14:");
		e2.EndRound();
		c.SetActivateNextRound(false);
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
