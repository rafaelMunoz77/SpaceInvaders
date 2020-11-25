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
		// Voy a crear un monstruo con un constructor que asigna propiedades
		Monster m1 = new Monster(50, 60, "monsterImg01.png", "m1", 75);
		
		// Creo un nuevo monstruo
		Monster m2 = new Monster(100, 120, "monsterImg02.png", "m2", 10);
		
		// Muestro los monstruos
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		// Bucle infinito que hace que los monstruos disparen eternamente
		while (true) {
			m1.dispara();
			m2.dispara();
		}
		
	}

}
