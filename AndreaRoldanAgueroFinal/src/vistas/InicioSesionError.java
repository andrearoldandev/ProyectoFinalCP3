package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;
/**
 * Clase secundaria de Vistas, usada para errores cuando intentas iniciar sesión en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class InicioSesionError extends JFrame implements ActionListener {
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Contenido de la ventana
	 * */
	private JPanel contentPane;
	/**
	 * Label con el titulo de la ventana
	 * */
	private JLabel lblTitulo;
	/**
	 * Label con el mensaje de informacion de registro
	 * */
	private JLabel lblMensajeRegistro;
	/**
	 * Boton para registrarse
	 * */
	private JButton btnRegistrarse;
	/**
	 * Label de informacion para iniciar sesion
	 * */
	private JLabel lblMensajeEntrar;
	/**
	 * Boton para inicair sesion en la aplicación
	 * */
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 * Metodo main para iniciar la ventana
	 * @param args Pasa los argumentos del metodo Main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesionError frame = new InicioSesionError();
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
	public InicioSesionError() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 219);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle("Error en el inicio de sesión");
		setResizable(false);
		setLocationRelativeTo(null);
		
		//LLAMAMOS AL METODO INICIAR COMPONENTES QUE UTILIZA LA VENTANA
		iniciarComponentes();
		
	}
	
	/**
	 * Método iniciarComponenes que permite la creacion de la ventana con sus particularidades y botones
	 * */
	private void iniciarComponentes() {
		//LABEL DEL TITULO
		lblTitulo = new JLabel("ERROR AL INICIAR SESIÓN");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 414, 31);
		contentPane.add(lblTitulo);
		
		//LABEL DE MENSAJE DE REGISTRO
		lblMensajeRegistro = new JLabel("Si no estás registrado, por favor, registrate.");
		lblMensajeRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblMensajeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeRegistro.setBounds(10, 44, 414, 23);
		contentPane.add(lblMensajeRegistro);
		
		//BOTÓN PARA REGISTRARSE
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 128, 192));
		btnRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(152, 78, 130, 26);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		//LABEL DE MENSAJE DE INICIO DE SESIÓN
		lblMensajeEntrar = new JLabel("Usuario no encontrado, ¿Quieres volver a intentarlo?");
		lblMensajeEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblMensajeEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeEntrar.setBounds(10, 115, 414, 23);
		contentPane.add(lblMensajeEntrar);
		
		//BOTÓN PARA INICIAR SESIÓN
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 128, 192));
		btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEntrar.setBounds(168, 146, 97, 23);
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
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de inicio de sesión o a una ventana de registro
		 * */
		if(btnRegistrarse == e.getSource()) {
			//INSTANCIAMOS LA VENTANA DE REGISTRO Y MODIFICAMOS SU VISIBILIDAD
			Registro registroVentana = new Registro();
			registroVentana.setVisible(true);
			this.setVisible(false);
		}else if(btnEntrar == e.getSource()) {
			//INSTANCIAMOS LA VENTANA DE INICIO DE SESIÓN Y MODIFICAMOS SU VISIBILIDAD
			Entrar entrarVentana = new Entrar();
			entrarVentana.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
