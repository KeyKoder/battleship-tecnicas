package tablero;

import barco.Boat;
import position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tablero {
	private CellState[][] grid;
	private List<Boat> boats;

	public Tablero(int width, int height) {
		grid = new CellState[width][height];
		for(CellState[] row : grid){
			Arrays.fill(row, CellState.WATER);
		}
		boats = new ArrayList<>();
	}

	public void markCell(Position position) {
		grid[position.getY()][position.getX()] = CellState.HIT;
	}

	public void addBoat(Boat boat) {
		boats.add(boat);
		for(int i=0;i<boat.getSize();i++) {
			if(boat.getOrientation() == Orientation.HORIZONTAL) {
				grid[boat.getCenterPosition().getY()][boat.getCenterPosition().getX()+i-boat.getSize()/2] = CellState.SHIP;
			}else if(boat.getOrientation() == Orientation.VERTICAL) {
				grid[boat.getCenterPosition().getY()+i-boat.getSize()/2][boat.getCenterPosition().getX()] = CellState.SHIP;
			}
		}
	}

	public Boat getBoatAt(Position position) {
		for(Boat boat : boats) {
			if(boat.positionHits(position)) return boat;
		}
		return null;
	}

	public List<Boat> getBoats() {
		// Clone the boat list to prevent modifications from outside
		return boats.stream().toList();
	}

	@Override
	public String toString() {
		return this.toString(true);
	}

	public String toString(boolean showBoats) {
		String s = "";
		for(CellState[] row : this.grid){
			for(CellState cellState : row){
				if(cellState == CellState.WATER) s += "~";
				if(cellState == CellState.SHIP && showBoats) s += "#";
				if(cellState == CellState.SHIP && !showBoats) s += "~";
				if(cellState == CellState.HIT) s += "X";
				s += " ";
			}
			s += System.lineSeparator();
		}
		return s;
	}
}
