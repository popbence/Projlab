package projlab;

import java.util.ArrayList;

public class Rope extends Item{ // TODO: Comments
	public void Use() {
		String methodCall = objName + "." + Main.GetMethodName() + "()";
		System.out.println(methodCall);

		Field f1 = GetPlayer().GetField();
		int i = 0; boolean has_more_neighbours = true;
		while (has_more_neighbours) {
			try {
				Field fi = f1.GetNeighbour(i);
				// Ide az�rt kellett egy if, mert lehet null az egyik szomsz�d
				if(fi != null){
					ArrayList<Player> players = fi.GetPlayers();
	
					for (Player p : players) {
						if (p.GetDrowning() == 1){
							fi.RemovePlayer(p); //A kimentett jatekosoknak 0-ra kellene allitani a drowning erteket
							p.SetDrowning(0);
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
