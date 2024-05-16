package modelo;

import java.io.*;
import java.time.*;
import java.time.format.*;
/**
 * Clase secundaria de modelo, usada para escribir en el log.
 * @author Andrea Roldán
 * 
 * @version version 1.0
 * */
public class Componentes {

	
	//MÉTODO PARA ESCRIBIR EN EL LOG
 /**
  * Método para escribir en el log
  * @param level Diferencia entre información y error.
  * @param mensaje Mensaje que describe lo que has realizado en la aplicación
  * @throws IOException Lanza excepciones de input output
  * */
	public static void escribirLog(String level, String mensaje) throws IOException{
		File d = new File("Log");
		File f = new File(d, "registroLog.txt");
		
		d.mkdir();
		
		FileWriter fw = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		//MOMENTO DE REGISTRO
		LocalDateTime momentoActual = LocalDateTime.now();
		DateTimeFormatter patronMomento = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String momentoFormateado = momentoActual.format(patronMomento);
		
		//ESRIBIMOS EL MOMENTO
		bw.write(momentoFormateado + " - " + level + " - " + mensaje);
		bw.newLine();
		
		//CIERRE
		bw.close();
		fw.close();
	}
}
