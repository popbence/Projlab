package projlab;

import java.util.ArrayList;

public class Unstable extends Field {
	private int maxPlayer;
	private boolean flipped;
	
	public void Flip() {
		//TODO: print
		flipped = !flipped;

		if (flipped) {
			for (Player p : GetPlayers()) {
				p.SetTempToOne();
				p.SetDrowning(1);
				p.EndRound();
			}
		}
	}
	
	public void AddPlayer(Player p) {
		super.AddPlayer(p); // should include the method call print
		//TODO: flipped case, does Field.AddPlayer(p) need SetField?
		if (GetPlayers().size() > maxPlayer)
			Flip();
	}
	
	public void RemovePlayer(Player p) {
		
	}
	
	public int GetMaxPlayer() {
		return maxPlayer;
	}
	
}
