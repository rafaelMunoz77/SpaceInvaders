package org.rmrsoft.spaceInvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.List;

/**
 * Clase que sobrescribe un objeto de tipo Canvas. Lo utilizaremos para poder pintar sobre él todo lo que queramos
 * @author Usuario
 *
 */
public class MiCanvas extends Canvas {
	
	List<Actor> actores = null;

	// BufferStrategy usado para conseguir la técnica de doble búffer
	private BufferStrategy strategy = null;


	/**
	 * Constructor
	 * @param actores
	 */
	public MiCanvas (List<Actor> actores) {
		this.actores = actores;
	}
	
	/**
	 * 
	 */
	public void pintaEscena () {
		// Tengo que inicializar el objeto "strategy" una única vez
		if (this.strategy == null) {
			// El Canvas se dibujará en pantalla con una estrategia de doble búffer
			this.createBufferStrategy(2);
			// Obtengo una referencia a la estrategia de doble búffer.
			strategy = getBufferStrategy();
			// Resuelve un problema de sincronización de memoria de vídeo en Linux
			Toolkit.getDefaultToolkit().sync();			
		}
		// Obtengo el objeto gráfico que me permita pintar en el doble búffer
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		// Pinto un rectángulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Pinto cada uno de los actores
		for (Actor a : this.actores) {
			a.paint(g);
		}

		// Muestro en pantalla el buffer con el nuevo frame creado para el juego
		strategy.show();

	}
}
