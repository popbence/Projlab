package projlab;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It controls the game
 * Initializes the board, starts and end the game
 * Manages snowstorms and rounds
 */
public class Controller {
	/**
	 * All the fields in the game space
	 */
	private static ArrayList<Field> fields = new ArrayList<Field>();
	/**
	 * All of the players
	 */
	private static ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * It's necessary for the skeleton so the object name can be printed out
	 */
	private static String objName;
	
	/**
	 * It initializes the game
	 * Not used in the skeleton
	 */
	public void Init(){}
	
	/**
	 * Checks if the round has ended and starts a new round
	 */
	public static void RoundCheck() {
		Writer.Write(objName + ".RoundCheck()");
		
		boolean allWorkZero = true;
		for(Player p : players ) {
			if(p.GetWork() > 0) {
				allWorkZero = false;
			}
		}
		if(allWorkZero) {
			NextRound();
		}
		Writer.Deregister(objName);
	}
	/**
	 * Ends the game if a player has died
	 * Not used in skeleton
	 */
	public static void GameOver() {
		Writer.Write(objName + ".GameOver()");
		Writer.Deregister(objName);
	}
	/**
	 * Ends the game if the players won
	 * Not used in skeleton
	 */
	public static void Win() {
		Writer.Write(objName + ".Win()");
		Writer.Deregister(objName);
	}
	
	/**
	 * Starts the next round.
	 * In skeleton it asks the user if there should be a snowstorm
	 */
	public static void NextRound() {
		Writer.Write(objName + ".NextRound()");
		/**
		 * Asks the user if there should be a snowstorm in the beginning of the next turn
		 */
		boolean snowStorm = false;
		try {
			System.out.println("Do you want a snowstorm?(Y/N)");
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			if(s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("yes")) 
				snowStorm = true;
		}
		catch(InputMismatchException e) {
			
		}
		if(snowStorm) {
			SnowStorm();
		}
		
		for(Player p : players ) {
			p.AddWork(4);
			p.SetDrowning(2);
		}
	}
	
	/**
	 * Adds snow to random fields
	 * In skeleton for easy testing it adds 3 layers of snow to all fields
	 */
	public static void SnowStorm() {
		Writer.Write(objName + ".SnowStorm()");
		
		for(Field f : fields) {
			f.AddSnow(3);
		}
		Writer.Deregister(objName);
	}
	
	/**
	 * Returns the list of players
	 * @return The list of players
	 */
	public static ArrayList<Player> GetPlayers(){
		Writer.Write(objName + ".GetPlayers()");
		Writer.Deregister(objName);
		return players;
	}
	
	/**
	 * Skeleton only
	 * Returns the name of the object
	 * @return The name of the object
	 */
	public String GetObjName() {
		return objName;
	}
	
	/**
	 * Skeleton only
	 * Sets the name of the object
	 * @param Name the name of the object
	 */
	public void SetObjName(String name) {
		objName = name;
	}
	
	/**
	 * Adds a player to the list of players
	 * @param p the player to be added
	 */
	public void AddPlayer(Player p) {
		Writer.Write(objName + ".AddPlayer(" + p.GetObjName() + ")");
		Writer.Deregister(objName);
		players.add(p);
	}
}
