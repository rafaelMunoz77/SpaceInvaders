package org.rmrsoft.spaceInvaders;

/**
 * Clase que representa cualquier actor que interviene en el juego
 *
 */
public class Actor {
	// Propiedades privadas de cada actor
	private int x, y; // Coordenadas x e y del actor
	private String img; // Imagen del actor

	/**
	 * Constructor sin parámetros de entrada
	 */
	public Actor() {
	}

	/**
	 * Constructor con parámetros de entrada
	 * @param x
	 * @param y
	 * @param img
	 */
	public Actor(int x, int y, String img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	// Getters y setters
	
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
