package projlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		System.out.println("Welcome to the Jégmezõ prototype program\n\n" +
							"Please, enter your commands below, with the appropriate arguments.\n");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		Commander c = new Commander();
		boolean end = true;
		
		do {
			String input = "";
			try {
				input = reader.readLine();
			} catch (IOException e) {
				System.out.println("There's been a problem, while reading the input.");
			}
			if(input.equalsIgnoreCase("q")||input.equalsIgnoreCase("quit")) end = false;
			else c.interpret(input);
		}while(end);
	}
}
