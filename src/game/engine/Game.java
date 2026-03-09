package game.engine;
import java.io.IOException;
import java.util.ArrayList;
import game.engine.monsters.*;


public class Game {
	private Board board;
	private ArrayList<Monster> allMonsters;
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
		
	}
	
	private Monster selectRandomMonsterByRole(Role role){
		
		
		
	}
}