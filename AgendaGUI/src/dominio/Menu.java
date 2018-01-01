package dominio;
import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.FueraDeRangoExcepcion;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcion    = 0;
		boolean salir = false;

		Agenda a = new Agenda();

		while( true ){
			//cargarContactosAgenda(); //lectura de los datos de listacontactos
			//Bucle para escoger una opción correcta
			while (!salir) {

				try {
					opcion = menu(sc);
					salir  = true;
				}
				catch (InputMismatchException e) {
					System.out.printf("\nError: no ha introducido un número entero\n\n");					
				}
				catch (FueraDeRangoExcepcion e) {
					System.out.printf("\nEscoja otra opción.\n\n", e.mensajeErrorFueraDeRango() );					
				}
				finally {
					sc.nextLine();
				}
			}

			//Selección de las funciones de la agenda seǵun la opción seleccionada por user
			switch(opcion) {
			
			case 1:{
					//llamada al método que busca la agenda, la carga en memoria
				
				//TODO Limpiar el vector de contactos antes de cargarAgenda
				a.cargarFichero(a.rutaFichero);
				
				break;
			}
			case 2:{
				//TODO
				a.guardarFichero();//llamada al método que ESCRIBE en el fichero y guarda la agenda
				break;
			}
			case 3:{
				//Solicitamos nombre a buscar en la agenda
				System.out.println("Introduzca el nombre a buscar en la Agenda");
				String nombreBuscar = sc.nextLine();
				a.buscarNombre(nombreBuscar);
				
				break;
			}
			case 4:{
				
				//Opción insertar nuevo contacto: (crear objeto)
				Contacto c = new Contacto();
				
				
				//Solicitar los datos a introducir por teclado
				System.out.println("\n Introduzca el nombre: ");
				String nombre = sc.nextLine();
				System.out.println("\n Introduzca los apellidos: ");
				String apellidos = sc.nextLine();
				System.out.println("\n Introduzca el número de teléfono: ");
				String numTelf = sc.nextLine();
				
				int edad = 0;  //la declaro e inicializo fuera del bloque try-catch
				
				//tratamiento excepción para el caso de introducir valor distinto a int en la edad.
				
				boolean exit = false;
				while (!exit){
					try {
						System.out.println("\n Introduzca la edad: ");
						edad = sc.nextInt();
						}
						catch (InputMismatchException e){
							
							System.out.println("\nNo ha introducido un número entero.");
							System.out.println("\nPor favor introduzca un dato válido.");
						}
						finally{
							sc.nextLine();  //para evitar errores en el cambio de tipo de dato a leer (texto después de cifras)
						}
						
				}
								
				sc.nextLine();
				
				//Almacenar los valores en los atributos del Contacto
				c.setNombre(nombre);
				c.setApellidos(apellidos);
				c.setTelefono(numTelf);
				c.setEdad(edad);
				//insertamos Contacto en la Agenda (ver método)
				a.insertarContacto(c);
				
								
				break;
			}
			case 5:{
				
				System.out.println("Introduzca el nombre del Contacto a eliminar:");
				String nombreBorrar = sc.nextLine();
				a.buscarNombre(nombreBorrar);
				
            //tratamiento excepción para el caso de introducir valor distinto a int en la edad.
				
				boolean exit = false;
				while (!exit){
					try {
						System.out.println("Introduzca el número de contacto para eliminarlo:");
						int n = sc.nextInt();
						a.eliminarContacto(n);
						}
						catch (InputMismatchException e){
							
							System.out.println("\nNo ha introducido un número entero.");
							System.out.println("\nPor favor introduzca un dato válido.");
						}
						finally{
							sc.nextLine();  //para evitar errores en el cambio de tipo de dato a leer (texto después de cifras)
						}
				
				}			
				
				break;
			}
			case 6:{
				a.imprimirAgenda();
				break;
			}
			case 0: {
				System.out.printf("\n\nFIN.");
				System.exit( opcion );
			}
			}

			salir = false;
		}
	}

	private static int menu(Scanner teclado) throws FueraDeRangoExcepcion, InputMismatchException {

		System.out.println("Menú de Agenda ");
		System.out.println("--------------------------");
		System.out.println("1.- Cargar Fichero Agenda");
		System.out.println("2.- Guardar Fichero Agenda");		
		System.out.println("3.- Buscar Nombre");
		System.out.println("4.- Insertar Nuevo Contacto");
		System.out.println("5.- Eliminar Contacto");
		System.out.println("6.- Imprimir Agenda");
		System.out.println("");
		System.out.println("0.- Salir");
		System.out.println("");
		System.out.print("Seleccione [0..5]: ");

		int opcion = teclado.nextInt();

		//Si el número introducido está fuera del rango [0..5]
		if ( (opcion < 0) || (opcion > 6) )
			//Se lanza la nueva excepción conteniendo
			throw new FueraDeRangoExcepcion( opcion );

		return opcion;
	}

}