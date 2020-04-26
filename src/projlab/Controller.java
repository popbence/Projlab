package projlab;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
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
	
	private static ArrayList<Tent> tents = new ArrayList<Tent>();
	
	private static PolarBear polarbear = new PolarBear(); 
	/**
	 * It initializes the game
	 * Not used in the skeleton
	 */
	public static void Init(){
		fields = new ArrayList<Field>();
		players = new ArrayList<Player>();
	}
	
	/**
	 * Checks if the round has ended and starts a new round
	 */
	public static void RoundCheck() {
		boolean allWorkZero = true;
		for(Player p : players ) {
			if(p.GetWork() > 0) {
				allWorkZero = false;
			}
		}
		if(allWorkZero) {
			NextRound();
		}
	}
	/**
	 * Ends the game if a player has died
	 * Not used in skeleton
	 */
	public static void GameOver() {
	
	}
	/**
	 * Ends the game if the players won
	 * Not used in skeleton
	 */
	public static void Win() {
		
	}
	
	/**
	 * Starts the next round.
	 */
	public static void NextRound() {
		Random rng = new Random();
		int random = rng.nextInt(100);
		if(random < 24) {
			SnowStorm();
		}
		for(Player p : players ) {
			p.AddWork(4);
			p.SetDrowning(2);
		}
	}
	
	/**
	 * Adds snow to random fields
	 */
	public static void SnowStorm() {
		Random rng = new Random();
		int numberOfSelectedFields = 0;
		numberOfSelectedFields = rng.nextInt(fields.size());
		ArrayList<Field> selectedFields = new ArrayList<Field>();
		for(int i = 0; i < numberOfSelectedFields; i++) {
			int selectedField = rng.nextInt(fields.size());
			selectedFields.add(fields.get(selectedField));
		}
		for(Field f : selectedFields) {
			int snow = rng.nextInt(4);
			f.AddSnow(snow);
		}
	}
	
	/**
	 * Returns the list of players
	 * @return The list of players
	 */
	public static ArrayList<Player> GetPlayers(){
		return players;
	}
	
	/**
	 * Adds a player to the list of players
	 * @param p the player to be added
	 */
	public void AddPlayer(Player p) {
		players.add(p);
	}
	
	public void AddField(Field f) {
		fields.add(f);
	}
}
