package org.rmrsoft.spaceInvaders;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
		Monster m1 = new Monster(50, 60, Monster.IMAGEN_BICHO_0, "m1", 75);
		
		// Creo un nuevo monstruo
		Monster m2 = new Monster(100, 120, Monster.IMAGEN_BICHO_1, "m2", 10);
		m2.setNombre("Nuevo Monstruo");
		
		// Muestro los monstruos
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		//Construyo un player para este juego
		Player jugador = new Player(10, 20, Player.IMAGEN_PLAYER);
		System.out.println(jugador.toString()); // Muestro datos del objeto Player
		
		// Creo y muestro una ventana
		creaYMuestraVentana();
	}
	
	/**
	 * Crea una ventana, le agrega algunos componentes de prueba y la muestra
	 */
	private static void creaYMuestraVentana() {
		JFrame ventana = new JFrame("Space Invaders");
		ventana.setBounds(0, 0, 800, 600);
		
		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo un objeto de tipo TextField y lo agrego
		JTextField jtfDemo = new JTextField("Esto es el javax.swing.JTextField");
		ventana.getContentPane().add(jtfDemo, BorderLayout.CENTER);
		
		// Creo y agrego un botón de acción
		JButton jbtDemo = new JButton("Esto es el javax.swing.JButton");
		ventana.getContentPane().add(jbtDemo, BorderLayout.SOUTH);
		
		// Creo y agrego un objeto de tipo "check"
		JCheckBox jcheckDemo = new JCheckBox("Esto es el javax.swing.JCheckBox");
		ventana.getContentPane().add(jcheckDemo, BorderLayout.NORTH);
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.CYAN);
		canvas.setSize(new Dimension(100, 100));
		ventana.getContentPane().add(canvas, BorderLayout.WEST);
		
		// Creo y agrego un objeto de opciones desplegables. Se basa en un array de Strings.
		String valoresComboBox[] = new String[] {"Opción 1", "Opción 2", "Opción 3"};		
		JComboBox<String> jcbDemo = new JComboBox<String>(valoresComboBox);
		ventana.getContentPane().add(jcbDemo, BorderLayout.EAST);
		
		// Hago que la ventana sea visible
		ventana.setVisible(true);
		
	}

}
