import java.util.Scanner;

public class SieteYMedio extends Juego {

	//Atributos de clase
	
	private Baraja baraja7dot5;
	private Baraja mazoJugador;
	private int puntuacion;
	private int totalPuntos;
	boolean barajar=true;
	
	//Constructor 
	
	public SieteYMedio(){  //Este constructor inicializa las variables(atributos) de clase
		
	    //BARAJAR O NO BARAJAR
	super("SIETE_Y_MEDIO");
	this.mazoJugador = new Baraja();
	this.puntuacion = 0;
	this.totalPuntos = 0;
		
	}
	
	
	public void jugar(){
		
		
		boolean plantarse = false;
		boolean pierde = false;
		boolean finJuego = false;
		double puntuacion;
		double totalPuntos;
		String respuesta = "";
		String seguirJugando = "";
		Scanner sc = new Scanner(System.in);
		
	  //Dar la bienvenida, crear baraja y barajarla (tercer constructor para la clase Baraja)
		
		
		
				
		while (!finJuego){  // un while finJuego para poder terminar de jugar o jugar otra mano
			//TODO SEGUIR EXTRAYENDO PARA CREAR LA CLASE
			Baraja baraja7dot5 = new Baraja(1,this.barajar);
			Baraja mazoJugador = new Baraja();
			puntuacion = 0;
			totalPuntos = 0;
			
			Baraja.imprimirBaraja(baraja7dot5);
		 
		  do{   //do while para continuar partida hasta el final o plantarse
			  
			  System.out.printf("\n\n¿Desea carta(c) o se planta(p)?\n");
			  
			  respuesta = sc.next();
			  
			  if (respuesta.equalsIgnoreCase("c")){ //jugador quiere carta
				  
				plantarse = false;
					
				Carta c;
				    
				c = baraja7dot5.Robar();	//robar carta de baraja para el mazo del jugador
				    
				mazoJugador.InsertaCartaFinal(c);  //se la damos al jugador
				
				puntuacion = c.getValor7ymedia();  //se obtiene el valor de la carta añadida
				
				Baraja.imprimirBaraja(mazoJugador);  //imprimimos el mazo actual del jugador
					
				totalPuntos = totalPuntos + puntuacion;
				
				System.out.printf("\nSu carta es: %s y vale: %.1f puntos, el total es: %.1f puntos\n", c.getNombreCarta(),puntuacion,totalPuntos);
				
				//3 casos: 
				//sobrepasa 7.5 y la partida se termina perdiendo  //suma 7.5 y gana  //no llega a 7.5 y hay que seguir preguntando
				
								  
				  if(totalPuntos<7.5){
					
					 pierde = false;
					 
				  } else if(totalPuntos>7.5){
					
					 pierde = true;
														
					 System.out.println("\n¡Lo sentimos! Ha superado el límite de 7.5 puntos...¡Le esperamos de nuevo!\n ");
				  }
					  
					  
				} else if (respuesta.equalsIgnoreCase("p")){
					   
					  plantarse = true;
					  
					  Baraja.imprimirBaraja(mazoJugador);  //imprimimos el mazo actual del jugador
																		
					 //le indicamos la última puntuación obtenida hasta justo antes de plantarse
					  
					  System.out.printf("\nHa obtenido en total: %.1f puntos, le han faltado %.1f puntos para tener 7.5\n", totalPuntos,(7.5-totalPuntos));
					  					 
				   }
			  
			  				  
			  
			  
		  }while(!plantarse && !pierde);
		   
		  //preguntar si desea seguir jugando para cambiar valor de finJuego a true y parar bucle while principal
		  
		  System.out.println("\n¿Desea jugar otra mano(s/n)?\n");
		  
		  seguirJugando = sc.next();
		  
		  if(seguirJugando.equalsIgnoreCase("s")){
			  
			  finJuego = false;
			  
		  }else if(seguirJugando.equalsIgnoreCase("n")){
			  
			  finJuego = true;
			  
			  Baraja.cajaTexto("¡Gracias por jugar al 7 y medio!");
		  }
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
