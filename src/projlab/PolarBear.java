package projlab;

import java.util.ArrayList;

public class PolarBear extends Characters{
	public void Step(int dir) {
		Field f1 = this.GetField();
		Field f2 = f1.GetNeighbour(dir);
		
		f1.RemoveCharacter(this);
		f1.SetDeadly();
		
		f2.AddCharacter(this);
		f2.SetDeadly();
		
		ArrayList<Character> characters = f2.GetCharacters();
		
		if(characters.size() > 1) {
			Igloo i;
			i = f2.GetIgloo();
			if(i != null) {
				boolean invadable = i.Invadable();
				if(invadable)
					Controller.GameOver();
			}
			else
				Controller.GameOver();
		}
	}
	public void FellInWater() {
		
	}
	public boolean Rescuable() {
		return false;
	}
}
