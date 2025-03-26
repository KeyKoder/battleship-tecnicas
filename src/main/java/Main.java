import barco.*;
import utils.BoatDAO;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		// Inicializar Hibernate
		HibernateUtil.getSessionFactory();

		// Crear un DAO para manejar los barcos
		BoatDAO boatDAO = new BoatDAO();

		// Crear y guardar un acorazado
		Battleship battleship = new Battleship();
		Set<String> battleshipCoordinates = new HashSet<>();
		battleshipCoordinates.add("(1, 1)");
		battleshipCoordinates.add("(1, 2)");
		battleshipCoordinates.add("(1, 3)");
		battleshipCoordinates.add("(1, 4)");
		battleshipCoordinates.add("(1, 5)");
		battleship.setPosition(battleshipCoordinates);
		boatDAO.saveShip(battleship);

		// Crear y guardar una fragata
		Frigate frigate = new Frigate();
		Set<String> frigateCoordinates = new HashSet<>();
		frigateCoordinates.add("(2, 1)");
		frigateCoordinates.add("(2, 2)");
		frigateCoordinates.add("(2, 3)");
		frigate.setPosition(frigateCoordinates);
		boatDAO.saveShip(frigate);

		// Crear y guardar una canoa
		Canoe canoe = new Canoe();
		Set<String> canoeCoordinates = new HashSet<>();
		canoeCoordinates.add("(3, 1)");
		canoe.setPosition(canoeCoordinates);
		boatDAO.saveShip(canoe);

		// Cerrar la sesión de Hibernate
		HibernateUtil.shutdown();
	}
}