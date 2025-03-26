package barco;

import position.Position;

import java.util.HashMap;

public class Battleship extends Boat {

	private HashMap<Position, Boolean> containers;
	public Battleship() {
		super(5);
		containers = new HashMap<>();
	}
}
