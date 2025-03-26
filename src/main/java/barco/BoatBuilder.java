package barco;

import position.Position;

public class BoatBuilder {
	private Boat boat;

	public BoatBuilder createCanoe() {
		Canoe canoe = new Canoe();
		return this;
	}

	public BoatBuilder createFrigate() {
		Frigate frigate = new Frigate();
		return this;
	}

	public BoatBuilder createBattleship() {
		Battleship battleship = new Battleship();
		return this;
	}

	public BoatBuilder setPosition(int x, int y) {
		boat.setPosition(new Position(x, y).toString());
		return this;
	}

	public Boat build() {
		return boat;
	}
}
