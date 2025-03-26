package barco;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ship")
public abstract class Boat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;
	private int size;

	@ElementCollection
	@CollectionTable(name = "ship_coordinates", joinColumns = @JoinColumn(name = "ship_id"))
	@Column(name = "coordinate")
	private Set<String> position = new HashSet<>();

	public Boat() {}

	public Boat(String type, int size) {
		this.type = type;
		this.size = size;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Set<String> getPosition() {
		return position;
	}

	public void setPosition(Set<String> coordinates) {
		this.position = coordinates;
	}
}
