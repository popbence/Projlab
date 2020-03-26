package projlab;

import java.util.ArrayList;

public class Field {
	private int snow;
	private Igloo igloo;
	private ArrayList<Player> players;
	private Item item;
	private ArrayList<Field> neighbours;
	
	public void AddPlayer(Player p) {}
	
	public Field GetNeigbour(int dir) {
		return neighbours.get(dir);
	}
	
	public void RemovePlayer(Player p) {}
	
	public void AddSnow(int s) {}
	
	public int GetMaxPlayers() {
		return -1;
	}
	
	public void BuildIgloo(Igloo i) {}
	
	public void RemoveIgloo() {}
	
	public void SetNeighbour(int dir, Field f) {}
	
	public void RemoveItem() {}
	
	public Item GetItem() {
		return item;
	}
}
