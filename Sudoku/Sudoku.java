package arrays;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		
		/* int nivelDificultad = 1;  //Puesto a 1 para pruebas, el nivel lo elige el user
		
		int [][] sudokuOriginal = cargarJuego(1);
		int [][] sudokuJugar = cargarJuego(1);
		
		imprimirSudoku(sudokuJugar);
						
		/*imprimirMensajes("mensaje de PRUEBA");*/
		
		//La instrucción principal es un do-while, que iniciará el juego 
		//en tanto el usuario indique que quiere seguir ("s"), después de haber terminado un sudoku entero.
		
		Scanner sc = new Scanner(System.in);
		
		boolean seguir = false;	
		
		do{  //do-while para seguir jugando en tanto el usuario quiera seguir jugando
			
			imprimirMensajes("Bienvenido al Sudoku de PyrenaGames");
			imprimirCaracteresUnicode((char)169);
			
			int nivel = 0;  //variable para almacenar nivel elegido y activar el método cargarJuego()
			
			System.out.printf("Introduzca el nivel de dificultad deseado:\n");
			System.out.println("\n 1. Bajo\n");
			System.out.println("\n 2. Medio\n");
			System.out.println("\n 3. Alto\n");
			
						
			nivel = sc.nextInt();
			
			int[][] sudokuOriginal = cargarJuego(nivel);  //cargamos el mismo juego en dos matrices distintas para guardar
															//la original sin problemas con la dirección de memoria (evitar .clone)
			int[][] sudokuJugar = cargarJuego(nivel);
			
			imprimirSudoku(sudokuJugar);
			
							
			
			
			
				do{   //do-while para solicitar posiciones-valores para un mismo juego cargado hasta el final (cuando no hay '0'´s)
				
					int fila = 0;//crear variables fila y columna antes del do-while donde se usará para determinar
					//la condición que itera el bucle.
					int columna = 0;				
				
					do{ //do-while para solicitar fila y columna y comprobar tanto índices como casilla modificable.
					
					System.out.printf("Introduzca la posición en la que desea introducir el número (fila/columna)\n");
					
					
					
					do{	 //solicita fila y comprueba si dentro rango
						System.out.printf("Fila (1-9):\n");
						
						fila = sc.nextInt();
						
						if (!comprobarPosicion(fila)){
							imprimirMensajes("La fila no es válida. Recuerde (1-9)");
						}
						
					} while (!comprobarPosicion(fila));
					
					
									
					do{ //solicita columna y comprueba si dentro rango
						System.out.printf("Columna (1-9):\n");
						
						columna = sc.nextInt();
						
						if (!comprobarPosicion(columna)){
							imprimirMensajes("La columna no es válida. Recuerde (1-9)");
						}
				
					} while (!comprobarPosicion(columna));
					
			
					if (!esModificable(fila, columna, sudokuOriginal)){
						
						imprimirMensajes("La posición solicitada no es modificable.");
					}
				
				} while (!esModificable(fila,columna,sudokuOriginal));
				
			
					int valor = 0; //variable que almacena los números para jugar al sudoku
					
				//* do{ //do-while para pedir valores en tanto el valor elegido por el usuario ya existe en fila, o en columna o en sector
					
					do{ //do-while para comprobar que el valor esté dentro del rango
						
						System.out.printf("Introduzca el número para el sudoku (0-9): \n");
						System.out.println("NOTA: Utilice '0' para borrar una posición modificable.");
						
						valor = sc.nextInt();
						
						if(!comprobarValor(valor)){
							imprimirMensajes("El valor no es válido. Recuerde (0-9)");
						}
						
					} while(!comprobarValor(valor));
					
					//Bloque de comprobación de la existencia del valor en fila, columna y/o sector
					
					if (valor != 0){
						
						if (existeEnFila(fila, valor, sudokuJugar)){
							
							System.out.println("El número ya existe en la fila..." + fila);
							System.out.printf("\n");
							
						} else if (existeEnColumna(columna, valor, sudokuJugar)){
						
							System.out.println("El número ya existe en la columna..." + columna);
							System.out.printf("\n");
						
							} else if (existeEnSector(fila, columna, valor, sudokuJugar)){
						
								System.out.println("El número ya existe en el sector...");
								System.out.printf("\n");
							
								}else {
							
									insertarValor(fila, columna, valor, sudokuJugar);
									System.out.println("Fila: " + fila + " Columna: " + columna + " Número: " + valor + " ¡CORRECTO!");
									System.out.printf("\n");
									imprimirSudoku(sudokuJugar);
							
								}
						
						
					} else { //cuando el valor introducido es '0' el usuario quiere corregir una posición 
						//introducida anteriormente, y no debe comprobarse si existe el valor, daría error. 
						
						insertarValor(fila, columna, valor, sudokuJugar);
						System.out.println("Fila: " + fila + " Columna: " + columna + " Número: " + valor + " ¡BORRADO!");
						System.out.printf("\n");
						imprimirSudoku(sudokuJugar);
					}
						
					
				//* }while(existeEnFila(fila,valor,sudokuJugar) || existeEnColumna(columna,valor,sudokuJugar) || existeEnSector(fila,columna,valor,sudokuJugar)); *//
					
					
					
						
						
							
			}while (!comprobarFinJuego(sudokuJugar));  
			
				sc.nextLine();
				
				String respuesta = " ";
			
						
				do{
					imprimirMensajes("¡ENHORABUENA! Ha completado el sudoku.");
					System.out.println("Recuerde que está en el nivel: \n" + nivel);
					System.out.println("¿Quiere Jugar otra partida? (s/n)");
					
					respuesta = sc.nextLine();
					
					
				
				}while( (!respuesta.equalsIgnoreCase("s")) && (!respuesta.equalsIgnoreCase("n")) );
			
				
				if (respuesta.equalsIgnoreCase("s")){
					seguir = true;
				
				} else if (respuesta.equalsIgnoreCase("n")){
					seguir = false;
				}
			
			
				
			
		} while (seguir);  
		
		imprimirMensajes("Gracias por elegir Sudoku. ¡Esperamos que vuelva a jugar pronto!");
		
		
		
		
		
	}
	
	

	//MÉTODOS para SUDOKU:
	
	public static int[][] cargarJuego(int nivel){
		
				
		switch (nivel)
		
		{
		case 1:
			{
			int[][] sudoku1={
					
							{5,3,4, 6,7,8, 9,1,2},
							{6,7,2, 1,0,5, 3,4,8},
							{1,9,8, 3,4,2, 5,6,7},
							
							{8,5,9, 7,6,1, 4,2,3},
							{4,2,6, 8,5,3, 7,9,1},
							{7,1,3, 9,2,4, 8,5,6},
							
							{9,6,1, 5,3,7, 2,8,4},
							{2,8,7, 4,1,9, 6,3,5},
							{3,4,5, 2,8,6, 1,7,0}
					
							};
			return sudoku1;
			/*break;*/ //Al hacer return no es necesario añadir la sentencia break en cada caso.
			}
			
		case 2:
			{
			int[][] sudoku2={
					
							{2,6,1, 8,9,4, 3,7,5},
							{3,4,5, 2,7,1, 6,8,9},
							{0,7,8, 6,5,3, 1,4,2},
							
							{1,5,6, 3,4,2, 7,9,8},
							{8,3,7, 5,6,9, 2,1,0},
							{4,9,2, 1,8,7, 5,3,6},
							
							{5,9,8, 7,1,6, 4,2,3},
							{7,2,4, 9,0,5, 8,6,1},
							{6,1,3, 4,2,8, 9,5,7}
					
							};
			return sudoku2;
			}
		
			
		case 3:
			{
				int[][] sudoku3={
				
							{3,1,9, 0,8,2, 4,7,5},
							{8,5,6, 9,7,4, 2,0,3},
							{0,7,4, 3,1,5, 8,6,9},
						
							{9,3,8, 1,2,0, 6,5,4},
							{1,4,5, 8,9,6, 3,2,7},
							{0,6,2, 5,4,3, 1,0,8},
						
							{6,9,7, 2,0,8, 5,4,1},
							{4,2,0, 7,5,1, 9,8,6},
							{5,8,1, 4,6,9, 7,3,0}
				
							};
				
				return sudoku3;
			}
		
			default:
			
				imprimirMensajes("El número introducido no se corresponde con una opción válida.");
				return null;  //Se añade esta instrucción para cubrir todos los casos
							//que pueda introducir el usuario (caso que no introduzca un nivel)
			
		}
		
		
		
	}
	
	public static void imprimirSudoku(int[][]su){
		
		
		for (int i=0; i<su.length; i++){
			
			System.out.printf("|");
			
			for (int j=0; j<su[i].length; j++){
				
				if (su[i][j] == 0){
					
					System.out.printf("%2s", " ");
				}
				else {
					
					System.out.printf("%2d", su[i][j]);
					
				}
				
				if(j==2 || j==5 || j==8){
					
					System.out.printf(" |");
					
				}
				
			}
			
			System.out.printf("\n");
			
			if(i==2 || i==5){
				
				System.out.printf("--------------------------\n");
			}
			
		}
		System.out.printf("\n");
		
	}
	
	//Método para comprobar los valores que elige el user para fila y columna (Posición)
	
	public static boolean comprobarPosicion(int filaColumna){
		
		boolean okPosicion = false;
		
		if ((1 > filaColumna) || (filaColumna > 9)){
			
			okPosicion = false;
		}
		
		else{
			
			okPosicion = true;
		}
			
		return okPosicion;
	}
	
	//Método para comprobar los valores a introducir en el sudoku
	
	public static boolean comprobarValor(int valor){
		
		boolean esValido = false;
		
		if (0 > valor || valor > 9){
			
			esValido = false;
		}
		else {
			
			esValido = true;
		}
		
		return esValido;
	}
	
	//Método para comprobar si la posición elegida es modificable o no, según la MATRIZ ORIGINAL
	//(si en el original hay un "0" es modificable)
	
	public static boolean esModificable(int fila, int col, int[][]sudOrig){
		
		if(sudOrig[fila-1][col-1] == 0){
			
			return true;
			
		}
		else {
			
			return false;
		}
		
	}
	
	
	//Método para comprobar si el valor a introducir existe en la fila elegida(matriz Jugar)
	
	public static boolean existeEnFila(int fila, int valor, int[][]sudoku){
		
		boolean existeEnFila = true;  //Creo esta variable porque en este método Java da error
									//indicando que hay que añadir sentencia return (no la ha reconocido
									//dentro de if / else. En los anteriores métodos no daba este error.
		
		for (int j=0; j<sudoku[fila-1].length; j++){  
			
			if (valor == sudoku[fila-1][j]){
				
				existeEnFila = true;
				break;
			}
			else {
				
				existeEnFila = false;
			}
		}
		
		return existeEnFila;
		
	}
	
	//Método para comprobar si el valor a introducir existe en la columna elegida (matriz Jugar)
	//El error idem que en anterior.
	
	public static boolean existeEnColumna(int col, int valor, int[][]sudoku){
		
		boolean existeEnColumna = true;
		
		for (int i = 0; i<sudoku.length; i++){
			
			if (valor == sudoku[i][col-1]){
				
				existeEnColumna = true;
				break;
			}
			else {
				
				existeEnColumna = false;
			}
		}
		
		return existeEnColumna;
	}
	
	//Método comprobar si el valor a introducir existe en el sector donde está la posición
	//elegida para introducir el valor.
	
	
	public static boolean existeEnSector(int fila, int col, int valor, int[][]sudoku){  //Versión inmortal
		
		boolean existeEnSector = true;
		
		int filaIni = (fila-1) / 3;  // restamos uno a la fila introducida por el usuario para hacerlo 
									//coincidir con las posiciones reales de la matriz. Dividimos entre 3 para sacar el sector en el que
									//se encuentra el valor que quiere introducir el usuario. Se guardará en filaIni la parte entera 0,1 o 2. (cast implícito)
		
		filaIni = filaIni*3; 	//Multiplicamos por 3 para obtener la fila a la que corresponde la esquina superior izquierda del sector.
								//Será la fila de inicio en el primer for para recorrer el sector (submatriz).
				
		int filaFin = filaIni + 3; //Sumamos 3 para obtener la fila en la que terminará de recorrer la matriz (esquina inferior derecha)
		
		int colIni = (col-1) / 3; // restamos uno a la columna introducida por el usuario para hacerlo 
								//coincidir con las posiciones reales de la matriz. Dividimos entre 3 para sacar el sector en el que
								//se encuentra el valor que quiere introducir el usuario. Se guardará en colIni la parte entera 0, 1 o 2. (cast implícito)
		
		colIni = colIni*3;	//Multiplicamos por 3 para obtener la columna a la que corresponde la esquina superior izquierda del sector.
							//Será la fila de inicio en el primer for para recorrer el sector (submatriz).
		
		int colFin = colIni + 3; //Sumamos 3 para obtener la columna en la que terminará de recorrer la matriz (esquina inferior derecha)
		
		for (int i = filaIni; i<filaFin; i++){
			
			for (int j=colIni; j<colFin; j++){
				
				if (sudoku[i][j] == valor) {  //si alguna posición tiene el mismo número que el que quiere introducir el user
					
					 existeEnSector=true;
					 break;                   //la función devolverá true y se rompe la ejecución con break.
				}
				else{
					
					 existeEnSector=false; //en caso contrario la función devolverá false.
				}
				
			}
			
		}
		
		return existeEnSector;
	}
	
	public static int [][] insertarValor(int fila, int col, int valor, int[][]sudoku){
		
		
		sudoku [fila-1][col-1] = valor;
		
		
		return sudoku;
		
	}
	
	
	public static boolean comprobarFinJuego(int[][]sudoku){
		
		boolean noHayCeros = true;
		
		for(int i=0; i<sudoku.length; i++){
			
			for(int j=0; j<sudoku[i].length; j++){
				
				if (sudoku[i][j]==0){
					
					noHayCeros=false;
					break;
				}
				else {
					
					noHayCeros=true;
					
				}
			}
		}
		
		return noHayCeros;
	}
	
	public static void imprimirMensajes(String mensaje){
		
		for (int i=0; i<mensaje.length()+4; i++){
			System.out.printf("¬");
		}
	
		System.out.printf("\n¬ %s ¬\n", mensaje);
		
		for (int i=0; i<mensaje.length()+4; i++){
			System.out.printf("¬");
		}
		
		System.out.printf("\n");
	}
	
	public static void imprimirCaracteresUnicode (int ascii){
		
		char c = ' ';
		
		c = (char)ascii;
		
		System.out.print(c);
		
		
	}
	
	
	
}
