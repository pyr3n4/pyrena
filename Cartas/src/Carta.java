
public class Carta {

	//Atributos PRIVADOS para la clase
	
	private int numCarta;  //8 la sota, el 9 el caballo y el 10 el rey
	private int palo;		//oros, copas, espadas y bastos 0,1,2,3
	
	
	//Constructor 1 PÚBLICO
	
	public Carta(int numCarta, int palo){
		
		this.numCarta=numCarta;
		this.palo=palo;
		
		
	}
	
	//Constructor 2 PÚBLICO
	
	public Carta(int id){   //1<=id<=40  1 as de oros y 40 rey bastos
		
		if (id%10 == 0){
			
			this.numCarta = 10;
			this.palo=(id/10)-1;
				
		}else{
			
			this.numCarta=id%10;
			this.palo=(int)id/10;
		}
		
		
	}
	
	//Propiedades PÚBLICAS (getters and setters según diga el ejercicio)
	
	
	public int getNumCarta(){  //sólo lectura del número de carta
		
		return this.numCarta;
		
	}
	
	public int getPalo(){  //sólo lectura del número de carta
		
		return this.palo;
		
	}
	
	
	public String getNombreNumero(){  //Devuelve el número de la carta en texto 1=as y 12=rey
									// Atención a la posición 0, debe estar vacía porque el as es nº1.
		
		String vNumCartaTexto [] = {"","as","dos","tres","cuatro","cinco","seis","siete","sota","caballo","rey"};
		
		String numTexto = vNumCartaTexto[this.numCarta];
		
				
		return numTexto;
	}
	
	public String getNombrePalo(){  //Devuelve el palo en texto según el número de palo (0,1,2,3)
		
		String vPaloTexto [] = {"oros","copas","espadas","bastos"};
		
		String paloTexto = vPaloTexto[this.palo];
		
		return paloTexto;
	}
	
	
	public String getNombreCarta(){
		
				
		String nombreCarta = getNombreNumero() + " de " + getNombrePalo();
		
		return nombreCarta;
	}
	
	
	public int getValorTuteYBrisca(){  //Devuelve el valor de la carta en el Tute 
								//(1 = 11, 3 = 10, sota = 2, caballo = 3, rey = 4)
		
		int valorTute;
		
		if      (this.numCarta==1)  valorTute=11;
		else if (this.numCarta==3)  valorTute=10;
		else if (this.numCarta==8)  valorTute=2;
		else if (this.numCarta==9)  valorTute=3;
		else if (this.numCarta==10) valorTute=4;
		else                        valorTute=0;
		
			
		return valorTute;
	}
	
	public int getValorJugadaBrisca(){  //Devuelve el valor de la carta en el Tute 
		//(1 = 11, 3 = 10, sota = 2, caballo = 3, rey = 4)

		int valorJugadaBrisca;

		if      (this.numCarta==1)  valorJugadaBrisca=11;
		else if (this.numCarta==3)  valorJugadaBrisca=10;
		else if (this.numCarta==8)  valorJugadaBrisca=2;
		else if (this.numCarta==9)  valorJugadaBrisca=3;
		else if (this.numCarta==10) valorJugadaBrisca=4;
		else                        valorJugadaBrisca=this.numCarta;


		return valorJugadaBrisca;
	}
	
	public int getValorMus(){  //Devuelve el valor de la carta para el Mus (1, 2 = 1; 
		
								//3, sota, caballo y rey = 10, el resto su valor)
		
		int valorMus;
		
		if      (this.numCarta==1 || this.numCarta==2)  valorMus=1;
		else if (this.numCarta==3 || this.numCarta==8 || this.numCarta==9 || this.numCarta==10)  valorMus=10;
		else valorMus = this.numCarta;
		
		return valorMus;
	}
	
	
	public double getValor7ymedia(){  //Devuelve el valor de medio punto 0.5 para las figuras, y para
										//el resto de cartas su valor (1 al 7)
		
		double valor7yMedia;
		
		if (this.numCarta==8 || this.numCarta==9 || this.numCarta==10) valor7yMedia=0.5;
		else valor7yMedia=this.numCarta;
		
		
		return valor7yMedia;
	}
	
	
	public void imprimirCarta(Carta c){
				
		System.out.printf("    %s    ", c.getNombreCarta());
	}
	
	
	public void marcoCarta(String str){  //para imprimir el nombre Carta con marco
		
	      int n = str.length();
			
	      for(int i = 0; i < n + 4; i++){
				
		    System.out.print("·");
				
		  }
			
	      System.out.println();
	      System.out.println("· " + str + " ·");
			
	      for(int i = 0; i < n + 4; i++){
				
		    System.out.print("·");
				
		  }
			
	      System.out.println();
	}			
	
	public boolean esMayorEnBrisca(Carta cj2, int paloTriunfo ){ //invocar para el objeto cj1 en el juego de la Brisca
		
		boolean esMayor = false; //vble que devuelve el método
		
		//Si la carta1 para la que invocamos el método tiene el mismo palo que la carta2 que vamos a comparar
		//la vble. tendrá el valor T si la carta1 es mayor que la carta2 teniendo en cuenta sus valores en jugada
		//y será F en el caso contrario
		if (this.getPalo() == cj2.getPalo())  esMayor = this.getValorJugadaBrisca()>cj2.getValorJugadaBrisca();
		//si el palo de la carta2 con la que comparamos es del palo del triunfo, carta1 nunca será mayor.
		else if (cj2.getPalo() == paloTriunfo) esMayor = false;
		else esMayor = true; //y en caso contrario, carta1 será la mayor
		
		return esMayor;
	}
	
}
