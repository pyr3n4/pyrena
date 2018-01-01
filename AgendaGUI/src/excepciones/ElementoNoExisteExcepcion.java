package excepciones;

public class ElementoNoExisteExcepcion extends Exception {

	// Atributos
	private String msjError;
	
	// Constructores
	public ElementoNoExisteExcepcion() {
		this("Elemento no encontrado...");
	}
	
	public ElementoNoExisteExcepcion(String msj) {
		this.msjError = msj;
	}
	
	// Métodos
	@Override
	public String toString() {
		return this.msjError;
	}

}