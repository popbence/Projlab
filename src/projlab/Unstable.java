package projlab;

import java.util.ArrayList;

public class Unstable extends Field { // TODO: Comments
	private int maxPlayer;
	private boolean flipped;
	
	public void Flip() {
		Writer.Write(objName + "." + Main.GetMethodName() + "()");

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
		if (flipped){
			p.SetTempToOne();
			p.SetDrowning(1);
			p.EndRound();
		} else if (GetPlayers().size() > maxPlayer)
			Flip();
	}
	
	public void RemovePlayer(Player p) {
		super.RemovePlayer(p); // should include the method call print
	}
	
	public int GetMaxPlayer() {
		Writer.Write(objName + "." + Main.GetMethodName() + "()");
		return maxPlayer;
	}
	
}
