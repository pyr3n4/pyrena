
public abstract class Juego {

	//Definición del tipo enumerado nombreJuego - REVISAR
	
	public enum nombreJuego{
		
		BRISCA, SIETE_Y_MEDIO, TUTE
	}
	
	
	
	//Atributos de la clase Juego, protected, heredables sólo por sus subclases
	
	protected Baraja baraja;
	protected String nombreJuego;
	protected String nombreJugador1;
	protected String nombreJugador2;
	protected double puntosJugador1;
	protected double puntosJugador2;
	protected int numeroMano;
	
	
	//Constructor
	
	public Juego(String nombre){  //el constructor es abstracto, por norma general el constructor inicializa las variables de clase
		
		this.baraja = new Baraja(1,false);  //cambiar para BARAJAR
		this.nombreJuego = nombre;
		this.puntosJugador1 = 0;
		this.puntosJugador2 = 0;
		this.numeroMano = 0;
		
		imprimirCabecera();
		
	}
	
	
	//Métodos de clase
	
	
	
	private void imprimirCabecera(){  //imprimir el nombre del juego dentro de una caja de caracteres
		
				
		      int n = this.nombreJuego.length();
				
		      for(int i = 0; i < n + 4; i++){
					
			    System.out.print("#");
					
			  }
				
		      System.out.println();
		      System.out.println("# " + this.nombreJuego + " #");
				
		      for(int i = 0; i < n + 4; i++){
					
			    System.out.print("#");
					
			  }
				
		      System.out.println();
				
		
		
	}
	
	public abstract void jugar();  //el método jugar() es abstracto y se implementará 
								//obligatoriamente en las subclases
	
	
	protected void imprimirFinJuego(){
		
		System.out.printf("El jugador: %s ha obtenido un total de %f puntos." , this.nombreJugador1, this.puntosJugador1);
		System.out.printf("El jugador: %s ha obtenido un total de %f puntos." , this.nombreJugador2, this.puntosJugador2);
		
		if (this.puntosJugador1 > this.puntosJugador2)  System.out.printf("Nuestra enhorabuena al ganador: %s", this.nombreJugador1);
		  else if (this.puntosJugador1==this.puntosJugador2)  System.out.printf("¡¡Tenemos empate!!");
		    else  System.out.printf("Nuestra enhorabuena al ganador: %s", this.nombreJugador2);
		
		
		System.out.printf("\n ¡Gracias por jugar al 7 y medio! \n");
	}
	
	protected void imprimirPuntuacion(){  //imprime la puntuación que tienen los jugadores en el momento en que se llame al método.
		
		System.out.print("\n\n-------------------------------------------------");
		System.out.printf("El jugador %s tiene: %.2f puntos.\n" , this.nombreJugador1, this.puntosJugador1);
		System.out.print("-------------------------------------------------");
		System.out.printf("El jugador %s tiene: %.2f puntos.\n\n" , this.nombreJugador2, this.puntosJugador2);
		
	}
	
	protected void sumarPuntosJugador(int puntos1, int puntos2, String nombreJugador){
		
		if(nombreJugador == this.nombreJugador1)  this.puntosJugador1 = this.puntosJugador1 + puntos1;
		else									  this.puntosJugador2 = this.puntosJugador2 + puntos2;
		
	}
	
	//Propiedades
	
	//Establecer el nombre de los jugadores. Se llamará desde la subclase (Brisca,Tute..)
	
	protected void setNombreJugador1(String nombre){
		this.nombreJugador1 = nombre;
	}
	
	protected void setNombreJugador2(String nombre){
		this.nombreJugador2 = nombre;
		
	}
	
	
}
