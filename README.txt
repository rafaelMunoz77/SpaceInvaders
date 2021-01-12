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