package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Componentes;
import modelo.ConexionBBDD;
import modelo.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 * Clase secundaria de Vistas, usada para iniciar la aplicación con la sesión iniciada del usuario, usa la clase JFrame e implementa un Action Listener.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class VentanaInicio extends JFrame implements ActionListener {

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
	 * Boton que cierra tu inicio de sesion y te devuelve a la ventana principal
	 * */
	private JButton btnCerrarSesion;
	/**
	 * Instancia de Persona, en este caso de usuario registrado
	 * */
	private Persona usuarioRegistrado;
	/**
	 * Label con el nombre del usuario para darle la ienvenida personalizada
	 * */
	private JLabel lblNombreUsuario;
	/**
	 * Boton para enviar el mensaje al artista
	 * */
	private JButton btnEnviar;
	/**
	 * Panel donde el usuario puede escribir el mensaje al artista
	 * */
	private JTextArea mensajeUsuario;
	/**
	 * Label con mensaje de información para el usuario
	 * */
	private JLabel lblMensajeArtista;
	/**
	 * Texto de bienvenida al blog
	 * */
	private JTextPane txtpnTexto;

	

	/**
	 * Create the frame.
	 * Método para crear la ventana
	 * @param usuarioRegistrado Le pasamos el usuario que se esta registrando para guardar los datos que introduzca el usuario.
	 */
	public VentanaInicio(Persona usuarioRegistrado) {
		this.usuarioRegistrado = usuarioRegistrado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//INCORPORAMOS INFORMACION EN LA VENTANA Y SU VISIBILIDAD
		setTitle(this.usuarioRegistrado.getNombre());
		setResizable(false);
		setLocationRelativeTo(null);
		
		//LLAMAMOS AL METODO INICIAR COMPONENTES QUE UTILIZA LA VENTANA
		iniciarComponentes();
		
	}
	
	/**
	 * Método iniciarComponenes que permite la creacion de la ventana con us particularidades y botones
	 * */
	private void iniciarComponentes() {
		//Titulo
		lblTitulo = new JLabel("Bienvenido/a");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setBounds(31, 11, 147, 49);
		contentPane.add(lblTitulo);
		
		//botón para cerrar la sesion
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(0, 128, 192));
		btnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnCerrarSesion.setBounds(755, 11, 147, 34);
		btnCerrarSesion.addActionListener(this);
		contentPane.add(btnCerrarSesion);
		
		//Label para el nombre del usuario
		lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setForeground(new Color(147, 112, 219));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNombreUsuario.setBounds(174, 11, 553, 49);
		lblNombreUsuario.setText(usuarioRegistrado.getNombre());
		contentPane.add(lblNombreUsuario);
		
		//Texto de información de la aplicacion
		txtpnTexto = new JTextPane();
		txtpnTexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtpnTexto.setEditable(false);
		txtpnTexto.setText("¡Bienvenidos a AraDigitalArt!\r\n\r\nEn este espacio encontrarás un sinfín de inspiración y creatividad en forma de arte digital. Desde ilustraciones coloridas y vibrantes hasta diseño gráfico y fotografía digital, aquí podrás sumergirte en un mundo lleno de posibilidades y expresiones artísticas.\r\n\r\nNuestro objetivo es compartir con ustedes el talento de artistas digitales emergentes, así como brindarles recursos, tutoriales y consejos para que puedan explorar y desarrollar su propia creatividad en el mundo del arte digital.\r\n\r\nEn AraDigitalArt creemos en la importancia de la belleza y la innovación en todas sus formas, por lo que te invitamos a unirte a nuestra comunidad y compartir con nosotros tu pasión por el arte digital.\r\n\r\n¡Esperamos que disfruten de su visita y que encuentren en nuestro blog la inspiración que están buscando!\r\n\r\n¡Bienvenidos a AraDigitalArt, el rincón virtual donde el arte se fusiona con la tecnología!");
		txtpnTexto.setBounds(30, 81, 852, 356);
		contentPane.add(txtpnTexto);
		
		//Label con mensaje para el usuario sobre enviar mensajes al usuario
		lblMensajeArtista = new JLabel("Envía un mensaje al Artista:");
		lblMensajeArtista.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMensajeArtista.setBounds(31, 448, 515, 34);
		contentPane.add(lblMensajeArtista);
		
		//Zona de escritura para el usuario
		mensajeUsuario = new JTextArea();
		mensajeUsuario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mensajeUsuario.setBounds(31, 493, 852, 118);
		contentPane.add(mensajeUsuario);
		
		//botón de enviar mensaje
		btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setBackground(new Color(0, 128, 192));
		btnEnviar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEnviar.setBounds(31, 622, 122, 42);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
		
				
	}

	/**
	 * Metodo para la interactividad de los botones
	 * @param e Incorpora una acción al botón.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		//VARIABLES
		final String INFO = "INFO";
		String mensajeCerrarOk = "El usuario " + lblNombreUsuario.getText() + " ha cerrado sesión"; 
		
		/**
		 * Condicion del botón
		 * @param btnCerrarSesion Cuando el botón obtenga una accion se accederá a la ventana Principal
		 * */
		if(btnCerrarSesion == e.getSource()) {
			//Llamada a la ventana Principal
			VentanaBienvenida frame = new VentanaBienvenida();
			frame.setVisible(true);
			this.setVisible(false);
			
			//Creamos el try catch para escribir en el log
			try {
				Componentes.escribirLog(INFO, mensajeCerrarOk);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(btnEnviar == e.getSource()) {
			/**
			 * Creación del directorio y el fichero para guardar los mensajes que envian los usuarios en su perfil
			 * iniciado.
			 * */
			//CREAR DIRECTORIO Y FICHERO
			File d = new File("mensajesUsuarios");
			File f = new File(d, "mensajes.txt");
			
			d.mkdir();
			
			try {
				//CREAR EL FILEWRITER
				/**
				 * Creamos el FileWriter para escribir linea a línea en el fichero
				 * @param f El fichero que hemos creado, mensajes.txt
				 * @param true Esto permite que no se sobrescriba lo que ya han escrito otros usuarios
				 * */
				FileWriter fw = new FileWriter(f, true);
				
				//CREAR EL BUFFEREDWRITER
				/**
				 * Creamos el BufferedWriter 
				 * @param fw Le pasamos el FileWriter
				 * */
				BufferedWriter bw = new BufferedWriter(fw);
				
				//POPULAR EL FICHERO
				bw.write("Mensaje de: " + lblNombreUsuario.getText() + "\n" + mensajeUsuario.getText() + "\n");
				
				//NUEVA LINEA
				bw.newLine();
				
				//CERRAR
				bw.close();
				fw.close();
				
			}catch(Exception ex) {
				ex.getMessage();
			}

			//Cambiamos el mensaje de la caja de comentarios
			mensajeUsuario.setText("Gracias por enviar tu mensaje, serás respondido en la mayor brevedad posible.");
						
		}
		
	}
}
