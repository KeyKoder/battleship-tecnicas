package barco;

import position.Position;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "battleships")
public class Battleship extends Boat {

	@ElementCollection
	@CollectionTable(name = "battleship_containers", joinColumns = @JoinColumn(name = "ship_id"))
	@Column(name = "containers")
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
