import barco.*;
import position.Position;
import tablero.Orientation;
import tablero.Tablero;
import tablero.TableroBuilder;

import java.util.*;

public class Main {
	private static final int MAX_SHIPS = 3;
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);
	private static final int BOARD_WIDTH = 10;
	private static final int BOARD_HEIGHT = 10;

	public static void main(String[] args) {
		Tablero player1Tablero = configurePlayerTablero(1);
		Tablero player2Tablero = configurePlayerTablero(2);

		// Comenzar el juego
		boolean gameOn = true;
		Tablero tableroActual = player1Tablero;
		Tablero tableroOpuesto = player2Tablero;
		int playerTurn = 1;
		while (gameOn) {
			System.out.println("Turno del Jugador " + playerTurn + ":");
			System.out.println(tableroOpuesto.toString(false));
			System.out.println();
			System.out.println(tableroActual.toString());

			System.out.println("Ingrese las coordenadas (x,y) para el ataque (ejemplo: 1,1):");
			Position attackPosition = readPosition();
			if (tableroOpuesto.getBoatAt(attackPosition) != null) {
				System.out.println("Atacando en " + attackPosition + "...");
				Boat attackedBoat = tableroOpuesto.getBoatAt(attackPosition);
				if (attackedBoat.positionHits(attackPosition)) {
					if(attackedBoat.isSunk()) System.out.println("¡Tocado y Hundido!");
					else System.out.println("¡Tocado!");
				}
			} else {
				System.out.println("¡Agua!");
			}
			tableroOpuesto.markCell(attackPosition);

			// Verificar si el jugador 2 ha perdido
			if (allBoatsSunk(tableroOpuesto)) {
				System.out.println("¡Jugador 1 gana!");
				gameOn = false;
				break;
			}

			if(playerTurn == 1) {
				tableroActual = player2Tablero;
				tableroOpuesto = player1Tablero;
				playerTurn = 2;
			}else {
				tableroActual = player1Tablero;
				tableroOpuesto = player2Tablero;
				playerTurn = 1;
			}
		}
	}

	private static Tablero configurePlayerTablero(int playerNumber) {
		TableroBuilder boardBuilder = new TableroBuilder(BOARD_WIDTH, BOARD_HEIGHT);
		System.out.println("Configuración de barcos para el Jugador " + playerNumber + ":");

		BoatBuilder boatBuilder = new BoatBuilder();
		for (int i = 0; i < MAX_SHIPS; i++) {
			System.out.println("Seleccione el tipo de barco (1: Acorazado, 2: Fragata, 3: Canoa): ");
			try {
				int choice = scanner.nextInt();

				switch (choice) {
					case 1:
						boatBuilder.createBattleship();
						break;
					case 2:
						boatBuilder.createFrigate();
						break;
					case 3:
						boatBuilder.createCanoe();
						break;
					default:
						System.out.println("Opción no válida. Intente de nuevo.");
						i--; // Decrementar para repetir la selección
						scanner.nextLine();
						continue;
				}
			}catch (InputMismatchException e) {
				System.out.println("Opción no válida. Intente de nuevo.");
				i--;
				scanner.nextLine();
				continue;
			}



			System.out.println("Ingrese la orientación del barco (H / V):");
			Orientation orientation = readOrientation();
			boatBuilder.setOrientation(orientation);

			System.out.println("Ingrese las coordenadas (x,y) para el barco (ejemplo: 1,1):");
			boolean valid = false;
			Position pos = null;
			while(!valid) {
				pos = readPosition();
				if((orientation == Orientation.HORIZONTAL && (pos.getX() < boatBuilder.getCurrentSize()/2 || BOARD_WIDTH-pos.getX() < boatBuilder.getCurrentSize()/2)) ||
						(orientation == Orientation.VERTICAL && (pos.getY() < boatBuilder.getCurrentSize()/2 || BOARD_HEIGHT-pos.getY() < boatBuilder.getCurrentSize()/2))) {
					System.out.println("Posición fuera del tablero. Intente de nuevo.");
				}else {
					valid = true;
				}
			}
			boatBuilder.setPosition(pos);

			boardBuilder.addBoat(boatBuilder.build());
			//shipDAO.saveBoat(ship); // Guardar el barco en la base de datos
		}

		return boardBuilder.build();
	}

	private static Position readPosition() {
		Position pos = new Position();
		while (true) {
			String input = scanner.next();
			String[] parts = input.split(",");
			if (parts.length == 2) {
				try {
					int x = Integer.parseInt(parts[0].trim());
					int y = Integer.parseInt(parts[1].trim());
					if (x >= 1 && x <= BOARD_WIDTH && y >= 1 && y <= BOARD_HEIGHT) {
						pos.setX(x-1);
						pos.setY(y-1);
						break;
					} else {
						System.out.println("Coordenadas fuera de rango. Deben estar entre (1,1) y (" + BOARD_WIDTH + "," + BOARD_HEIGHT + ").");
					}
				} catch (NumberFormatException e) {
					System.out.println("Entrada no válida. Intente de nuevo.");
				}
			} else {
				System.out.println("Formato incorrecto. Debe ser (x,y).");
			}
		}
		return pos;
	}

	private static Orientation readOrientation() {
		while(true) {
			String input = scanner.next();
			if(input.equalsIgnoreCase("h")) return Orientation.HORIZONTAL;
			if(input.equalsIgnoreCase("v")) return Orientation.VERTICAL;
			System.out.println("Formato incorrecto. Debe ser 'H' o 'V'.");
		}
	}

	private static boolean allBoatsSunk(Tablero board) {
		for (Boat ship : board.getBoats()) {
			if (!ship.isSunk()) {
				return false;
			}
		}
		return true;
	}
}
