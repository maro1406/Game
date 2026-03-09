package game.engine.monsters;
import game.engine.*;

public class Multitasker extends Monster {
	
	private int normalSpeedTurns;

	public int getNormalSpeedTurns() {
		return normalSpeedTurns;
	}

	public void setNormalSpeedTurns(int normalSpeedTurns) {
		this.normalSpeedTurns = normalSpeedTurns;
	}

	public Multitasker(String name, String description, Role originalRole,
			int energy) {
		super(name, description, originalRole, energy);
		normalSpeedTurns=0;
	}
	
	

}
