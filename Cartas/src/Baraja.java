import java.util.Vector;

public class Baraja {
	
	//Atributos (privados) pero cambiados a public para poder acceder desde la clase Brisca,etc.:
	
	public Vector<Carta> listaCartas;  //se inicializará en los contructores

	
	
	//Constructor baraja VACIA 


	public Baraja(){
		
		this.listaCartas = new Vector<Carta>(40);  //se construye indicando el tipo de objeto que contendrá <Carta>
	}												//y la talla, 40 elementos
	
	
	//Constructor baraja tipo 1 (simple) o 2 (doble);
	
	
	public Baraja(int tipo){
		this();
					
				
		for(int i=0; i<tipo; i++){   //recorre 1 o 2 veces la baraja para asignar cartas.
			for(int j=0; j<40; j++){
				
				Carta c = new Carta(j+1);  //crea objeto con id desde 1 hasta 40 (u 80 si es doble).
				
				listaCartas.addElement(c);//asigna carta a la listaCartas (a la Baraja) de forma ordenada.
				
			}
		}
	}
		
	//Constructor de Baraja según tipo y si debe ser barajada o no (si barajar=True o False)
	
	public Baraja(int tipo, boolean barajar){
		
		this(tipo);
		if (barajar) Barajar();
	}
	
	public Baraja(String nombreJuego){
		
		if (nombreJuego.equalsIgnoreCase("brisca")){
			
			this.listaCartas = new Vector<Carta>(3);
		}
	}
		
	
	//PROPIEDADES
	
	public int getNumeroCartas(){
		
		return this.listaCartas.size();  //devuelve la talla del vector, según las cartas que tenga
										//en ese momento la baraja
	}
	
	public boolean Vacia(){
		
		return listaCartas.isEmpty();  //devuelve T o F al método estáVacío, indica si quedan o no cartas en el mazo
	}


	//METODOS DE CLASE
	
	
	
	public void Barajar() {		//Mezcla aleatoriamente las cartas
		
		Carta c;	
		
		Vector<Carta> auxiliar = new Vector<Carta>(getNumeroCartas());
		
		int random;
		
		while (!Vacia()){  //mientras no esté vacía la baraja
			
			random =(int)(Math.random()*getNumeroCartas()); //saca número al azar para localizar una carta
			
			c =listaCartas.elementAt(random); //asigna la carta de la baraja al objeto Carta c
			
			auxiliar.addElement(c);		//añade al vector auxiliar la carta.
			
			listaCartas.remove(c);  //quita la carta de la baraja original
		}
		
		this.listaCartas=auxiliar;  //cuando finaliza el while, baraja vacía, asignamos el vector auxiliar al original
	}
		
		
	
	
	public void Cortar (int posicion){   //Consiste en pasar tantas cartas como nos
										//digan desde la primera posición a la última.
		
	  Carta c;
		
	    for (int i=0; i<posicion; i++){   //recorremos la baraja hasta la posición por la que cortamos
		  
		  c = Robar();						//vamos robando cartas hasta esa posición con el bucle
		  
		  this.listaCartas.addElement(c);	//vamos anyadiendo cada carta robada al final del mazo
			
			
		}
		
	}
		
		
	public Carta Robar(){

		Carta c;		//Declaramos una vble clase Carta

		c=this.listaCartas.elementAt(0);  //la inicializamos asignándole el primer elemento de la Baraja actual
										//firstElement() accede al primer elemento 

		this.listaCartas.remove(c);	//eliminamos el elemento escogido de la Baraja.

		return c;	//El método devuelve la carta robada, la primera del mazo.
	}
	
	
	
	public void InsertaCartaFinal(int id_carta){
		
	  Carta c = new Carta(id_carta);	//con la id de la carta llamamos al constructor
		
	  this.listaCartas.addElement(c); //las cartas de adicionan al final automáticamente en Vector<>
		
	}
	
	
	public void InsertaCartaPrincipio(int id_carta){  
		
	  Carta c = new Carta(id_carta);  //con la id de la carta llamamos al constructor
			
	  this.listaCartas.insertElementAt(c,0); //insertamos elemento c en la posición inicial 0
		
	}
	
	
	public void InsertaCartaFinal(Carta c){  
		
	  this.listaCartas.addElement(c);  //se adiciona la carta c al final de la baraja listaCartas
	}	
	
	
	//addElement las anyade automáticamente al final.
	
	
	public void InsertaCartaPrincipio(Carta c){
			
		 this.listaCartas.insertElementAt(c,0);  //se inserta la carta c pasada como parámetro en la posición 0.
	}
	
	
	
	public static void cajaTexto(String str){
		
      int n = str.length();
		
      for(int i = 0; i < n + 4; i++){
			
	    System.out.print("#");
			
	  }
		
      System.out.println();
      System.out.println("# " + str + " #");
		
      for(int i = 0; i < n + 4; i++){
			
	    System.out.print("#");
			
	  }
		
      System.out.println();
}			
	
	public Carta Acceso(int posicion){  //Acceder a una posición concreta del mazo
		
		Carta c;		//Declaramos una vble clase Carta

		c=this.listaCartas.elementAt(posicion);  //la inicializamos asignándole el primer elemento de la Baraja actual

		
		return c;	//El método devuelve la carta que esté en la posición que se pasa en el parámetro.
		
	}
	
	public static void imprimirBaraja(Baraja mazo1){
		
		  Carta c;
			
		 //recorre la baraja (hasta su tamaño) para leer e imprimir cada una de las cartas
		 
		  for(int j=0; j<mazo1.getNumeroCartas(); j++){
			  
			c = mazo1.Acceso(j);    //asigna al objeto c, la carta en la posición j, en cada vuelta va recorriendo el mazo
			
		    System.out.printf("\n %d·%s \n",j,c.getNombreCarta());  //imprime el nombre de la carta
					
			}
		}


	public Carta Tira1(int a){

		Carta c;		//Declaramos una vble clase Carta

		c=this.listaCartas.elementAt(a-1);  //la inicializamos asignándole el elemento de la BarajaJugador que se tira a la mesa (1,2 o 3 ) para el user
										//firstElement() accede al primer elemento 

		this.listaCartas.remove(c);	//eliminamos el elemento escogido de la Baraja.

		return c;	//El método devuelve la carta tirada en la mesa, la elegida por el jugador.
	}
	
	public Carta Tira2(int a){

		Carta c;		//Declaramos una vble clase Carta

		c=listaCartas.elementAt(a-1);  //la inicializamos asignándole el elemento de la BarajaJugador que se tira a la mesa (1,2 o 3 ) para el user
										//firstElement() accede al primer elemento 

		listaCartas.remove(c);	//eliminamos el elemento escogido de la Baraja.

		return c;	//El método devuelve la carta tirada en la mesa, la elegida por el jugador.
	}
	
	
	
	
	
	
	
}



