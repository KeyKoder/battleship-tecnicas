package barco;

import position.Position;

import java.util.ArrayList;
import java.util.List;

public class Battleship extends Boat {
	private List<Position> containers;
	private int hitContainers = 0;
	public Battleship() {
		super("Battleship", 5);
		containers = new ArrayList<>();
	}

	@Override
	public boolean positionHits(Position position) {
		if(containers.contains(position)) {
			hitContainers++;
			return true;
		}
		return super.positionHits(position);
	}

	@Override
	public boolean isSunk() {
		return super.isSunk() && hitContainers == containers.size();
	}
}
