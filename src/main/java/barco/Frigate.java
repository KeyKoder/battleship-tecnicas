package barco;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "frigates")
public class Frigate extends Boat {
	public Frigate() {
		super("Frigate", 3);
	}
}