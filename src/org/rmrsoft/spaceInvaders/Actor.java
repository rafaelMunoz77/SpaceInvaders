package org.rmrsoft.spaceInvaders;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Clase que representa cualquier actor que interviene en el juego
 *
 */
public abstract class Actor {
	// Propiedades protegidas (visibles en la propia clase y en los subtipos) de cada actor
	protected int x, y; // Coordenadas x e y del actor
	protected int ancho = 30, alto = 30; // ancho y alto que ocupa el actor en pantalla
	protected BufferedImage img; // Imagen del actor
	protected int velocidadX = 0; // Velocidades en cada eje
	protected int velocidadY = 0;

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
	public Actor(int x, int y, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.setImg(img);
	}
	
	/**
	 * Este método pinta la imagen de cada actor.
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}
	
	/**
	 * Método que permite que cada actor realice las acciones que necesite en la creación de cada Frame
	 */
	public abstract void actua ();

	/**
	 * Método que se podrá sobrescribir en los subtipos para decidir la acción a realizar al colisionar
	 * con otro actor
	 * @param a
	 */
	public void colisionaCon(Actor a) {
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
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
		this.ancho = this.img.getWidth();
		this.alto = this.img.getHeight();
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	
}
