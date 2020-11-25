package org.rmrsoft.spaceInvaders;

/**
 * Clase principal, que crea los monstruos
 *
 */
public class SpaceInvaders {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Voy a crear un monstruo
		Monster m1 = new Monster();
		
		// Asigno propiedades al monstruo creado
		m1.x = 50;
		m1.y = 62;
		m1.img = "monsterImg01.png";
		m1.nombre = "m1";
		
		// Creo un nuevo monstruo
		Monster m2 = new Monster();
		
		// Asigno propiedades al nuevo monstruo
		m2.x = 100;
		m2.y = 120;
		m2.img = "monsterImg02.png";
		m2.nombre = "m2";
		
		// Muestro los monstruos
		System.out.println("m1: nombre: " + m1.nombre + " x: " + m1.x + " y: " + m1.y + " img: " + m1.img);
		System.out.println("m2: nombre: " + m2.nombre + " x: " + m2.x + " y: " + m2.y + " img: " + m2.img);
	}

}
