package game.engine.dataloader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import game.engine.cells.*;
import game.engine.monsters.*;
import game.engine.cards.*;
import game.engine.*;
public class DataLoader {
	private static final String CARDS_FILE_NAME="cards.csv";
	private static String CELLS_FILE_NAME="cells.csv";
	private static final String MONSTERS_FILE_NAME="monsters.csv";

	public static ArrayList<Card> readCards() throws IOException{
		ArrayList<Card> cardss=new ArrayList<>();
		BufferedReader br=new BufferedReader(new FileReader(CARDS_FILE_NAME));
		String line;
		
		while((line=br.readLine())!=null){
			String[]data=line.split(",");
			
			String type=data[0];
			String name=data[1];
			String description=data[2];
			int rarity = Integer.parseInt(data[3]);
			boolean lucky;
			Card card=null;
			
			if(type.equals("SwapperCard")){
				lucky= true;
				card= new SwapperCard(name,description,rarity);
				
			}
			else if(type.equals("ShieldCard")){
				lucky= false;
				card=new ShieldCard(name,description,rarity);
				
			}
			else if(type.equals("EnergyStealCard")) {

	            int energy = Integer.parseInt(data[4]);
	            lucky= true;
	            card = new EnergyStealCard(name, description, rarity,energy);
			}
	        
	        else if(type.equals("StartOverCard")) {

	            boolean lucky2 = Boolean.parseBoolean(data[4]);
	            card = new StartOverCard(name, description, rarity, lucky2);

	        }
	        else if(type.equals("ConfusionCard")) {

	            int duration = Integer.parseInt(data[4]);
	            lucky= false;
	            card = new ConfusionCard(name, description, rarity, duration);
		}
			cardss.add(card);
	}
		br.close();
		return cardss;
}
	 public static ArrayList<Cell> readCells() throws IOException {

	        ArrayList<Cell> cellss = new ArrayList<>();

	        BufferedReader br = new BufferedReader(new FileReader(CELLS_FILE_NAME));
	        String line;

	        while((line = br.readLine()) != null) {

	            String[] data = line.split(",");
	            String name=data[0];
	            
	            if (data.length == 3) { 
                    Role role = Role.valueOf(data[1]);
                    int energy = Integer.parseInt(data[2]);
                    cellss.add(new DoorCell(name, role, energy));
                } else if (data.length == 2) { 
                    int effect = Integer.parseInt(data[1]);
                    if (effect > 0) { 
                        cellss.add(new ConveyorBelt(name, effect));
                    } else { 
                        cellss.add(new ContaminationSock(name, effect));
                    }
                }
            }
        
        return cellss;
}
	 public static ArrayList<Monster> readMonsters() throws IOException {
		        ArrayList<Monster> monsterss = new ArrayList<>();
		        try (BufferedReader br = new BufferedReader(new FileReader(MONSTERS_FILE_NAME))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                String[] data = line.split(",");
		                String type = data[0];
		                String name = data[1];
		                String desc = data[2];
		                Role role = Role.valueOf(data[3]);
		                int energy = Integer.parseInt(data[4]);

		                if (type.equals("Dasher")) {
		                    monsterss.add(new Dasher(name, desc, role, energy)); 
		                } else if (type.equals("Dynamo")) {
		                    monsterss.add(new Dynamo(name, desc, role, energy)); 
		                } else if (type.equals("MultiTasker")) {
		                    monsterss.add(new MultiTasker(name, desc, role, energy));
		                } else if (type.equals("Schemer")) {
		                    monsterss.add(new Schemer(name, desc, role, energy));
		                }
		            }
		        }
		        return monsterss;
		    }
}
