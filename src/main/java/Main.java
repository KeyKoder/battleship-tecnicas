import barco.Boat;
import barco.BoatBuilder;

public class Main {
	public static void main(String[] args) {
		BoatBuilder builder = new BoatBuilder();

		// Crear un acorazado
		Boat battleship = builder.createBattleship()
				.setPosition(2,2)
				.build();

		// Crear una fragata
		Boat frigate = builder.createFrigate()
				.setPosition(1,1)
				.build();

		// Crear una canoa
		Boat canoe = builder.createCanoe()
				.setPosition(0,0)
				.build();


	}
}