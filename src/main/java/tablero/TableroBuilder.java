package tablero;

import barco.Boat;
import position.Position;

import java.util.Set;

public class TableroBuilder {
	private Tablero tablero;

	public TableroBuilder(int width, int height) {
		this.tablero = new Tablero(width, height);
	}

	public TableroBuilder addBoat(Boat boat) {
		tablero.addBoat(boat);
		return this;
	}

	public Tablero build() {
		return tablero;
	}
}
