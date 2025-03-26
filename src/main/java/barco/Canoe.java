package barco;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "canoes")
public class Canoe extends Boat {
	public Canoe() {
		super("Canoe", 1);
	}
}