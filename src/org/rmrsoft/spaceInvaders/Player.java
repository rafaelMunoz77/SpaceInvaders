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
	private boolean up, down, left, right; // Booleanas que determinan si el player se está moviendo actualmente
	protected static final int PLAYER_SPEED = 4; // velocidad del movimiento de la nave en los dos ejes

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
		// Por comodidad obtengo un puntero al canvas
		MiCanvas canvas = SpaceInvaders.getInstance().getCanvas();
		
		// Movimiento en el eje horizontal
		this.x += this.velocidadX; // En cada iteración del bucle principal, el monstruo cambiará su posición en el eje X, sumándole a esta el valor de vx
		// si la nave intenta salir por la derecha no se lo permitimos
		if (this.x <  0) {
			this.x = 0;
		}
		// si la nave intenta salir por la izquierda no se lo permitimos
		if (this.x >  (canvas.getWidth() - this.ancho)) {
			this.x = (canvas.getWidth() - this.ancho);
		}
		
		// Movimiento en el eje vertical
		this.y += this.velocidadY; // En cada iteraci�n del bucle principal, el monstruo cambiar� su posici�n en el eje y, sum�ndole a esta el valor de vy
		// si la nave intenta salir por arriba no se lo permitimos
		if (this.y <  0) {
			this.y = 0;
		}
		// si la nave intenta salir por abajo no se lo permitimos
		if (this.y >  (canvas.getHeight() - this.alto)) {
			this.y = (canvas.getHeight() - this.alto);
		}
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

		// Compruebo si el ratón sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}
		// Compruebo si el ratón sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}
	}

	/**
	 * Método llamado cuando una tecla es pulsada
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		System.out.println("tecla pulsada");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
		updateSpeed();
	}

	/**
	 * Método llamado cuando una tecla es liberada
	 * 
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		}
		updateSpeed();
	}

	/**
	 * En función de las banderas booleanas de movimiento, actualizamos las
	 * velocidades en los dos ejes
	 */
	protected void updateSpeed() {
		this.velocidadX = 0;
		this.velocidadY = 0;
		if (down)
			this.velocidadY = PLAYER_SPEED;
		if (up)
			this.velocidadY = -PLAYER_SPEED;
		if (left)
			this.velocidadX = -PLAYER_SPEED;
		if (right)
			this.velocidadX = PLAYER_SPEED;
	}

	// Getters y Setters

}
