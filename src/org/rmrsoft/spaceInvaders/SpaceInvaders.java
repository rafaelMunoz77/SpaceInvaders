package org.rmrsoft.spaceInvaders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

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
		JFrame ventana = new JFrame("Space Invaders");
		ventana.setBounds(0, 0, 800, 600);
		
		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		MiCanvas canvas = new MiCanvas(creaActores());
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		// Hago que la ventana sea visible
		ventana.setVisible(true);
		
	}
	
	/**
	 * 
	 * @return
	 */
	private static List<Actor> creaActores () {
		List<Actor> actores = new ArrayList<Actor>();
		
		//Construyo un player para este juego y lo agrego a la lista
		Player jugador = new Player(300, 300, Player.IMAGEN_PLAYER);
		actores.add(jugador);
		
		// Creo los Monstruos del juego
		for (int i = 0; i < 10; i++) {
			int xAleatoria = numAleatorio(10, 500);
			int yAleatoria = numAleatorio(10, 200);
			Monster m = new Monster(xAleatoria, yAleatoria, Monster.IMAGEN_BICHO_0, "m", 75);
			actores.add(m);
		}
		
		// Devuelvo la lista con todos los actores del juego
		return actores;
	}

	/**
	 * Obtención de un número aleatorio en unos límites
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	private static int numAleatorio (int minimo, int maximo) {
		return (int) Math.round(Math.random() * (maximo - minimo) + minimo);
	}
}
