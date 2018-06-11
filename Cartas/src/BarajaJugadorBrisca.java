import java.util.Vector;

public class BarajaJugadorBrisca extends Baraja {
	
	//Atributos de subclase
	
	public Vector<Carta> listaCartas;  //se inicializará en los contructores
	
	
	//Constructor
	public BarajaJugadorBrisca(){
		
		this.listaCartas = new Vector<Carta>(3);
		
	}

	
	//MÉTODOS DE CLASE
	
	
	
	
	
	public void imprimirCartas(Vector<Carta> lista3Cartas) {
		
		Carta c;
		
		 //recorre la baraja (hasta su tamaño) para leer e imprimir cada una de las cartas
		 
		  for(int j=0; j<listaCartas.size(); j++){
			  
			c = listaCartas.elementAt(j);    //asigna al objeto c, la carta en la posición j, en cada vuelta va recorriendo el mazo
			
		    System.out.printf("\n %d · %s \n", j+1, c.getNombreCarta());  //imprime el nombre de la carta
					
			}
	}
	
	
	public boolean sinCartas(){
		
		return this.listaCartas.isEmpty();  //devuelve T o F al método estáVacío, indica si quedan o no cartas en el mazo
	}
	
	
	public Carta Tira1(int a){

		Carta c;		//Declaramos una vble clase Carta

		c=listaCartas.elementAt(a-1);  //la inicializamos asignándole el elemento de la BarajaJugador que se tira a la mesa (1,2 o 3 ) para el user
										//firstElement() accede al primer elemento 

		listaCartas.remove(c);	//eliminamos el elemento escogido de la Baraja.

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
