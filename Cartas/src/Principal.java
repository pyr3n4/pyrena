import java.util.Scanner;

/**
 * 
 *  JUEGO DEL 7 Y MEDIO
 *  
 *  */

public class Principal {

	public static void main(String[] args) {
		
		
		boolean barajar=true;    //BARAJAR O NO BARAJAR
		boolean plantarse = false;
		boolean pierde = false;
		boolean finJuego = false;
		double puntuacion;
		double totalPuntos;
		String respuesta = "";
		String seguirJugando = "";
		Scanner sc = new Scanner(System.in);
		
	  //Dar la bienvenida, crear baraja y barajarla (tercer constructor para la clase Baraja)
		
		
		
		cajaTexto("Bienvenido al Siete y Medio");
		
				
		while (!finJuego){  // un while finJuego para poder terminar de jugar o jugar otra mano
			
			Baraja baraja7dot5 = new Baraja(1,barajar);
			Baraja mazoJugador = new Baraja();
			puntuacion = 0;
			totalPuntos = 0;
			
			imprimirBaraja(baraja7dot5);
		 
		  do{   //do while para continuar partida hasta el final o plantarse
			  
			  System.out.printf("\n\n¿Desea carta(c) o se planta(p)?\n");
			  
			  respuesta = sc.next();
			  
			  if (respuesta.equalsIgnoreCase("c")){ //jugador quiere carta
				  
				plantarse = false;
					
				Carta c;
				    
				c = baraja7dot5.Robar();	//robar carta de baraja para el mazo del jugador
				    
				mazoJugador.InsertaCartaFinal(c);  //se la damos al jugador
				
				puntuacion = c.getValor7ymedia();  //se obtiene el valor de la carta añadida
				
				imprimirBaraja(mazoJugador);  //imprimimos el mazo actual del jugador
					
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
					  
					  imprimirBaraja(mazoJugador);  //imprimimos el mazo actual del jugador
																		
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
			  
			  cajaTexto("¡Gracias por jugar al 7 y medio!");
		  }
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	//MÉTODOS DE LA CLASE PRINCIPAL
	
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


	
public static void imprimirBaraja(Baraja mazo1){
		
  Carta c;
	
 //recorre la baraja (hasta su tamaño) para leer e imprimir cada una de las cartas
 
  for(int j=0; j<mazo1.getNumeroCartas(); j++){
	  
	c = mazo1.Acceso(j);    //asigna al objeto c, la carta en la posición j, en cada vuelta va recorriendo el mazo
	
    System.out.printf("\n %s \n", c.getNombreCarta());  //imprime el nombre de la carta
			
	}
}

	






}
