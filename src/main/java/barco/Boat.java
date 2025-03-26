package barco;

import position.Position;
import tablero.Orientation;

public abstract class Boat {
	private String type;
	private int size;

	private Position centerPosition;

	private Orientation orientation;

	private int hits;

	public Boat() {}

	public Boat(String type, int size) {
		this.type = type;
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Position getCenterPosition() {
		return centerPosition;
	}

	public void setCenterPosition(Position centerPosition) {
		this.centerPosition = centerPosition;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public boolean positionHits(Position position) {
		if(orientation == Orientation.HORIZONTAL) {
			if(Math.abs(position.getX() - this.centerPosition.getX()) < this.size/2f) {
				return true;
			}
		}else if(orientation == Orientation.VERTICAL) {
			if(Math.abs(position.getY() - this.centerPosition.getY()) < this.size/2f) {
				return true;
			}
		}
		return false;
	}

	public boolean isSunk() {
		return this.hits == this.size;
	}
}
