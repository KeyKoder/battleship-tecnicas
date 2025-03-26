package barco;

import position.Position;
import tablero.Orientation;

public class BoatBuilder {
	private Boat boat;

	public BoatBuilder createCanoe() {
		this.boat = new Canoe();
		return this;
	}

	public BoatBuilder createFrigate() {
		this.boat = new Frigate();
		return this;
	}

	public BoatBuilder createBattleship() {
		this.boat = new Battleship();
		return this;
	}

	public BoatBuilder setPosition(Position position) {
		boat.setCenterPosition(position);
		return this;
	}
	public BoatBuilder setOrientation(Orientation orientation) {
		boat.setOrientation(orientation);
		return this;
	}

	public int getCurrentSize() {
		return this.boat.getSize();
	}

	public Boat build() {
		return boat;
	}
}
