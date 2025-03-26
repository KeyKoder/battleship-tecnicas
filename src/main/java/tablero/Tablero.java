package tablero;

import barco.Boat;
import position.Position;

import java.util.Set;
import java.util.stream.Collectors;

public class Tablero {
	private Boat[][] grid;

	public Tablero(int width, int height) {
		grid = new Boat[width][height];
	}

	public void addBoat(Boat boat, Set<Position> positions) {
		for (Position position : positions) {
			grid[position.getX()][position.getY()] = boat;
		}
		boat.setPosition(positions.stream().map(Position::toString).collect(Collectors.toSet()));
	}

	public Boat getBoatAt(Position position) {
		return grid[position.getX()][position.getY()];
	}
}
