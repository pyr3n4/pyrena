package excepciones;

public class FueraDeRangoExcepcion extends Exception {

	// Atributos
	private int numero;
	
	// Constructor
	public FueraDeRangoExcepcion(int num) {
		this.numero = num;    	
	}
	
	// Método: Devuelve el error provocado
	public String mensajeErrorOpcion() {
		return "La opción elegida ha sido " + this.numero;
    }
	
	public String mensajeErrorNumMayorQue() {
		return "Introduzca un número mayor que " + this.numero;
    }
	
	public String mensajeErrorFueraDeRango() {
		return "Introduzca un número entre 1 y " + this.numero;
    }
	
	public String mensajeErrorNumTel() {
		return "Introduzca un número entre 600000000 y 699999999";
    }

}