package dominio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Agenda {

	public String rutaFichero = "";  //relativa al directorio en el que se encuentra el fichero (carpeta proyecto)
	//private static final String rutaFichero = "C:/fichero.txt";

	//Atributos
	private Vector<Contacto> listaContactos;
	private Vector<Contacto> listaAuxiliar;
	private int nowContact = 0;
	
	private boolean isChanged = false;
	
	

	//Constructor
	public Agenda(){

		listaContactos = new Vector<Contacto>( 10 );
		listaAuxiliar = new Vector<Contacto>(10);
	}
	
	//Propiedades
	
		public Vector<Contacto> getListaContactos() {
			return listaContactos;
		}

		public void setListaContactos(Vector<Contacto> listaContactos) {
			this.listaContactos = listaContactos;
		}
		
		public Vector<Contacto> getListaAuxiliar() {
			return listaAuxiliar;
		}

		public void setListaAuxiliar(Vector<Contacto> listaAuxiliar) {
			this.listaAuxiliar = listaAuxiliar;
		}
		
		public boolean getIsChanged() {
			return isChanged;
		}

		public void setIsChanged(boolean isChanged) {
			this.isChanged = isChanged;
		}
		
		
		public String getRutaFichero() {
			return rutaFichero;
		}
		
		public void setRutaFichero(String rutaFichero) {
			this.rutaFichero = rutaFichero;
		}

		public int getNowContact() {
			return nowContact;
		}

		public void setNowContact(int nowContact) {
			this.nowContact = nowContact;
		}
		
		

	//Métodos
	public void cargarFichero(String rutaFicheroACargar){  //abre un fichero y comprueba que existe
		
		this.rutaFichero = rutaFicheroACargar;
		//ver página 432
		//Si tuviéramos que cargar más ficheros distintos,
		//el objeto f no debería ponerse nunca en el constructor (ser un atributo de clase)
		
		File f = new File(rutaFichero);  //la ruta del fichero es un atributo de clase, 
										//no implica la construccion del fichero, 
										//ofrece los métodos de la clase File
		if(f.exists()){
			this.cargarContactosAgenda();
		}else{
			//System.out.println("La Agenda NO existe!");
		}
		
			
	}

	public void cargarContactosAgenda(){ //LECTURA datos del fichero .txt donde almacenamos los datos de Contactos

		//ver página 437	
		
		
		this.listaContactos.removeAllElements();
		this.listaAuxiliar.removeAllElements();
		
		try {
			
			Scanner scanner = new Scanner(new File(rutaFichero));
			
			while (scanner.hasNextLine()){ 
				
			Contacto cto = new Contacto();
			
			
					
			cto.setNombre(scanner.nextLine());
			cto.setApellidos(scanner.nextLine());
			cto.setEdad((scanner.nextInt())); scanner.nextLine();
			cto.setSexo(scanner.nextLine());
			cto.setTelefono(scanner.nextLine());
			cto.setCiudad(scanner.nextLine());
						
			scanner.nextLine();  //Captura la línea en blanco después de cada contacto
			
			//insertar contacto en listacontactos antes de pasar a leer el siguiente contacto
			this.insertarContacto(cto);
						
			}
			
			scanner.close();  
			
			} catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe." + ex);
			}
			
			
	}

	public void guardarFichero(){  //ESCRITURA en fichero de texto

		//ver página 434
			
		try {
			//si se dispone de un fichero de texto y se desea añadir más datos a final
			//PrintWriter pw = new PrintWriter(new FileOutputStream(rutaFichero,true));
			
			PrintWriter pw = new PrintWriter(new File(rutaFichero));
			
			//recorremos cada elemento (contacto) del vector
			
			for (int i = 0; i<listaContactos.size(); i++ ){
				
				Contacto c = listaContactos.elementAt(i);  //Creo objeto de la clase Contacto para almacenar los datos en el fichero
				
				
				//Escribo en el Fichero, para cada elemento (contacto) obtenemos el valor de cada atributo (nombre, apellidos, etc.)
				pw.println(c.getNombre()); 
				pw.println(c.getApellidos());
				pw.println(c.getEdad());
				pw.println(c.getSexo());
				pw.println(c.getTelefono());
				pw.println(c.getCiudad());
				
				pw.println("");
				
			}
				//pw.checkError();  boolean para saber si ha habido algun error o no al escribir
				pw.close();  //cerramos scanner y terminamos de escribir en el archivo lo que esté en memoria
						
			} catch (FileNotFoundException e) {
				
			//System.err.println("Problemas al abrir el fichero"); 
			
			}
		
	}

	public void imprimirAgenda(){
		
		//imprimir el vector de contactos
		
		for(int i=0;i<this.listaContactos.size();i++){
			
			System.out.println(this.listaContactos.elementAt(i).getNombre());
			System.out.println(this.listaContactos.elementAt(i).getApellidos());
			System.out.println(this.listaContactos.elementAt(i).getEdad());
			System.out.println(this.listaContactos.elementAt(i).getSexo());
			System.out.println(this.listaContactos.elementAt(i).getTelefono());
			System.out.println(this.listaContactos.elementAt(i).getCiudad());
			
		}
		
				
	}

	public void buscarNombre(String nombreBuscar){
		
		
		String nombreDelContacto;
		nombreBuscar = nombreBuscar.trim();
		
		//recorremos el vector listacontactos
		
		for(int i = 0; i<this.listaContactos.size(); i++){
			
			nombreDelContacto = this.listaContactos.elementAt(i).getNombre();
			nombreDelContacto = nombreDelContacto.trim();//quitamos los espacios en blanco
			//si el nombre que buscamos coincide con el de uno o varios contactos
			//de la lista, van guardando en una lista auxiliar
			if(nombreBuscar.equalsIgnoreCase(nombreDelContacto)){
				
				this.listaAuxiliar.addElement(this.listaContactos.elementAt(i));
				
			}else{
				//acción a realizar en interfaz ventana auxiliar
			}
		}
		
		
		
	}

	public void insertarContacto( Contacto c ){

		this.listaContactos.addElement(c);
	}
	
	public void actualizarContacto(Contacto c, int index){
		
		this.listaContactos.setElementAt(c, index);
	}

	public void eliminarContacto( int n ){

		this.listaContactos.removeElementAt(n);
		
		
		
		
	}

}