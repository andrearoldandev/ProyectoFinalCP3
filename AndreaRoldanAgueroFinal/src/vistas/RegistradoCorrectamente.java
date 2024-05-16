package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
/**
 * Clase secundaria de Vistas, usada para para saber si te has registrado correctamente en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class RegistradoCorrectamente extends JFrame implements ActionListener{
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Contenido de la ventana
	 * */
	private JPanel contentPane;
	/**
	 * Botón para iniciar sesion
	 * */
	private JButton btnIniciarSesion;
	/**
	 * Label de mensaje de registro correcto
	 * */
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 * Metodo main para iniciar la ventana
	 * @param args Pasa los argumentos del metodo Main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistradoCorrectamente frame = new RegistradoCorrectamente();
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
	public RegistradoCorrectamente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 165);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle("Registro exitoso");
		setResizable(false);
		setLocationRelativeTo(null);
		
		//LLAMAMOS AL MÉTODO INICIAR COMPONENTES QUE UTILIZA LA VENTANA
		iniciarComponentes();
		
	}
	
	/**
	 * Método iniciarComponenes que permite la creacion de la ventana con sus particularidades y botones
	 * */
	private void iniciarComponentes() {
		//LABEL DE MENSAJE DE INFORMACIÓN
		lblMensaje = new JLabel("Te has registrado CORRECTAMENTE");
		lblMensaje.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 11, 414, 43);
		contentPane.add(lblMensaje);
		
		//BOTÓN PARA INICIAR SESION CON LOS DATOS DEL NUEVO USUARIO
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(new Color(0, 128, 192));
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnIniciarSesion.setBounds(117, 76, 200, 28);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
	}

	/**
	 * Metodo para la interactividad de los botones
	 * @param e Incorpora una acción al botón.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Condicion del botón
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de inicio de sesión 
		 * */
		if(btnIniciarSesion == e.getSource()) {
			//INSTANCIAMOS LA VENTANA DE INICIO DE SESIÓN Y MODIFICAMOS SU VISIBILIDAD
			Entrar iniciarSesion = new Entrar();
			iniciarSesion.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
