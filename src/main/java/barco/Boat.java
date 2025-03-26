package barco;

import position.Position;

public abstract class Boat {
	private Position pos;
	private int size;

	public Boat(int size) {
		this.size = size;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public boolean hit(Position pos) {
		return pos.equals(this.pos);
	}
}
