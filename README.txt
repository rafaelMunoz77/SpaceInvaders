Creación de un proyecto SpaceInvaders, en el que se comienza estudiando conceptos de programación orientada a objetos
y se termina construyendo un videojuego completamente funcional. El repositorio se divide en diferentes ramas, cada 
una va aportando nuevos aspectos al desarrollo del código. Son ramas incrementales.

El contenido de las ramas, o versiones del juego, es el siguiente:

v.01 - Conceptos de orientación a Objetos: Clase, objeto (o instancia) y método constructor 
- Explicación del concepto de clase y objeto
- Creación de un método constructor en la clase Monster
- Ejemplo de creación de dos objetos de tipo "Monster" en la clase SpaceInvaders.

v.02 - Acciones o métodos de los objetos de una clase
- Creación del método disparar() de la clase Monster
- Utilización del método disparar() desde la clase SpaceInvaders, creando un bucle infinito y observando como las 
	instancias de Monster disparan en función a su probabilidad.
	
v.03 - Constructores y visibilidad
- Creación de diferentes tipos de constructores con argumentos de entrada
- Creación del método toString()
- Creación de un método private boolean voyADisparar()

v.04 - This, getters y setters
- Aplicación de "this" en el constructor de Monster
- Creación de métodos setters y getters de Monters

v.05 - Variables estáticas
- Ejemplo de variables estáticas para nombres de las imágenes del monstruo.

v.06 - Aparece una nueva clase: Player
- Creación de nueva clase para el Player

v.07 - Herencia, subclases, superclases y "super()"
- Explicación del concepto de herencia, subclases y superclases
- Relación de herencia con una nueva clase: Actor
- Explicación del significado de super

v.08 - La ventana
- Se crea un objeto de tipo JFrame, que se traduce en una ventana visible con la que el usuario puede interactuar

v.09 - Primeros objetos sobre la ventana 
- Creo diferentes tipos de objetos comunes en las interfaces gráficas y los agrego sobre la ventana.
- Para agregar objetos a una ventana se debe acceder a su "contentPane", un panel dentro de la ventana
- Para Colocar objetos sobre un panel, debo asignar una plantilla (un Layout) al panel. Elijo el BorderLayout

v.10 - Creación de un Canvas propio, que permite sobrescribir el méotodo paint() para pintar aquello que nosotros decidamos

v.11 - Clases abstractas
- Se ha convertido la clase Actor en abstracta, al incluir un método abstracto para que cada actor se pinte
- Se ha implementado el método abstracto en el monstruo y en el player
- La clase SpaceInvaders crea una lista de actores (player y monstruos) y se la pasa al Canvas para que este la pinte, aprovechando
	el método abstracto.
	
v.12 - Redibujamos la escena continuamente
- Anulamos los eventos de redibujado del objeto canvas.
- Calculo varios valores necesarios para que el juego se actualice 60 veces por segundo (FPS), en la clase SpaceInvaders
- La clase Actor incorpora un nuevo método abstracto para que cada actor pueda realizar cambios en su estado, para cada frame
- Ahora los monstruos se mueven por la pantalla, actualizando su situación en cada FPS.

v.13 - Controlando el cierre de la ventana
- Se añade lógica de computación para observar el evento de cierre de la ventana. En ese 
momento preguntaremos al usuario para que confirme la acción. Si la confirma cerramos la ventana
  
v.14 - Convertimos la clase SpaceInvaders a un Singleton.

v.15 - Aprovechamos el Singleton para conseguir que los monstruos reboten correctamente, al  tener
estos acceso a las medidas reales que ocupa el Canvas.

v.16 - Redirijo los eventos de ratón desde el Canvas hasta el jugador.
- Utilizo la sobrescritura del método "mouseMoved()" de un MouseAdapter para controlar el evento
de que el ratón se mueva sobre el Canvas. Redirijo dicho evento hacia un método en el jugador.

v.17 - Redirijo los eventos de teclado desde el Canvas hasta el jugador.
- Realizo los mismos pasos de la versión 16 utilizando un KeyListener.

v.18 - Utilizo un doble búffer en la memoria de vídeo, para evitar parpadeos en la imagen
- Utilizo el objeto "BufferStrategy" que se puede obtener del Canvas.

v.19 - Incorporo la posibilidad de que el player dispare.
- Se crea una nueva clase, un Actor, llamado PlayerShoot
- CUando el player detecta la pulsación de la barra espaciadora, crea el nuevo disparo
- SpaceInvaders ahora tiene dos nuevas listas, una para incorporar nuevos actores al juego y otra para eliminar actores

v.20 - Canvas pide continuamente tomar el foco de la aplicación
- Hemos detectado un fallo en la aplicación. A veces la ventana puede tardar un poco más de la cuenta en aparecer y el 
canvas.requestFocus() puede no funcionar. Hemos puesto un mecanismo en la clase SpaceInvaders para que aseguremos que el canvas
acaba recibiendo el foco de la app.

v.21 - Detecto colisiones
- Cada actor ahora tiene un método que permite ser notificado cuando colisiona con otro actor.
- SpaceInvaders, la clase, ahora detecta con un doble bucle las colisiones entre actores
- Algunos actores desaparecen al colisionar con otros. El monstruo desaparece al colisionar con el player o el disparo.
El disparo desaparece al colisionar con un monster.

v.22 - Incorporo las imágenes
- Cada actor tiene un campo llamado img, le cambio el tipo de String a BufferedImage.
- Aparece una nueva clase, llamada ImagesCache, que tiene un HashMap con todas las imágenes que intervienten en el juego. La
clase es un singleton con un método que permite buscar un fichero de imagen en el disco duro
- Cambiamos ligeramente los constructores de los subtipos de los actores, para que cada subtipo tenga la responsabilidad de
saber el nombre de su imagen.
- Cuando el constructor del tipo Actor recibe una nueva imagen, llama al método "setImg()", que se encarga de ajustar el ancho
y el alto del actor.