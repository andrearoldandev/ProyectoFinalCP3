package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Componentes;
import modelo.ConexionBBDD;
import modelo.Persona;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.MessageDigest;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.Rectangle;
/**
 * Clase secundaria de Vistas, usada para iniciar sesión en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class Entrar extends JFrame implements ActionListener {
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel para incluir el contenido
	 * */
	private JPanel contentPane;
	/**
	 * Label con el titulo de la ventana
	 * */
	private JLabel lblTitulo;
	/**
	 * Campo de texto para el correo electrónico
	 * */
	private JTextField campoCorreo;
	/**
	 * Label para dar información del campo de texto, en este caso del correo
	 * */
	private JLabel lblCorreo;
	/**
	 * Label de informacion del campo de la contraseña
	 * */
	private JLabel lblPassword;
	/**
	 * Botón para iniciar sesion
	 * */
	private JButton btnIniciarSesion;
	/**
	 * Campo de contraseña
	 * */
	private JPasswordField campoPassword;

	/**
	 * Launch the application.
	 * Metodo main para iniciar la ventana
	 * @param args Pasa los argumentos del metodo Main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrar frame = new Entrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Método para crear la ventana
	 */
	public Entrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle("Inicio de sesión");
		setResizable(false);
		setLocationRelativeTo(null);
		
		//LLAMAMOS AL METODO INICIAR COMPONENTES QUE UTILIZA LA VENTANA
		iniciarComponentes();
		
	}
	
	/**
	 * Método iniciarComponenes que permite la creacion de la ventana con sus particularidades y botones
	 * */
	private void iniciarComponentes() {
		//TITULO
		lblTitulo = new JLabel("INICIAR SESIÓN");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 499, 27);
		contentPane.add(lblTitulo);
		
		// LABEL PARA EL CORREO
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setBounds(82, 49, 124, 27);
		contentPane.add(lblCorreo);
		
		//LABEL PARA LA CONTRASEÑA
		lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(82, 108, 124, 27);
		contentPane.add(lblPassword);
		
		//CAMPO DE TEXTO PARA INTRODUCIR EL CORREO
		campoCorreo = new JTextField();
		campoCorreo.setBorder(null);
		campoCorreo.setBackground(new Color(173, 216, 230));
		campoCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		campoCorreo.setBounds(74, 77, 371, 20);
		contentPane.add(campoCorreo);
		campoCorreo.setColumns(10);
		
		//BOTON INICIAR SESION
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(new Color(0, 128, 192));
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnIniciarSesion.setBounds(185, 179, 148, 34);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
		
		//CAMPO PARA LA CONTRASEÑA
		campoPassword = new JPasswordField();
		campoPassword.setBackground(new Color(173, 216, 230));
		campoPassword.setBorder(null);
		campoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		campoPassword.setBounds(74, 137, 371, 20);
		contentPane.add(campoPassword);
	}

	/**
	 * Metodo para la interactividad de los botones
	 * @param e Incorpora una acción al botón.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Condicion del botón
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de inicio de sesión o a una ventana de error
		 * */
		if(btnIniciarSesion == e.getSource()) {
			/*
			 * Declaración de variables
			 * */
			String correo = campoCorreo.getText();
			char[] Arraypassword = campoPassword.getPassword();
			String password = String.valueOf(Arraypassword);
			final String INFO = "INFO";
			final String ERROR = "ERROR";
			String mensajeInicioOk = "Se ha iniciado sesión con el correo " + campoCorreo.getText(); 
			String mensajeInicioError = "Error en el inicio de sesión con el correo " + campoCorreo.getText();
			
			//REALIZAMOS EL HASHEO DE LA CONTRASEÑA 
			try {
				/*
				 * Creamos el objeto de MessageDirect que usa un sistema de encriptado y lo convertimos en un array de bytes por el cual pasaremos nuestro array de caracteres que constituyen nuestra contraseña
				 * de ahí lo que haremos es convertirlo a hexadecimal e ir recorriendolo para obtener una contraseña ilegible y guardarla así en la base de datos y tener un mínimo de seguridad para el usuario.
				 * */
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(password.getBytes());
				
				StringBuilder hexString = new StringBuilder();
				for(int i= 0; i < hash.length; i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if(hex.length() == 1) hexString.append('0');
					hexString.append(hex);
				}
				
				String hashedPassword = hexString.toString();
				
				/**
				 * Instancia del objeto persona
				 * @param correo Introducimos el correo del usuario
				 * @param hashedPassword Introducimos la password hasheada del usuario
				 * */
				Persona usuarioRegistrado = new Persona(correo, hashedPassword);
				
				if(ConexionBBDD.iniciarSesion(usuarioRegistrado)) {
					/*
					 * Si el inicio de sesión es correcto, entraremos en la aplicación con nuestro usuario 
					 * */
					VentanaInicio iniciarSesion = new VentanaInicio(ConexionBBDD.devuelveUsuario(correo));
					iniciarSesion.setVisible(true);
					this.setVisible(false);
					
					Componentes.escribirLog(INFO, mensajeInicioOk);
				}else {
					/**
					 * Si el inicio de sesión no ha sido correcto por haber introducido los datos o algun error ocasionado durante el inicio se abrirá una ventana de error
					 * */
					InicioSesionError iniciarSesionError = new InicioSesionError();
					iniciarSesionError.setVisible(true);
					this.setVisible(false);
					
					Componentes.escribirLog(ERROR, mensajeInicioError);
				}
			}catch(Exception ex) {
				/*
				 * Si ocurre cualquier excepcion o error tambien saltará la ventana de error en inicio de sesión
				 * */
				InicioSesionError iniciarSesionError = new InicioSesionError();
				iniciarSesionError.setVisible(true);
				this.setVisible(false);
				
				try {
					Componentes.escribirLog(ERROR, mensajeInicioError);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		}
		
	}

}
