package tablero;

import barco.Boat;

public class TableroBuilder {
	public Tablero tablero;

	public TableroBuilder() {}

	public TableroBuilder createTablero(int w, int h) {
		this.tablero = new Tablero(w, h);
		return this;
	}

	public TableroBuilder addBoat(Boat boat) {
//		this.tablero.
		return this;
	}
}
