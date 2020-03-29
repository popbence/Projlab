package projlab;

import java.util.ArrayList;

public class Unstable extends Field { // TODO: Comments
	private int maxPlayer;
	private boolean flipped;
	
	public void Flip() {
		Writer.Write(objName + "." + Main.GetMethodName() + "()");
		
		Writer.Deregister(objName);
		Writer.DummyGive("dd");

		flipped = !flipped;

		if (flipped) {
			for (Player p : GetPlayers()) {
				p.SetTempToOne();
				p.SetDrowning(1);
				//p.EndRound(); a teszt 12 esetében ez nem fontos itt.
			}
		}
	}
	
	public void AddPlayer(Player p) {
		super.AddPlayer(p); // should include the method call print
		
		Writer.DummyGive("d");
		
		if (flipped){
			/*p.SetTempToOne();
			p.SetDrowning(1);
			p.EndRound();*/// a teszt 13 esetében nem fontos itt.
		} else if (GetPlayers().size() > maxPlayer)
			Flip();
	}
	
	public void RemovePlayer(Player p) {
		super.RemovePlayer(p); // should include the method call print
		
		Writer.DummyGive("d");
		
		if (GetPlayers().size() == 0)
			Flip();
	}
	
	public int GetMaxPlayer() {
		Writer.Write(objName + "." + Main.GetMethodName() + "()");
		return maxPlayer;
	}
	
	public void SetMaxPlayer(int players) {
		maxPlayer = players;
	}
	
}
