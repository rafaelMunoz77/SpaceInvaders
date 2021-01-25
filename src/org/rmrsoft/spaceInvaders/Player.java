package org.rmrsoft.spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;

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

	/**
	 * Utilizado para pintar un player, según sus coordenadas de x e y
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
	
	}

	/**
	 * Mediante la llamada a este método, podemos cambiar la posición del jugador a unas
	 * nuevas coordenadas
	 * @param x
	 * @param y
	 */
	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = SpaceInvaders.getInstance().getCanvas(); // Referencia al objeto Canvas usado

		// Compruebo si el ratón sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}
		// Compruebo si el ratón sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}
	}

	// Getters y Setters
	
}
