package dominio;

public class Contacto {

	//Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private String sexo;
	private String telefono;
	private String ciudad;

	//Constructores

	public Contacto(){
		
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.sexo = "";
		this.telefono = "";
		this.ciudad = "";
	}

	public Contacto(String name, String surname, int age, String sex, String phoneNumber,String city){
		
		this.nombre = name;
		this.apellidos = surname;
		this.edad = age;
		this.sexo = sex;
		this.telefono = phoneNumber;
		this.ciudad = city;
		
	}

	//Getters and Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	//Métodos


	
}