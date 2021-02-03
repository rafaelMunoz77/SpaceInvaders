package org.rmrsoft.spaceInvaders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Clase principal, que crea los monstruos
 *
 */
public class SpaceInvaders {

	private static int FPS = 60;
	private JFrame ventana = null;
	private List<Actor> actores = new ArrayList<Actor>();
	private MiCanvas canvas = null;
	Player jugador = null;
	private List<Actor> actoresParaIncorporar = new ArrayList<Actor>();
	private List<Actor> actoresParaEliminar = new ArrayList<Actor>();
	
	// Para utilizar un patrón singleton necesitamos la siguiente propiedad estática
	private static SpaceInvaders instance = null;
	
	/**
	 * Este método representa la principal funcionalidad de un patrón Singleton.
	 * Devuelve la única instancia que puede existir del esta clase. Si no se ha 
	 * inicializado, en la primera llamada a este método se realiza dicha 
	 * inicialización.
	 */
	public static SpaceInvaders getInstance () {
		if (instance == null) { // Si no está inicializada, se inicializa
			instance = new SpaceInvaders();
		}
		return instance;
	}
	
	
	/**
	 * Constructor
	 */
	public SpaceInvaders () {
		ventana = new JFrame("Space Invaders");
		ventana.setBounds(0, 0, 800, 600);
		
		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla) al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());
		
		// Creo una lista de actores que intervendrá en el juego.
		actores = creaActores();
		
		// Creo y agrego un canvas, es un objeto que permitirá dibujar sobre él
		canvas = new MiCanvas(actores);
		// Envío los eventos de movimientos de ratón al jugador
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				jugador.mover(e.getX(), e.getY());
			}			
		});
		
		// Desvío los eventos de teclado hasta el jugador
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				jugador.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				jugador.keyReleased(e);
			}
		});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		// Consigo que la ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// Hago que la ventana sea visible
		ventana.setVisible(true);
				
		// Control del evento de cierre de ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Realizo la carga de los recursos en memoria
		ResourcesCache.getInstance().cargarRecursosEnMemoria();
		
		
		// Comienzo un bucle, que consistirá en el juego completo.
		SpaceInvaders.getInstance().juego();
	}
	
	
	
	
	/**
	 * Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	

	
	/**
	 * Bucle del juego principal
	 */
	public void juego () {
		int millisPorCadaFrame = 1000 / FPS;
		do {
			// No sé cuando se va a mostar la ventana y hasta entonces no puedo utilizar la instrucción canvas.requestFocus();
			// Por tanto, en este bucle compruebo constantemente si el canvas tiene el foco y, si no lo tiene, se lo doy
			if (ventana.getFocusOwner() != null && !ventana.getFocusOwner().equals(canvas)) {
				canvas.requestFocus();
			}
			
			
			// Redibujo la escena tantas veces por segundo como indique la variable FPS
			// Tomo los millis actuales
			long millisAntesDeProcesarEscena = new Date().getTime();
			
			// Redibujo la escena
			canvas.pintaEscena();
			
			// Recorro todos los actores, consiguiendo que cada uno de ellos actúe
			for (Actor a : actores) {
				a.actua();
			}
			
			// Tras hacer que cada actor actúe y antes de agregar y eliminar actores, detecto colisiones
			detectaColisiones();
			
			// Acualizo los actores, incorporando los nuevos y eliminando los que ya no se quieren
			actualizaActores();
			
			// Calculo los millis que debemos parar el proceso, generando 60 FPS.
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			// "Duermo" el proceso principal durante los milllis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}
	
	
	/**
	 * 
	 * @return
	 */
	private List<Actor> creaActores () {
		List<Actor> actores = new ArrayList<Actor>();
		
		//Construyo un player para este juego y lo agrego a la lista
		jugador = new Player(300, 300);
		actores.add(jugador);
		
		// Creo los Monstruos del juego
		for (int i = 0; i < 10; i++) {
			int xAleatoria = numAleatorio(10, 500);
			int yAleatoria = numAleatorio(10, 200);
			Monster m = new Monster(xAleatoria, yAleatoria, 75);
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

	/**
	 * Método llamado para incorporar nuevos actores
	 * @param a
	 */
	public void incorporaNuevoActor (Actor a) {
		this.actoresParaIncorporar.add(a);
	}

	/**
	 * Método llamado para eliminar actores del juego
	 * @param a
	 */
	public void eliminaActor (Actor a) {
		this.actoresParaEliminar.add(a);
	}
	
	/**
	 * Incorpora los actores nuevos al juego y elimina los que corresponden
	 */
	private void actualizaActores () {
		// Incorporo los nuevos actores
		for (Actor a : this.actoresParaIncorporar) {
			this.actores.add(a);
		}
		this.actoresParaIncorporar.clear(); // Limpio la lista de actores a incorporar, ya están incorporados
		
		// Elimino los actores que se deben eliminar
		for (Actor a : this.actoresParaEliminar) {
			this.actores.remove(a);
		}
		this.actoresParaEliminar.clear(); // Limpio la lista de actores a eliminar, ya los he eliminado
	}
	

	/**
	 * Detecta colisiones entre actores e informa a los dos
	 */
	private void detectaColisiones() {
		// Una vez que cada actor ha actuado, intento detectar colisiones entre los actores y notificarlas. Para detectar
		// estas colisiones, no nos queda más remedio que intentar detectar la colisión de cualquier actor con cualquier otro
		// sólo con la excepción de no comparar un actor consigo mismo.
		// La detección de colisiones se va a baser en formar un rectángulo con las medidas que ocupa cada actor en pantalla,
		// De esa manera, las colisiones se traducirán en intersecciones entre rectángulos.
		for (Actor actor1 : this.actores) {
			// Creo un rectángulo para este actor.
			Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getAncho(), actor1.getAlto());
			// Compruebo un actor con cualquier otro actor
			for (Actor actor2 : this.actores) {
				// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
				if (!actor1.equals(actor2)) {
					// Formo el rectángulo del actor 2
					Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getAncho(), actor2.getAlto());
					// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
					if (rect1.intersects(rect2)) {
						actor1.colisionaCon(actor2); // El actor 1 colisiona con el actor 2
						actor2.colisionaCon(actor1); // El actor 2 colisiona con el actor 1
					}
				}
			}
		}
	}
	
	/**
	 * @return the canvas
	 */
	public MiCanvas getCanvas() {
		return canvas;
	}
	
	
}