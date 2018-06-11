import java.util.Scanner;

public class Brisca extends Juego {

	//Atributos de clase
	
	
	public Baraja mazoJugador1;
	//private Baraja mazoGanadasJ1;
	public Baraja mazoJugador2;
	//private Baraja mazoGanadasJ2;
	//private double puntosJugador1;
	//private double puntosJugador2;
	private Scanner sc;
	private int turno;
	
	//Constructor 
	
	public Brisca(){
		
		super("Brisca");
		this.mazoJugador1 = new Baraja("Brisca");
		//this.mazoGanadasJ1 = new Baraja();
		this.mazoJugador2 = new Baraja("Brisca");
		//this.mazoGanadasJ2 = new Baraja();
		//this.puntosJugador1 = 0;
		//this.puntosJugador2 = 0;
		this.turno = 1;
	}
	
	
	public void jugar(){
		
		sc = new Scanner(System.in);
		
		//Introducir los nombres de los jugadores
		
		System.out.printf("\n INTRODUZCA EL NOMBRE DEL JUGADOR 1: \n");
		nombreJugador1 = sc.next();
		
		System.out.printf("\n INTRODUZCA EL NOMBRE DEL JUGADOR 2: \n");
		nombreJugador2 = sc.next();
		
		//Crear Brisca con baraja más barajas jugadores (en Main, menú case x)
		
		//Repartir cartas (en Main, menú case x)
		
	 	
		//Obtener carta triunfo e insertarla al fin 
		Carta triunfo;
		triunfo = mostrarTriunfo();	
		int paloTriunfo = triunfo.getPalo();
		imprimirTriunfo(triunfo);
	  
	
	 		
		//Mientras queden cartas en los mazos de los jugadores (!sinCartas())
	  
	  while(!mazoJugador1.Vacia() && !mazoJugador2.Vacia()){
		  
		 
		//mostrar cartas jugador 1
		  
		  System.out.printf("\n CARTAS JUGADOR 1: \n");
		  mazoJugador1.imprimirBaraja(mazoJugador1);
		  
		  		  
		//mostrar cartas jugador 2 
		  
		  System.out.printf("\n CARTAS JUGADOR 2: \n");
		  mazoJugador2.imprimirBaraja(mazoJugador2);
		  
		 
		  
		  if( turno == 1){
				
			//Solicitar carta al jugador 1 y calcular valor carta
			  
			  System.out.printf("\n\n Turno del JUGADOR 1 ->> Indique carta a jugar (1,2 o 3) \n");
			 
			  int n = sc.nextInt();
			  Carta cj1 =  mazoJugador1.Tira1(n);
			  System.out.printf("\n %s tira la carta: ", nombreJugador1);
			  cj1.imprimirCarta(cj1);
			  cj1.getValorTuteYBrisca();
			  
			//Solicitar carta al jugador 2 y calcular valor carta
			  
			  System.out.printf("\n\n Turno del JUGADOR 2 ->> Indique carta a jugar (1,2 o 3) \n");
			  
			  int m = sc.nextInt();
			  Carta cj2 =  mazoJugador2.Tira2(m);
			  System.out.printf("\n %s tira la carta: ", nombreJugador2);
			  cj2.imprimirCarta(cj2);
			  cj2.getValorTuteYBrisca();
			  
			  if( cj1.esMayorEnBrisca(cj2,paloTriunfo) ){
					 
					 sumarPuntosJugador(cj1.getValorTuteYBrisca(),cj2.getValorTuteYBrisca(),nombreJugador1);
					
				  	 System.out.printf("Se las lleva %s.", nombreJugador1);
					
					 this.turno = 1;
					
				  }else{
					 
					 sumarPuntosJugador(cj1.getValorTuteYBrisca(),cj2.getValorTuteYBrisca(),nombreJugador2);
					 
					 System.out.printf("Se las lleva %s.", nombreJugador2);
					 
					 this.turno = 2;		
				 }
			  
			  
			 }else if(turno == 2){
				 
				//Solicitar carta al jugador 2 y calcular valor carta
				 
				 System.out.printf("\n\n Turno del JUGADOR 2 ->> Indique carta a jugar (1,2 o 3) \n");
				  
				  int m = sc.nextInt();
				  Carta cj2 =  mazoJugador2.Tira2(m);
				  System.out.printf("\n %s tira la carta: ", nombreJugador2);
				  cj2.imprimirCarta(cj2);
				  cj2.getValorTuteYBrisca();
				  
				//Solicitar carta al jugador 1 y calcular valor carta
				  
				  System.out.printf("\n\n Turno del JUGADOR 1 ->> Indique carta a jugar (1,2 o 3) \n");
				 
				  int n = sc.nextInt();
				  Carta cj1 =  mazoJugador1.Tira1(n);
				  System.out.printf("\n %s tira la carta: ", nombreJugador1);
				  cj1.imprimirCarta(cj1);
				  cj1.getValorTuteYBrisca();
				  
				  if( cj1.esMayorEnBrisca(cj2,paloTriunfo) ){
						 
						 sumarPuntosJugador(cj1.getValorTuteYBrisca(),cj2.getValorTuteYBrisca(),nombreJugador1);
						
					  	 System.out.printf("Se las lleva %s.", nombreJugador1);
						
						 this.turno = 1;
						
					  }else{
						 
						 sumarPuntosJugador(cj1.getValorTuteYBrisca(),cj2.getValorTuteYBrisca(),nombreJugador2);
						 
						 System.out.printf("Se las lleva %s.", nombreJugador2);
						 
						 this.turno = 2;		
					 }
				  
				  
				  
				  
				  
				  
			 }
		  
		  
		  
		//comprobar quien gana y sumar puntos al jugador que se las lleva
		  
		 
		 	
		 imprimirPuntuacion();
		 
		
		 
		//indicar de quien es el turno
		 
		 
		 
		//robar una carta cada jugador (si no está vacía la baraja)
		mazoJugador1.InsertaCartaFinal(baraja.Robar()); //Roba primero el jugador que se las ha llevado
		mazoJugador2.InsertaCartaFinal(baraja.Robar());
		 
	  }
	  
	  //Mostrar resultados
	  
	  imprimirFinJuego();
			
			
			
			
			
			
			
		
		
			
		
	}
	
	//MÉTODOS DE CLASE 
	
	public void repartir(){
		
		Carta c;
		
		for(int i=0; i<3; i++){   //bucle para robar y entregar 3 veces (0,1,2)
			
			c = baraja.Robar();
			
			this.mazoJugador1.listaCartas.insertElementAt(c, i); //le entregamos carta a J1 en la posición i del vector
			
			c = this.baraja.Robar();
			
			this.mazoJugador2.listaCartas.insertElementAt(c, i); //le entregamos carta a J2 en la posicion i del vector
		}
		
	}
	
	
	public Carta mostrarTriunfo(){
		
		Carta tr;
		
		tr = this.baraja.Robar();
		
		this.baraja.InsertaCartaFinal(tr);
				
		return tr;
		
		
		
	}
	
	public void imprimirTriunfo(Carta tr){
		
		System.out.println("\nTRIUNFO: ");
		tr.imprimirCarta(tr);
		
	}
	
	
		
	
}
