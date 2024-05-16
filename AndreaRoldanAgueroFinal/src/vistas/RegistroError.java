package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
/**
 * Clase secundaria de Vistas, usada para indicar un error al iniciar sesión en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class RegistroError extends JFrame implements ActionListener {
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Contenido de la ventana
	 * */
	private JPanel contentPane;
	/**
	 * Label con un mensaje de error
	 * */
	private JLabel lblMensaje;
	/**
	 * Boton para iniciar sesion
	 * */
	private JButton btnEntrar;
	/**
	 * Label con información para iniciar sesion
	 * */
	private JLabel lblInfoEntrar;
	/**
	 * Boton de registro
	 * */
	private JButton btnRegistrarse;
	/**
	 * Label con informacion acerca del registro
	 * */
	private JLabel lblInfoRegistro;
	/**
	 * Label con informacion por si ya estas registrado
	 * */
	private JLabel lblInformacion;

	/**
	 * Launch the application.
	 * Metodo main para iniciar la ventana
	 * @param args Pasa los argumentos del metodo Main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroError frame = new RegistroError();
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
	public RegistroError() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 281);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle("Error en el registro");
		setResizable(false);
		setLocationRelativeTo(null);
		
		//LLAMAMOS AL METODO INICIAR COMPONENTES QUE UTILIZA LA VENTANA
		iniciarComponentes();
		
	}
	
	/**
	 * Método iniciarComponenes que permite la creacion de la ventana con sus particularidades y botones
	 * */
	private void iniciarComponentes() {
		//LABEL PARA EL MENSAJE DE ERROR EN EL REGISTRO
		lblMensaje = new JLabel("Error en el registro");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMensaje.setBounds(10, 11, 414, 29);
		contentPane.add(lblMensaje);
		
		//BOTÓN PARA REGISTRARSE DE NUEVO
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 128, 192));
		btnRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(148, 119, 138, 34);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		//LABEL INFORMACIÓN
		lblInformacion = new JLabel("Puede que ya estés registrado");
		lblInformacion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacion.setBounds(10, 51, 414, 23);
		contentPane.add(lblInformacion);
		
		//LABEL DE INFORMACÍON DEL BOTON DE REGISTRO
		lblInfoRegistro = new JLabel("Pulsa en registrarse para intentarlo de nuevo");
		lblInfoRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblInfoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoRegistro.setBounds(10, 85, 414, 21);
		contentPane.add(lblInfoRegistro);
		
		//LABEL DE INFORMACION DEL BOTON DE INICIO DE SESIÓN
		lblInfoEntrar = new JLabel("Pulsa en entrar para iniciar sesión");
		lblInfoEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblInfoEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoEntrar.setBounds(10, 164, 414, 29);
		contentPane.add(lblInfoEntrar);
		
		//BOTON PARA INICIAR SESION
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 128, 192));
		btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEntrar.setBounds(172, 202, 89, 29);
		btnEntrar.addActionListener(this);
		contentPane.add(btnEntrar);
	}

	/**
	 * Metodo para la interactividad de los botones
	 * @param e Incorpora una acción al botón.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Condicion del botón
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de registro o de inicio de sesión.
		 * */
		if(btnRegistrarse == e.getSource()) {
			/*
			 * Instanciamos la ventana de registro y modificamos su visbilidad
			 * */
			Registro registroVentana = new Registro();
			registroVentana.setVisible(true);
			this.setVisible(false);
		}else if(btnEntrar == e.getSource()) {
			/*
			 * Instanciamos la ventana de inicio de sesión y modificamos su visibilidad
			 * */
			Entrar iniciarSesion = new Entrar();
			iniciarSesion.setVisible(true);
			this.setVisible(false);
		}
		
	}

}
