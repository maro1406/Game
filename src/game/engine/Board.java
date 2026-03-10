package game.engine;
import java.util.ArrayList;
import game.engine.cards.*;
import game.engine.cells.Cell;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.*;

public class Board {
	
	private	 Cell[][] boardCells;
	private static ArrayList<Monster> stationedMonsters;
	private static ArrayList<Card> originalCards;
	private static ArrayList<Card> cards;
	public static ArrayList<Monster> getStationedMonsters() {
		return stationedMonsters;
	}
	public static void setStationedMonsters(ArrayList<Monster> stationedMonsters) {
		Board.stationedMonsters = stationedMonsters;
	}
	public static ArrayList<Card> getCards() {
		return cards;
	}
	public static void setCards(ArrayList<Card> cards) {
		Board.cards = cards;
	}
	public Board(ArrayList<Card> readCards){
	
		boardCells=new Cell[10][10];
		stationedMonsters= new ArrayList<Monster>();
		cards= new ArrayList<Card>();
		originalCards= readCards;
}
}