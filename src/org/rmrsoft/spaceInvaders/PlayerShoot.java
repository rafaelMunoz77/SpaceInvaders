package org.rmrsoft.spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	public PlayerShoot(int x, int y) {
		super(x, y);
		this.ancho = ANCHO;
		this.alto = ALTO;
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.IMAGEN_DISPARO));
	}

	/**
	 * 
	 */
	@Override
	public void actua() {
		super.actua();
		
		this.y -= VELOCIDAD_PIXELS_POR_FRAME; // El disparo sube en vertical
		
		// Si el disparo se pierde por el borde superior, elimino el actor del juego
		if ((this.y + this.alto) < 0) {
			SpaceInvaders.getInstance().eliminaActor(this);
		}
	}

	
	/**
	 * Este método se disparará cuando un actor colisione con el disparo
	 */
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con monstruo, eliminamos el disparo
		if (a instanceof Monster) {
			SpaceInvaders.getInstance().eliminaActor(this);
		}
	}

}
