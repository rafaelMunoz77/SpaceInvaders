package org.rmrsoft.spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Clase que representa un player en el juego
 *
 */
public class Player extends Actor {
	// Propiedades estáticas de esta clase
	public static String IMAGEN_PLAYER = "nave.gif";
	// Propiedades que indican si se está produciendo un movimiento en una dirección
	private boolean abajo = false, arriba = false, izquierda = false, derecha = false;
	// Velocidad de la nave, expresada en píxeles por cada frame
	public static int VELOCIDAD = 5;

	/**
	 * Constructor por defecto "default constructor"
	 */
	public Player() {
		super();
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * 
	 * @param x
	 * @param y
	 * @param img
	 */
	public Player(int x, int y, String img) {
		super(x, y, img);
		this.velocidadX = 0;
		this.velocidadY = 0;
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
		// Compruebo las variables booleanas que determinan el movimiento
		if (arriba) this.y -= VELOCIDAD;
		if (abajo) this.y += VELOCIDAD;
		if (izquierda) this.x -= VELOCIDAD;
		if (derecha) this.x += VELOCIDAD;
		
		// Compruebo si el player sale del canvas por cualquiera de los cuatro márgenes
		mover(this.x, this.y);
	}

	/**
	 * Mediante la llamada a este método, podemos cambiar la posición del jugador a
	 * unas nuevas coordenadas
	 * 
	 * @param x
	 * @param y
	 */
	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = SpaceInvaders.getInstance().getCanvas(); // Referencia al objeto Canvas usado
		
		// Compruebo si el jugador sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		// Compruebo si el jugador sale por la izquierda
		if (this.x < 0) {
			this.x = 0;
		}
		
		// Compruebo si el jugador sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}
		
		// Compruebo si el jugador sale por arriba
		if (this.y < 0) {
			this.y = 0;
		}
	}

	/**
	 * Se ejecuta al recibir un evento del teclado: tecla presionada
	 * @param e
	 */
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			arriba = true; break;
		case KeyEvent.VK_DOWN:
			abajo = true; break;
		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
		}
	}
	
	/**
	 * Se ejecuta al recibir un evento del teclado: tecla liberada
	 * @param e
	 */
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			arriba = false; break;
		case KeyEvent.VK_DOWN:
			abajo = false; break;
		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
}
