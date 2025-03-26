package tablero;

import barco.Boat;

public class TableroBuilder {
	public Tablero tablero;

	public TableroBuilder() {}

	public TableroBuilder createTablero() {
		this.tablero = new Tablero();
		return this;
	}

	public TableroBuilder setSize(int x, int y) {
		this.tablero.setSize(x, y);
		return this;
	}

	public TableroBuilder addBoat(Boat boat) {
//		this.tablero.
		return this;
	}
}
