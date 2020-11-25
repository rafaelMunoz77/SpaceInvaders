package org.rmrsoft.spaceInvaders;

/**
 * Esta clase representa las propiedades y acciones de un monstruo del videojuego SpaceInvaders
 */
public class Monster {
	// Propiedades privadas de cada monstruo
	private int x, y; // Coordenadas x e y del monstruo
	private String img; // Imagen del monstruo
	private String nombre; // Nombre que recibe el monstruo
	private int probabilidadDisparo; // Probabilidad de que ser realice un disparo
	
	//Propiedades estáticas de esta clase
	public static String IMAGEN_BICHO_0 = "bicho0.gif";
	public static String IMAGEN_BICHO_1 = "bicho1.gif";
	public static String IMAGEN_BICHO_2 = "bicho2.gif";
	
	/**
	 * Constructor sin argumentos de entrada
	 */
	public Monster() {
		// texto de prueba para comprobar que, al construir un objeto, se ejecuta la siguiente línea
		System.out.println("Han construido un monstruo");
	}
	
	/**
	 * Constructor más completo, con todas las propiedades del objeto
	 * @param newX
	 * @param newY
	 * @param newImg
	 * @param newNombre
	 * @param newProb
	 */
	public Monster(int x, int y, String img, String nombre, int probabilidadDisparo) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.nombre = nombre;
		this.probabilidadDisparo = probabilidadDisparo;
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
			System.out.println(nombre + " Dispara"); // Simulación de un disparo
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
		return "Nombre: " + nombre + " - x: " + x + " - y: " + y + " - img: " + img + " - ProbabilidadDisparo: " + probabilidadDisparo;
	}

	// Getters y Setters 
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

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
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

}
