package game.engine;
import java.io.IOException;
import game.engine.dataloader.*;
import java.util.ArrayList;
import game.engine.monsters.*;



public class Game {
	private Board board;
	private static ArrayList<Monster> allMonsters;
	private Monster player;
	private Monster opponent;
	private Monster current;
	
	public Monster getCurrent() {
		return current;
	}
	public void setCurrent(Monster current) {
		this.current = current;
	}
	public Board getBoard() {
		return board;
	}
	public ArrayList<Monster> getAllMonsters() {
		return allMonsters;
	}
	public Monster getPlayer() {
		return player;
	}
	public Monster getOpponent() {
		return opponent;
	}
	Game(Role playerRole) throws IOException{
		Board b= new Board(DataLoader.readCards());
		allMonsters= DataLoader.readMonsters();
		player= selectRandomMonsterByRole(playerRole);
		if(playerRole==Role.SCARER) {
			this.opponent= selectRandomMonsterByRole(Role.LAUGHER);
		}
		else {
			this.opponent= selectRandomMonsterByRole(Role.SCARER);
		}
		current= player;
	}
	
	private Monster selectRandomMonsterByRole(Role role){
		ArrayList<Monster> ifMonsters= new ArrayList<>();
		for(int i=0; i<allMonsters.size();i++) {
			Monster m= allMonsters.get(i);
			if(m.getRole()==role) {
				ifMonsters.add(m);
			}
		}
		int index = (int)(Math.random() * ifMonsters.size()); 
		return ifMonsters.get(index);
	}
}