package org.rmrsoft.spaceInvaders;

/**
 * Clase que representa un player en el juego
 *
 */
public class Player {
	// Propiedades privadas del player
	private int x, y; // Coordenadas x e y del monstruo
	private String img; // Imagen del monstruo

	//Propiedades estáticas de esta clase
	public static String IMAGEN_PLAYER = "nave.gif";

	/**
	 * Constructor por defecto "default constructor"
	 */
	public Player() {
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Player(int x, int y, String img) {
		super();
		this.x = x;
		this.y = y;
		this.img = img;
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Player
	 */
	public String toString() {
		return "Player [x=" + x + ", y=" + y + ", img=" + img + "]";
	}

	// Getters y Setters
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
}
