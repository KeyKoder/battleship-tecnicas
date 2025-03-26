package barco;

import position.Position;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;

@Entitçy
@Table(name = "battleships")
public class Battleship extends Boat {
	public Battleship() {
		super("Battleship", 5);
	}
}
