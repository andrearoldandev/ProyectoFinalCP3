package modelo;
/**
 * Clase Secundaria de Modelo, usada para crear nuestros objetos de Persona.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class Persona {
	/*
	 * Declaración de variables
	 * */
	private String nombre;
	private String apellidos;
	private String correo;
	private String password;
	
	//METODO CONSTRUCTOR
	/**
	 * Constructor con Parámetros completos
	 * @param nombre Nombre del usuario
	 * @param apellidos Apellidos del usuario
	 * @param correo Correo electronico del usuario
	 * @param password Contraseña del usuario
	 * */
	public Persona (String nombre, String apellidos, String correo, String password) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
	}
	
	//METODO CONSTRUCTOR
		/**
		 * Constructor con Parámetros para la comprobación de datos
		 * @param correo Correo del usuario
		 * @param password Contraseña del usuario
		 * */
	public Persona(String correo, String password) {
		this.correo = correo;
		this.password = password;
	}
	
	//METODO CONSTRUCTOR POR DEFECTO
	/**
	 * Metodo constructor por defecto de la clase Persona
	 * */
	public Persona() {
		
	}
	
	//GETTERS Y SETTERS
	/**
	 * Metodo getter del Nombre con una String
	 * @return nombre Devuelve el nombre del usuario como String
	 * */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo getter del Apellido con una String
	 * @return apellidos Devuelve los apellidos del usuario como String
	 * */
	public String getApellido() {
		return this.apellidos;
	}
	
	/**
	 * Metodo getter del Correo con una String
	 * @return correo Devuelve el apellido del usuario como String
	 * */
	public String getCorreo() {
		return this.correo;
	}
	
	/**
	 * Metodo getter de la Contraseña con una String
	 * @return password Devuelve la contraseña del usuario como String
	 * */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Metodo setter del Nombre con una String
	 * @param nombre Le pasamos el nombre del usuario
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo setter del Nombre con una String
	 * @param apellidos Le pasamos los apellidos del usuario
	 * */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Metodo setter del Correo con una String
	 * @param correo Le pasamos el correo del usuario
	 * */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Metodo setter de la contraseña con una String
	 * @param password Le pasamos la contraseña del usuario
	 * */
	public void setPassword(String password) {
		this.password = password;
	}
}
