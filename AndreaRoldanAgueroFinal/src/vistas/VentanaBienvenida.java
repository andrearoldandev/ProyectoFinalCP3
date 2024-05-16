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
 * Clase Principal de Vistas, usada para iniciar sesión o registrarse en la aplicación, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class VentanaBienvenida extends JFrame implements ActionListener {
	/*
	 * Declaración de las variables que necesitamos en la ventana 
	 * */
	private static final long serialVersionUID = 1L;
	/**
	 * Contenido de la ventana
	 * */
	private JPanel contentPane;
	/**
	 * Titulo de la ventana
	 * */
	private JLabel lblTitulo;
	/**
	 * Label que te pregunta si estas registrado
	 * */
	private JLabel lblRegistrado;
	/**
	 * Label con informacion de los botones
	 * */
	private JLabel lblInfoBotones;
	/**
	 * Boton para registrarse
	 * */
	private JButton btnRegistrarse;
	/**
	 * Boton para iniciar sesion
	 * */
	private JButton btnIniciarSesion;

	/**
	 * Create the frame.
	 * Método para crear la ventana
	 */
	public VentanaBienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle("ARADIGITALART");
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
		lblTitulo = new JLabel("BIENVENIDO A ARADIGITALART");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 495, 32);
		contentPane.add(lblTitulo);
		
		//LABEL MENSAJE PARA SABER SI ESTAS REGISTRADO
		lblRegistrado = new JLabel("¿Estás registrado?");
		lblRegistrado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblRegistrado.setBounds(10, 54, 495, 26);
		contentPane.add(lblRegistrado);
		
		//BOTON PARA REGISTRARSE
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(0, 128, 192));
		btnRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(69, 137, 123, 32);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		//BOTON PARA INICIAR SESION
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(new Color(0, 128, 192));
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnIniciarSesion.setBounds(294, 137, 123, 32);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
		
		//LABEL MENSAJE DE INFORMACIÓN DE LOS BOTONES
		lblInfoBotones = new JLabel("Si eres nuevo pulsa Registrarse, si ya estás registrado pulsa Iniciar Sesión");
		lblInfoBotones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblInfoBotones.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoBotones.setBounds(10, 91, 495, 26);
		contentPane.add(lblInfoBotones);
	}

	/**
	 * Metodo para la interactividad de los botones
	 * @param e Incorpora una acción al botón.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Condicion del botón
		 * @param boton Cuando el botón obtenga una accion se accederá a la ventana de registro
		 * */
		if(btnRegistrarse == e.getSource()) {
			//INSTANCIAMOS LA VENTANA DE REGISTRO
			Registro registroVentana = new Registro();
			registroVentana.setVisible(true);
			this.setVisible(false);
		}else if(btnIniciarSesion == e.getSource()) {
			//INSTANCIAMOS LA VENTANA DE INICIO DE SESIÓN
			Entrar entrarVentana = new Entrar();
			entrarVentana.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
