package projlab;

import java.util.ArrayList;

public class Rope extends Item{
	public void Use() {
		String methodCall = objName + "." + Main.GetMethodName() + "()";
		System.out.println(methodCall);

		Field f1 = GetPlayer().GetField();
		int i = 0; boolean has_more_neighbours = true;
		while (has_more_neighbours) {
			try {
				Field fi = f1.GetNeighbour(i);
				// Ide azért kellett egy if, mert lehet null az egyik szomszéd
				if(fi != null){
					ArrayList<Player> players = fi.GetPlayers();
	
					for (Player p : players) {
						if (p.GetDrowning() == 1){
							fi.RemovePlayer(p);
							f1.AddPlayer(p);
						}
					}
				}
				i++;
			} catch (IndexOutOfBoundsException e){
				has_more_neighbours = false;
			}
		}

	}
}
