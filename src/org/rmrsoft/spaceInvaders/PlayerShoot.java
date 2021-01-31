package org.rmrsoft.spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Representa un disparo del jugador
 */
public class PlayerShoot extends Actor {
	
	private static int VELOCIDAD_PIXELS_POR_FRAME = 5;
	public static int ANCHO = 5;
	public static int ALTO = 20;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param img
	 */
	public PlayerShoot(int x, int y, String img) {
		super(x, y, img);
		this.ancho = ANCHO;
		this.alto = ALTO;
	}

	/**
	 * 
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}

	/**
	 * 
	 */
	@Override
	public void actua() {
		this.y -= VELOCIDAD_PIXELS_POR_FRAME; // El disparo sube en vertical
		
		// Si el disparo se pierde por el borde superior, elimino el actor del juego
		if ((this.y + this.alto) < 0) {
			SpaceInvaders.getInstance().eliminaActor(this);
		}
	}

}
