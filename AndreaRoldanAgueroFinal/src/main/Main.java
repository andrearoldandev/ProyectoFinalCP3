package main;

import modelo.Componentes;
import modelo.ConexionBBDD;
import vistas.VentanaBienvenida;
/**
 * Clase Principal del Proyecto (Main)
 * @author Andrea Roldán
 * @version version 1.0
 * */
public class Main {
	
	/**
	 * Parametro de argumentos.
	 * @param args Proporciona los argumentos del Main
	 * */
	public static void main(String[] args) {
		/*
		 * Zona de declaración de variables, en este caso hemos realizado un try catch donde llamamos a los métodos
		 * para conectar con la base de datos y crearla si esta no existe igual que la tabla necesaria.
		 * Puedes encontrar los métodos en el paquete modelo y la clase ConexionBBDD.
		 * */
		try {
			/*
			 * Llamada al metodo para crear la base de datos
			 * */
			ConexionBBDD.crearBaseDeDatos();
			/*
			 * Llamada al metodo para crear la tabla en la base de datos
			 * */
			ConexionBBDD.crearTablaUsuarios();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/*
		 * Creación de la ventana de inicio de la aplicación
		 * */
		try {
			VentanaBienvenida frame = new VentanaBienvenida();
			/**
			 * Visibilidad del frame
			 * @param true Hace que la visibilidad sea true y que la ventana se muestre
			 * */
			frame.setVisible(true);
//			Componentes.crearLog();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
