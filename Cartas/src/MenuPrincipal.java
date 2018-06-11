import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int option;
		System.out.println("Introduzca una opción de juego:");
		
		option = sc.nextInt();
		
		switch(option){
		
		case 1: SieteYMedio mySiete = new SieteYMedio();
				mySiete.jugar();
				break;
		case 2: 
			
				Brisca myBrisca = new Brisca();
				
				myBrisca.repartir();
				myBrisca.jugar();
				break;
		
		case 3: break;
			
		case 9: //salir menú 
				break;
		
		default: System.out.println("ÓPCION INCORRECTA");
				
		}
		
		//PRUEBAS JERARQUIA
		
		

	}

}
