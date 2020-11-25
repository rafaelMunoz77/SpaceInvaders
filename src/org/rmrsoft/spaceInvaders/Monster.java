package org.rmrsoft.spaceInvaders;

/**
 * Esta clase representa las propiedades y acciones de un monstruo del videojuego SpaceInvaders
 */
public class Monster {
	// Propiedades de cada monstruo
	int x, y; // Coordenadas x e y del monstruo
	String img; // Imagen del monstruo
	String nombre; // Nombre que recibe el monstruo
	int probabilidadDisparo; // Probabilidad de que ser realice un disparo
	
	/**
	 * Constructor sin argumentos de entrada
	 */
	public Monster() {
		// texto de prueba para comprobar que, al construir un objeto, se ejecuta la siguiente línea
		System.out.println("Han construido un monstruo");
	}
	
	// Acciones de cada monstruo
	
	/**
	 * El monstruo dispara con una determinada probabilidad. El objeto Monster tendrá un valor determinado
	 * para su propiedad "probabilidadDisparo". Por ejemplo, si la probabilidad es "30" obtendremos un número
	 * al azar entre 0 y 100. Si el número al azar es menor o igual a 30, dictaminaremos que la probabilidad
	 * se ha cumplido, por lo que realizaremos un disparo.
	 */
	public void dispara() {
		int numAzar = (int) Math.round(Math.random() * 100); // Obtengo un número al azar entre 0 y 100
		// Si el número es menor o igual a la probabilidadDisparo del objeto, decido disparar
		if (numAzar < probabilidadDisparo) {
			System.out.println(nombre + " Dispara"); // Simulación de un disparo
		}
	}

}
