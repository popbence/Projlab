package projlab;

public class Explorer extends Player{
	public void UseAbility(int dir) {
		System.out.println(objName + ".UseAbility(" + dir +")");
		
		Field neighbour = this.GetField().GetNeighbour(dir);
		int nMaxPlayers = neighbour.GetMaxPlayers();
		
		System.out.println(nMaxPlayers);
	}
}
