package Ficheros.AccesoADatos.Florida;


import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerAñadir;
	private String fichero_lectura, fichero_escritura;

	public Controlador(Modelo modelo, Vista vista) {
			this.modelo = modelo;
			this.vista = vista;
			Control();
	}
	
	public void Control() {
		fichero_lectura = modelo.ficheroLectura();
		
			mostrarFichero(fichero_lectura, 1);
//			actionListenerAñadir = new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					String textoAñadir = vista.getTextFieldBuscar().getText();
//					
//					
//				}
//			};
			
}
	private void mostrarFichero(String fichero, int numAreaText) {
		ArrayList<String> arrayLineas = modelo.contenidoFichero(fichero);
		for (String linea : arrayLineas) {
			if(numAreaText == 1) {
				vista.getTextAreaOriginal().append(linea + "\n");
			}else {
				vista.getTextAreaModificado().append(linea + "\n");
			}
		}
	}
}