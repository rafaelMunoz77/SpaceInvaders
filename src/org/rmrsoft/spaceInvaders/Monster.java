package org.rmrsoft.spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Esta clase representa las propiedades y acciones de un monstruo del videojuego SpaceInvaders
 */
public class Monster extends Actor {
	// Propiedades privadas de cada monstruo
	private int probabilidadDisparo; // Probabilidad de que ser realice un disparo
	
	/**
	 * Constructor sin argumentos de entrada
	 */
	public Monster() {
		super();
	}

	/**
	 * Constructor más completo, con todas las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 * @param nombre
	 * @param probabilidadDisparo
	 */
	public Monster(int x, int y, int probabilidadDisparo) {
		super(x, y, ImagesCache.getInstance().getImagen(ImagesCache.IMAGEN_BICHO));
		this.probabilidadDisparo = probabilidadDisparo;
		this.velocidadX = 4;
		this.velocidadY = 4;
	}
	
	// Acciones de cada monstruo
	
	/**
	 * El monstruo dispara con una determinada probabilidad. El objeto Monster tendrá un valor determinado
	 * para su propiedad "probabilidadDisparo". Por ejemplo, si la probabilidad es "30" obtendremos un número
	 * al azar entre 0 y 100. Si el número al azar es menor o igual a 30, dictaminaremos que la probabilidad
	 * se ha cumplido, por lo que realizaremos un disparo.
	 */
	public void dispara() {
		if (puedoDisparar() == true) {
			System.out.println("Monstruo Dispara"); // Simulación de un disparo
		}
	}
	
	/**
	 * Método privado que comprueba si, según la probabilidad indicada, se va a producir un disparo
	 * @return
	 */
	private boolean puedoDisparar() {
		int numAzar = (int) Math.round(Math.random() * 100); // Obtengo un número al azar entre 0 y 100
		// Si el número es menor o igual a la probabilidadDisparo del objeto, decido disparar
		if (numAzar < probabilidadDisparo) {
			return true;
		}
		return false; // Si llego hasta aquí es porque la probabilidad no se ha cumplido
	}
	

	/**
	 * Metodo que devuelve un String con todos los valores de este objeto.
	 */
	public String toString() {
		return "Monster [img=" + img + ", probabilidadDisparo=" + probabilidadDisparo + ", getX()=" + getX()
				+ ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

	
	// Getters y Setters 

	/**
	 * @return the probabilidadDisparo
	 */
	public int getProbabilidadDisparo() {
		return probabilidadDisparo;
	}

	/**
	 * @param probabilidadDisparo the probabilidadDisparo to set
	 */
	public void setProbabilidadDisparo(int probabilidadDisparo) {
		this.probabilidadDisparo = probabilidadDisparo;
	}

	/**
	 * Utilizado para pintar un monstruo, según sus coordenadas de x e y
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);

	}

	@Override
	public void actua() {
		// El monstruo se mueve de manera horizontal, en cada FPS
		this.x += this.velocidadX;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.x < 0 || (this.x + this.ancho) > SpaceInvaders.getInstance().getCanvas().getWidth()) {
			this.velocidadX = -this.velocidadX;
		}
		
		// Copiamos el esquema anterior para el movimiento vertical
		this.y += this.velocidadY;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.y < 0 || (this.y + this.alto) > SpaceInvaders.getInstance().getCanvas().getHeight()) {
			this.velocidadY = -this.velocidadY;
		}
		
	}

	/**
	 * Este método se disparará cuando un actor colisione con el monstruo
	 */
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Player || a instanceof PlayerShoot) {
			SpaceInvaders.getInstance().eliminaActor(this);
		}
	}
	
	

}
