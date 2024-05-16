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

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.MessageDigest;
/**
 * Clase secundaria de Vistas, usada para registrarse en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class Registro extends JFrame implements ActionListener {
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel de contenido de la ventana
	 * */
	private JPanel contentPane;
	/**
	 * Campo de texto para el nombre del usuario
	 * */
	private JTextField campoNombre;
	/**
	 * Campod e texto para los apellidos del usuario
	 * */
	private JTextField campoApellidos;
	/**
	 * Campo de texto para el correo del usuario
	 * */
	private JTextField campoCorreo;
	/**
	 * Label para el nombre
	 * */
	private JLabel lblNombre;
	/**
	 * Label para los apellidos
	 * */
	private JLabel lblApellidos;
	/**
	 * Label para el correo
	 * */
	private JLabel lblCorreo;
	/**
	 * Label para la contrasña
	 * */
	private JLabel lblPassword;
	/**
	 * Boton para registrarse
	 * */
	private JButton btnRegistrarse;
	/**
	 * Boton para limpiar los campos
	 * */
	private JButton btnLimpiar;
	/**
	 * Mensaje que te recuerda que los campos deben contener todos los datos solicitados
	 * */
	private JLabel lblMensaje;
	/**
	 * Mensaje que te avisa de que algun campo no está completado o no has rellenado el formulario
	 * */
	private JLabel lblMensajeError;
	/**
	 * Campo de contraseña
	 * */
	private JPasswordField campoPassword;


	/**
	 * Create the frame.
	 * Método para crear la ventana de Registro
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACIÓN EN LA VENTANA Y SU VISIBILIDAD
		setTitle("Registro de Usuarios");
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
		JLabel lblTitulo = new JLabel("REGISTRO DE USUARIO");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 516, 36);
		contentPane.add(lblTitulo);
		
		//LABEL DEL NOMBRE
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(116, 58, 152, 26);
		contentPane.add(lblNombre);
		
		//LABEL DE LOS APELLIDOS
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblApellidos.setBounds(116, 123, 152, 26);
		contentPane.add(lblApellidos);
		
		//LABEL DEL CORREO
		lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCorreo.setBounds(116, 191, 152, 26);
		contentPane.add(lblCorreo);
		
		//LABEL DE LA PASSWORD
		lblPassword = new JLabel("Contraseña");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(116, 259, 152, 26);
		contentPane.add(lblPassword);
		
		//CAMPO DE TEXTO PARA EL NOMBRE
		campoNombre = new JTextField();
		campoNombre.setBackground(new Color(173, 216, 230));
		campoNombre.setBorder(null);
		campoNombre.setToolTipText("");
		campoNombre.setForeground(Color.BLACK);
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		campoNombre.setBounds(108, 95, 320, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
		//CAMPO DE TEXTO PARA LOS APELLIDOS
		campoApellidos = new JTextField();
		campoApellidos.setBackground(new Color(173, 216, 230));
		campoApellidos.setBorder(null);
		campoApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		campoApellidos.setForeground(Color.BLACK);
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(108, 160, 320, 20);
		contentPane.add(campoApellidos);
		
		//CAMPO DE TEXTO PARA EL CORREO
		campoCorreo = new JTextField();
		campoCorreo.setBackground(new Color(173, 216, 230));
		campoCorreo.setBorder(null);
		campoCorreo.setForeground(Color.BLACK);
		campoCorreo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		campoCorreo.setColumns(10);
		campoCorreo.setBounds(108, 228, 320, 20);
		contentPane.add(campoCorreo);
		
		//BOTÓN PARA REGISTRARSE
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 128, 192));
		btnRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(126, 366, 107, 36);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		//BOTÓN PARA LIMPIAR LOS CAMPOS DE TEXTO
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(0, 128, 192));
		btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLimpiar.setBounds(310, 366, 107, 36);
		btnLimpiar.addActionListener(this);
		contentPane.add(btnLimpiar);
		
		//LABEL PARA EL MENSAJE INFORMATIVO
		lblMensaje = new JLabel("Comprueba que tus datos son correctos antes de pulsar el botón");
		lblMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 327, 516, 29);
		contentPane.add(lblMensaje);
		
		//LABEL PARA EL MENSAJE DE ERROR
		lblMensajeError = new JLabel("");
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeError.setBounds(100, 44, 392, 26);
		contentPane.add(lblMensajeError);
		
		//CAMPO PARA LA CONTRASEÑA
		campoPassword = new JPasswordField();
		campoPassword.setBackground(new Color(173, 216, 230));
		campoPassword.setBorder(null);
		campoPassword.setBounds(108, 296, 320, 20);
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
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de exito de registro o a una ventana de error
		 * */
		if(btnRegistrarse == e.getSource()) {
			/*
			 * Declaración de variables
			 * */
			String nombre = campoNombre.getText();
			String apellidos = campoApellidos.getText();
			String correo = campoCorreo.getText();
			/*
			 * Convertimos el array de chars que obtenemos del campo de contraseña y l transformamos en String para poderlo guardar y hashear
			 * */
			char[] Arraypassword = campoPassword.getPassword();
			String password = String.valueOf(Arraypassword);
			
			/**
			 * Condicion para el nombre
			 * @param empty comprueba si el campo de texto del nombre está vacío
			 * */
			if(nombre.isEmpty()) {
				lblMensajeError.setText("¡Por favor rellena el formulario!");
			}
			
			/**
			 * Condicion para los apellidos
			 * @param empty comprueba si el campo de texto de los apellidos está vacío
			 * */
			if(apellidos.isEmpty()) {
				lblMensajeError.setText("¡Por favor rellena el formulario!");
			}
			
			/**
			 * Condicion para el correo
			 * @param empty comprueba si el campo de texto del correo está vacío
			 * */
			if(correo.isEmpty()) {
				lblMensajeError.setText("¡Por favor rellena el formulario!");
			}
			
			/**
			 * Condicion para la contraseña
			 * @param empty comprueba si el campo de texto de la contraseña está vacío
			 * */
			if(password.isEmpty()) {
				lblMensajeError.setText("¡Por favor rellena el formulario!");
			}
			
			/**
			 * Condicion para todos los campos
			 * @param empty comprueba si los campos de texto están vacíos
			 * */
			if(nombre.isEmpty() && apellidos.isEmpty() && correo.isEmpty() && (password.isEmpty())) {
				lblMensajeError.setText("¡Por favor rellena el formulario!");
			}else {
				//VARIABLES
				final String INFO = "INFO";
				final String ERROR = "ERROR";
				String mensajeRegOk = "Se ha registrado un usuario con el correo " + campoCorreo.getText(); 
				String mensajeRegError = "Error en el registro con el correo " + campoCorreo.getText();
				
				//CREAMOS EL TRY CATCH
				try {
					
					/*
					 * Hasheamos la contraseña para poderla guardar en la base de datos de manera encriptada y proteger al usuario
					 * */
					MessageDigest digest = MessageDigest.getInstance("SHA-256");
					byte[] hash = digest.digest(password.getBytes());
					
					StringBuilder hexString = new StringBuilder();
					for(int i = 0; i<hash.length;i++) {
						String hex = Integer.toHexString(0xff & hash[i]);
						if(hex.length() == 1) hexString.append('0');
						hexString.append(hex);
					}
					
					String hashedPassword = hexString.toString();
					
					//Instancia del objeto persona para el registro con la contraseña hasheada
					Persona persona = new Persona(nombre, apellidos, correo, hashedPassword);
					
					
					//COMPLETAR REGISTRO
					/**
					 * Condición para comprobar si el usuario ya existe en la base de datos
					 * @param registrarUsuario Método para comprobar si el usuario ya existe
					 * @param persona Si los datos de la persona introducida no exiten crea un nuevo usuario
					 * */
					if(ConexionBBDD.registrarUsuario(persona) == false) {
						
						//INSERT DEL NUEVO USUARIO
						/**
						 * Llamada al metodo para insertar un usuario nuevo en la base de datos
						 * @param perosna Introduce los datos del usuario en la tabla usuarios
						 * */
						ConexionBBDD.insertarUsuarios(persona);
						RegistradoCorrectamente rc = new RegistradoCorrectamente();
						rc.setVisible(true);
						this.setVisible(false);
						
						Componentes.escribirLog(INFO, mensajeRegOk);
					}else {
						/**
						 * Si el registro no ha sido exitoso porque el usuario ya existe, se abrirá la ventana de error
						 * */
						RegistroError re = new RegistroError();
						re.setVisible(true);
						this.setVisible(false);
						
						Componentes.escribirLog(ERROR, mensajeRegError);
					}
				}catch(Exception ex) {
					/**
					 * Si salta cualquier error se abrirá la ventana de error en el registro
					 * */
					RegistroError re = new RegistroError();
					re.setVisible(true);
					this.setVisible(false);
					
					try {
						Componentes.escribirLog(ERROR, mensajeRegError);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
												
			}
			
		/**
		 * Condicion del botón
		 * @param boton Cuando el botón obtenga una accion se limpiarán los campos de texto dejandolos vacíos.
		 * */	
		}else if(btnLimpiar == e.getSource()) {
			campoNombre.setText("");
			campoApellidos.setText("");
			campoCorreo.setText("");
			campoPassword.setText("");
		}
		
	}
}
