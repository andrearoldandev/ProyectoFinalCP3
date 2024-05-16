package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Clase Principal de Modelo, usada para declarar los métodos usados en nuestra aplicacion.
 * @author Andrea Roldán
 * @version version 1.0
 * */
public class ConexionBBDD {
	
	//CREACION BASE DE DATOS
	/**
	 * Método para crear la base de datos en mysql donde establecemos la conexión con la BBDD
	 * */
	public static void crearBaseDeDatos() {
		/*
		 * Instanciamos tanto la conexion como la sentencia
		 * */
		Connection conexion = null;
		Statement sentencia = null;
		try {
			//CREAMOS LAS VARIABLES PARA LA CONEXION
			/**
			 * Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
			 * */
			String url = "jdbc:mysql://localhost/";
			String user = "root";
			String password = "";
			
			//REALIZAMOS LA CONEXION
			/**
			 * Objeto de conexión 
			 * @param url Le pasamos la url en String.
			 * @param user Le pasamos el usuario en String.
			 * @param password Le pasamo la contraseña de la Base de datos en String.
			 * */
			conexion = DriverManager.getConnection(url, user, password);
			
			//PREPARAMOS LA SENTENCIA SQL
			sentencia = conexion.createStatement();
			
			//EJECUTAMOS LA SENTENCIA PARA CREAR LA BASE DE DATOS SI NO EXISTE
			/*
			 * Usamos una sentencia SQL de creación de bases de datos
			 * */
			String sql = "CREATE DATABASE IF NOT EXISTS usuariosAraDigitalArt";
			
			/**
			 * Sentencia por la cual le pasamos por parametro nuestra sentencia
			 * @param sql
			 * */
			sentencia.executeUpdate(sql);
			
			//CERRAMOS NUESTROS OBJETOS
			sentencia.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//CREACION TABLA
	/**
	 * Método para la creación de la tabla que necesitaremos de usuarios en nuestra BBDD ya creada.
	 * */
	public static void crearTablaUsuarios() {
		/*
		 * Zona de declaración de variables, instanciamos la conexion y la sentencia y las iniciamos en null
		 * */
		Connection conexion = null;
		Statement sentencia = null;
		
		try {
			//CREAMOS LAS VARIABLES PARA LA CONEXION
			/**
			 * Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
			 * Además introducimos el nombre de nuestra base de datos para poder crear ahi nuestra tabla.
			 * */
			String url = "jdbc:mysql://localhost/usuariosAraDigitalArt";
			String user = "root";
			String password = "";
			
			//REALIZAMOS LA CONEXION
			/**
			 * Objeto de conexión 
			 * @param url Le pasamos la url en String.
			 * @param user Le pasamos el usuario en String.
			 * @param password Le pasamo la contraseña de la Base de datos en String.
			 * */
			conexion = DriverManager.getConnection(url, user, password);
			
			//PREPARAMOS LA SENTENCIA SQL
			sentencia = conexion.createStatement();
			
			//EJECUTAMOS LA SENTENCIA PARA CREAR LA TABLA SI NO EXISTE
			/*
			 * Usamos una sentencia SQL de creación de tablas de bases de datos
			 * */
			String sql = """
					CREATE TABLE IF NOT EXISTS Usuarios(
					id INT AUTO_INCREMENT PRIMARY KEY,
					nombre VARCHAR(255) NOT NULL,
					apellidos VARCHAR(255) NOT NULL,
					correo VARCHAR(255) NOT NULL UNIQUE,
					password TEXT NOT NULL)
					""";
			
			//EJECUTAMOS LA SENTENCIA
			/**
			 * Sentencia por la cual le pasamos por parametro nuestra sentencia
			 * @param sql
			 * */
			sentencia.executeUpdate(sql);
			
			//CERRAMOS NUESTROS OBJETOS DE CONEXIÓN Y SENTENCIA
			sentencia.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//INSERTS EN LA TABLA
	/**
	 * Método para la inserción de usuarios en la tabla usuarios de nuestra BBDD ya creada.
	 * @param persona Le pasamos nuestra clase persona por parámetros.
	 * */
	public static void insertarUsuarios(Persona persona) {
		/*
		 * Zona de declaración de variables donde instanciamos la conexion y la sentencia preparada, las iniciamos en null
		 * */
		Connection conexion = null;
		PreparedStatement sentenciaPreparada = null;
		
		try {
		//CREAMOS LAS VARIABLES PARA LA CONEXION
		/**
		* Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
		* Además introducimos el nombre de nuestra base de datos para poder insertar ahi nuestros usuarios.
		* */
		String url = "jdbc:mysql://localhost/usuariosAraDigitalArt";
		String user = "root";
		String passwordBD = "";
		
		//REALIZAMOS LA CONEXION
		/**
		 * Objeto de conexión 
		 * @param url Le pasamos la url en String.
		 * @param user Le pasamos el usuario en String.
		 * @param passwordBD Le pasamo la contraseña de la Base de datos en String.
		 * */
		conexion = DriverManager.getConnection(url, user, passwordBD);
		
		//CREAMOS LA CONSULTA SQL PARA INSERTAR LOS USUARIOS
		/*
		 * Usamos una sentencia SQL de inserción de datos en bases de datos.
		 * */
		String sql = "INSERT INTO Usuarios(nombre, apellidos, correo, password) VALUES(?, ?, ?, ?)";
		
		//Preparamos la sentencia
		/**
		 * Sentencia preparada por la cual le pasamos por parametro nuestra sentencia
		 * @param sql
		 * */
		sentenciaPreparada = conexion.prepareStatement(sql);
		
		/**
		 * Le pasamos los datos necesarios a nuestro insert dependiendo de los que hayamos introducido
		 * @param columna Seleccionamos la columna de donde debe sacar los datos
		 * @param nombre usuario Recuperamos el nombre (String).
		 * */
		sentenciaPreparada.setString(1, persona.getNombre());
		/**
		 * Le pasamos los datos necesarios a nuestro insert dependiendo de los que hayamos introducido
		 * @param columna Seleccionamos la columna de donde debe sacar los datos
		 * @param apellido usuario Recuperamos el apellido (String).
		 * */
		sentenciaPreparada.setString(2, persona.getApellido());
		/**
		 * Le pasamos los datos necesarios a nuestro insert dependiendo de los que hayamos introducido
		 * @param columna Seleccionamos la columna de donde debe sacar los datos
		 * @param correo usuario Recuperamos el correo (String).
		 * */
		sentenciaPreparada.setString(3, persona.getCorreo());
		/**
		 * Le pasamos los datos necesarios a nuestro insert dependiendo de los que hayamos introducido
		 * @param columna Seleccionamos la columna de donde debe sacar los datos
		 * @param password usuario Recuperamos la contraseña (String).
		 * */
		sentenciaPreparada.setString(4, persona.getPassword());
		
		//Ejecutamos la sentencia
		sentenciaPreparada.executeUpdate();
		
		//CERRAMOS
		sentenciaPreparada.close();
		conexion.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//MÉTODO PARA REGISTRARSE
	/**
	 * Método para el registro de usuarios en la tabla usuarios de nuestra BBDD ya creada.
	 * @param persona Le pasamos nuestra clase persona por parámetros.
	 * @return esIgual Devuelve si el correo existe o no
	 * */
	public static boolean registrarUsuario(Persona persona) {
		/*
		 * Zona de declaración de variables donde instanciamos la conexion y la sentencia preparada y las inicializamos en null
		 * Además creamos un booleano para hacer comprobaciones
		 * */
		Connection conexion = null;
		PreparedStatement sentenciaPreparada = null;
		boolean esIgual = false;
		
		try {
			//CREAMOS LAS VARIABLES PARA LA CONEXION
			/**
			* Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
			* Además introducimos el nombre de nuestra base de datos para poder seleccionar de ahi nuestros usuarios.
			* */
			String url = "jdbc:mysql://localhost/usuariosAraDigitalArt";
			String user = "root";
			String passwordBD = "";
			
			//REALIZAMOS LA CONEXION
			/**
			 * Objeto de conexión 
			 * @param url Le pasamos la url en String.
			 * @param user Le pasamos el usuario en String.
			 * @param passwordBD Le pasamo la contraseña de la Base de datos en String.
			 * */
			conexion = DriverManager.getConnection(url, user, passwordBD);
			
			
			/*
			 * Usamos una sentencia SQL Preparada de select donde contaremos las filas donde pueda aparecer el correo introducido
			 * Si hay 0 es que ese correo no está registrado, en cambio si el numero ya no es 0 ese correo ya se habrá registrado.
			 * */
			String sql = "SELECT COUNT(*) FROM Usuarios WHERE correo = ?";
			
			//CREAMOS LA CONSULTA SQL PARA SELECCIONAR AL USUARIO
			/**
			 * Sentencia preparada donde introducimos el correo que ha puesto el usuario que se está registrando
			 * @param columna Seleccionamos la columna de donde vamos hacer la comprobación
			 * @param persona.getCorreo() Introducimos el correo que ha introducido el usuario
			 * */
			sentenciaPreparada = conexion.prepareStatement(sql);
			sentenciaPreparada.setString(1, persona.getCorreo());
			
			//CREAMOS NUESTRO RESULTSET
			ResultSet resul = sentenciaPreparada.executeQuery();
			resul.next();
			int contador = resul.getInt(1);
			
			if(contador > 0) {
				esIgual = true;
			}else {
				esIgual = false;
			}
						
			//CERRAMOS NUESTROS OBJETOS
			resul.close();
			sentenciaPreparada.close();
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return esIgual;
	}
	
	
	//METODO PARA COMPROBAR EL CORREO
	/**
	 * Método para la comprobación del correo en nuestra BBDD ya creada en la cuál comprobaremos si los datos de nuestro usuario existen.
	 * @param usuarioRegistrado Le pasamos nuestra clase persona por parámetros.
	 * @return contraOk Devuelve el resultadod e la comprobación de la contraseña, para saber si coincide con la que esta guardada en la base de datos y asociada a un correo
	 * */
	public static boolean iniciarSesion(Persona usuarioRegistrado) {
		/*
		 * Zona de declaración de variables donde instanciamos la conexion y la sentencia inicializandolas en null
		 * Además creamos 2 booleano iniciados en false
		 * */
		Connection conexion = null;
		PreparedStatement sentenciaPreparada = null;
		boolean esIgual = false;
		boolean contraOk = false;
		
		//CREAMOS UN TRY CATCH
		try {
			//CREAMOS LAS VARIABLES PARA LA CONEXION
			/**
			* Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
			* Además introducimos el nombre de nuestra base de datos para poder seleccionar de ahi nuestros usuarios.
			* */
			String url = "jdbc:mysql://localhost/usuariosAraDigitalArt";
			String user = "root";
			String passwordBD = "";
			
			//REALIZAMOS CONEXION
			/**
			 * Objeto de conexión 
			 * @param url Le pasamos la url en String.
			 * @param user Le pasamos el usuario en String.
			 * @param passwordBD Le pasamos la contraseña de nuestra base de datos en String.
			 * */
			conexion = DriverManager.getConnection(url, user, passwordBD);
			
		
			/*
			 * Usamos una sentencia SQL Preparada de selección de usuarios en la base de datos.
			 * */
			String sql = "SELECT COUNT(*) FROM Usuarios WHERE correo = ?";
			
			//CREAMOS LA CONSULTA SQL PARA SELECCIONAR AL USUARIO
			/**
			 * Sentencia preparada
			 * @param sql Le pasamos la consulta
			 * */
			sentenciaPreparada = conexion.prepareStatement(sql);
			/**
			 * Sentencia preparada introduciendo el correo del usuario
			 * @param 1 Introducimos la columna
			 * @param usuarioRegistrado.getCorreo() Introducimos el correo que nos proporciona el usuario
			 * */
			sentenciaPreparada.setString(1, usuarioRegistrado.getCorreo());
			//CREAMOS NUESTRO RESULTSET Y UN CONTADOR
			ResultSet resul = sentenciaPreparada.executeQuery();
			resul.next();
			int contador = resul.getInt(1);
			
			/*
			 * Iniciamos una condicion para saber si el correo aparece en nuestra base de datos, siendo que si el resultado es 0 no existe en la base de datos
			 * */
			if(contador > 0) {
				esIgual = true;
			}else {
				esIgual = false;
			}
			
			//COMPROBAR LA CONTRASEÑA
			/**
			 * Creamos la condicion y le pasamos el booleano anterior
			 * @param esIgual Si es verdadero comprobamos la contraseña, sinó damos un falso para no iniciar sesión
			 * */
			if(esIgual) {
				//GENERAMOS LA CONSULTA PARA OBTENER LA CONTRASEÑA
				String sql1 = "SELECT password FROM Usuarios WHERE correo = ?";
				/**
				 * Le pasamos la nueva consulta a la sentencia preparada
				 * @param sql1 Introducimos la consulta preparada para obtener las contraseñas mediante el correo
				 * */
				sentenciaPreparada = conexion.prepareStatement(sql1);
				sentenciaPreparada.setString(1, usuarioRegistrado.getCorreo());
				
				//CREAMOS EL RESULTSET
				/**
				 * En este result set lo que hacemos es obtener la password en string para poder hacer la comprobación con la que ha introducido el usuario
				 * */
				ResultSet resul1 = sentenciaPreparada.executeQuery();
				resul1.next();
				String password = resul1.getString(1);
				
				//GENERAMOS LA CONDICION DE IGUALDAD
				/**
				 * Con un if comprobamos la contraseña hasheada
				 * @param password La contraseña que hay en la base de datos segun el correo que le hemos dado
				 * @param usuarioRegistrado password La contraseña que esta introduciendo el usuario
				 * */
				if(password.equals(usuarioRegistrado.getPassword())) {
					contraOk = true;
				}else {
					contraOk = false;
				}
				resul1.close();
			}
			
			
			//CERRAMOS NUESTROS OBJETOS USADOS
			resul.close();
			sentenciaPreparada.close();
			conexion.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * Devolvemos el resultado de nuestro booleano
		 * @return esIgual Devuelve un booleano en falso si no coincide el correo y en true si coincide
		 * */
		return contraOk;
	}
	
	//METODO PARA RECUPERAR EL NOMBRE
	/**
	 * Método para la recuperación del nombre del usuario de nuestra BBDD.
	 * @param correo Le pasamos el correo (String).
	 * @return usuario Devuelve el usuario que ha iniciado sesión para poder personalizar la ultima ventana.
	 * */
	public static Persona devuelveUsuario(String correo) {
		/*
		 * Zona de declaración de variables donde instanciamos una Persona, la conexion y la sentencia preaprada todo inicializado en null
		 * */
		Persona usuario = null;
		Connection conexion = null;
		PreparedStatement sentenciaPreparada = null;
		
		try {
			//CREAMOS LAS VARIABLES PARA LA CONEXION
			/**
			* Zona de declaración de las variables que usaremos para la conexión a nuestra BBDD, en este caso 3 Strings.
			* Además introducimos el nombre de nuestra base de datos para poder seleccionar de ahi nuestros usuarios.
			* */
			String url = "jdbc:mysql://localhost/usuariosAraDigitalArt";
			String user = "root";
			String passwordBD = "";
			
			//REALIZAMOS CONEXION
			/**
			 * Objeto de conexión 
			 * @param url Le pasamos la url en String.
			 * @param user Le pasamos el usuario en String.
			 * @param passwordBD Le pasamos la contraseña de nuestra base de datos en String.
			 * */
			conexion = DriverManager.getConnection(url, user, passwordBD);
			
			//CREAMOS LA CONSULTA SQL PARA SELECCIONAR AL USUARIO
			/*
			 * Usamos una sentencia SQL Preparada de selección de usuarios en la base de datos.
			 * */
			String sql = "SELECT * FROM Usuarios WHERE correo = ? ";
			
			/**
			 * Le pasamos el select 
			 * @param sql.
			 * */
			sentenciaPreparada = conexion.prepareStatement(sql);
			
			/**
			 * Como es una sentencia preparada, le especificamos en parametros los datos que queremos.
			 * @param columna Le especificamos la columna
			 * @param dato Le pedimos el correo
			 * */
			sentenciaPreparada.setString(1, correo);
			
			//GUARDAMOS LOS CORREOS EN UNA LISTA
			/**
			 * Ejecutamos nuestra sentencia y la guardamos en un ResultSet
			 * */
			ResultSet resul = sentenciaPreparada.executeQuery();
			
			//AÑADIMOS LOS RESULTADOS CON UN BUCLE WHILE
			/**
			 * Creamos un while y le pasamos por parámetro nuestro resultset mientras haya datos
			 * @param resul
			 * */
			while(resul.next()) {
				//CREAMOS EL OBJETO USUARIO
				usuario = new Persona();
				/**
				 * Parametros para settear el nombre
				 * @param nombre Le especificamos la columna de donde debe extraer el nombre (String).
				 * */
				usuario.setNombre(resul.getString(2));
				/**
				 * Parametros para settear los apellidos
				 * @param nombre Le especificamos la columna de donde debe extraer los apellidos (String).
				 * */
				usuario.setApellidos(resul.getString(3));
				/**
				 * Parametros para settear el correo
				 * @param nombre Le especificamos la columna de donde debe extraer el correo (String).
				 * */
				usuario.setCorreo(resul.getString(4));
				/**
				 * Parametros para settear la contraseña
				 * @param nombre Le especificamos la columna de donde debe extraer la contraseña (String).
				 * */
				usuario.setPassword(resul.getString(5));
				
			}
			
			//CERRAMOS LOS OBJETOS
			resul.close();
			sentenciaPreparada.close();
			conexion.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * Devolvemos el usuario que hemos pedido
		 * @return usuario devuelve los datos de un usuario
		 * */
		return usuario;
	}
	
}
