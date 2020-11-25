package org.rmrsoft.spaceInvaders;

/**
 * Clase que representa un player en el juego
 *
 */
public class Player extends Actor {
	//Propiedades estáticas de esta clase
	public static String IMAGEN_PLAYER = "nave.gif";

	/**
	 * Constructor por defecto "default constructor"
	 */
	public Player() {
		super();
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Player(int x, int y, String img) {
		super(x, y, img);
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Player
	 */
	public String toString() {
		return "Player [getX()=" + getX() + ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

	

	// Getters y Setters
	
}
