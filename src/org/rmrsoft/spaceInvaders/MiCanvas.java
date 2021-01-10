package org.rmrsoft.spaceInvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que sobrescribe un objeto de tipo Canvas. Lo utilizaremos para poder pintar sobre él todo lo que queramos
 * @author Usuario
 *
 */
public class MiCanvas extends Canvas {

	/**
	 * Sobrescritura del méotod paint(), aquí tengo el control sobre aquello que se va a pintar en pantalla.
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.PINK);
		g.fillOval(100, 100, 100, 200);
	}
}
