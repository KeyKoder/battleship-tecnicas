package tablero;

import barco.Boat;
import position.Position;

import java.util.HashMap;
import java.util.List;

public class Tablero {
	private int width;
	private int height;
	private int[][] tablero;
	private List<Boat> boats;

	public Tablero() {}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		this.tablero = new int[width][height];
	}
}
