package Ficheros.AccesoADatos.Florida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Ejercicio2_1 {

	public static void Ejercicio01(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Escribe un programa que reciba como parámetro de entrada la ruta de un fichero, lea su\r\n"
				+ "contenido y lo muestre por pantalla carácter a carácter.");
		try {
			FileReader fr = new FileReader(args[0]);

			int valor = fr.read();
			while (valor != -1) {
				System.out.print((char)valor);
				valor = fr.read();
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Ejercicio02(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Introduce una modificación en el programa anterior para que admita otro parámetro de\r\n"
				+ "entrada adicional que permita especificar la velocidad a la que se muestren los caracteres.");

		try {
			FileReader fr = new FileReader(args[0]);
			int velocidad = Integer.parseInt(args[1]);
			System.out.println("Velocidad a la que se muestra el texto: " + velocidad + "ms");
			System.out.println();
			int valor = fr.read();
			while (valor != -1) {
				System.out.print((char)valor);
				valor = fr.read();
				Thread.sleep(velocidad);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void Ejercicio03(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Realiza otro programa que muestre un número determinado de caracteres por pantalla (por\r\n"
				+ "ejemplo 100), espere a que el usuario presione alguna tecla, muestre otro bloque de\r\n"
				+ "caracteres, vuelva a esperar, y así sucesivamente hasta mostrar todo el contenido.\r\n");
		Scanner scanner = new Scanner(System.in);
		
		try {
			FileReader fr = new FileReader(args[0]);
			int velocidad = Integer.parseInt(args[1]);
			System.out.println("Velocidad a la que se muestra el texto: " + velocidad + "ms");
						
			int valor;	//Si se le da el valor aqui siempre leeria lo mismo.
			int contador = 0;
			
			while ((valor = fr.read()) != -1) {	//A "valor" se le da el valor aqui para que vaya leyendo linea a linea.
				System.out.print((char)valor);
				contador++;
				
				if(contador == 100) {
					// System.out.print("Pulsa ENTER para continuar...");
					scanner.nextLine();
				contador = 0;
				Thread.sleep(velocidad);
				}	
			}
			scanner.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Ejercicio04(String[] args) throws IOException, FileNotFoundException  {
		System.out.println("Crea un programa que, dado un fichero de texto, lea y muestre su contenido línea a línea. ");
		
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);

		
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea=br.readLine();
		}
		br.close();
	}
	
	public static void Ejercicio05(String[] args) throws IOException, FileNotFoundException, InterruptedException {
		System.out.println("Modifica el programa anterior para que acepte como parámetros de entrada un número\r\n"
		+ "que indique la velocidad a la que se muestran las líneas.");
		
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);
		int velocidad = Integer.parseInt(args[1]);
		System.out.println("Velocidad a la que se muestra el texto línea a línea: " + velocidad + "ms \n");
		
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			Thread.sleep(velocidad);
			linea=br.readLine();
		}
		br.close();
	}
	
	public static void Ejercicio06(String[] args) throws IOException, FileNotFoundException, InterruptedException {
		 System.out.println("Crea otro programa a partir del anterior que en vez de mostrar el contenido por consola lo\r\n"
		 		+ "		 escriba en otro fichero del mismo directorio.");
		 	
		 	String nombreFichero = args[0];
		 	int posicionPunto = nombreFichero.indexOf(".");
		 	String nombreFicheroSinExt = nombreFichero.substring(0, posicionPunto);
			String extension = nombreFichero.substring(posicionPunto);
			String nombreFicheroCopia = nombreFicheroSinExt + "_copia_" + extension;
		 	
			File copiaFichero = new File(nombreFicheroCopia);
			copiaFichero.createNewFile();
			
		 	FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(copiaFichero);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int velocidad = Integer.parseInt(args[1]);
			System.out.println("Velocidad a la que se muestra el texto línea a línea: " + velocidad + "ms \n");
			
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				Thread.sleep(velocidad);
				bw.write(linea);
				bw.newLine(); //Agrega un salto de línea.
				linea=br.readLine();
			}
			System.out.println("\n ----La copia ha terminado----");
			bw.close();
			br.close();
		}
	
	public static void Ejercicio07(String[] args) throws IOException {
		System.out.println("Realiza un programa que permita recibir por teclado una serie de strings por parte del\r\n"
				+ "usuario y los vaya escribiendo en un fichero de texto. Como condición de finalización, el\r\n"
				+ "usuario deberá escribir un string que sea “exit”.");
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Introduce el nombre que tendrá el nuevo fichero(.txt).");
		String nameFichero = scanner.next() + ".txt";	//El archivo creado será un txt.

		File ficheroNuevo = new File(nameFichero);
		
		if(!ficheroNuevo.exists()) {
			try {
				ficheroNuevo.createNewFile();
				System.out.println("Fichero " + ficheroNuevo + " creado con exito.");
			} catch (IOException e) {
				System.out.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ya existe un fichero con ese nombre.");
		}
		System.out.println("Escribe lo que quieras, para dejar de escribir en el archivo escribe 'salir'.");
		
		
		FileWriter fw = new FileWriter(ficheroNuevo);	
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		String wt;
		while(!(wt = scanner.next()).equalsIgnoreCase("exit")) {	//Se actualiza el valor de wt con el scanner y escribe siempre que sea diferente a salir, ignorando mayus y minus.
			bw.write(wt);
			bw.newLine();
			
		}
		System.out.println("Fichero: " + ficheroNuevo + " creado y escrito con exito.");
		bw.close();
		fw.close();
		scanner.close();
	}
	
	public static void Ejercicio08(String[] args) throws IOException {
		System.out.println("Modifica el programa anterior para que el nombre del fichero incluya la fecha y la hora de\r\n"
				+ "creación.");
		
		Scanner scanner = new Scanner(System.in); 
		DateTimeFormatter dateFormatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");	//Formateo la fecha y la hora por separado, si no se formatea no se puede utilizar en el nombre
	
		DateTimeFormatter dateFormatterTime = DateTimeFormatter.ofPattern("HH-mm-ss");

        // Obtener la fecha y hora actuales
        String localDateString = LocalDate.now().format(dateFormatterDate);
        String localTimeString = LocalTime.now().format(dateFormatterTime);
        String dateTimeString = localDateString + "_" + localTimeString;
        
		//System.out.println(dateTimeString);
		
		System.out.println("Introduce el nombre que tendrá el nuevo fichero(.txt).");
		String nameFichero = scanner.next() + "_" + dateTimeString + ".txt";	//El archivo creado será un txt.
		
		File ficheroNuevo = new File(nameFichero);
		
		if(!ficheroNuevo.exists()) {
			try {
				ficheroNuevo.createNewFile();
				System.out.println("Fichero " + ficheroNuevo + " creado con exito.");
			} catch (IOException e) {
				System.out.println("Error al crear el fichero.");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ya existe un fichero con ese nombre.");
		}
		System.out.println("Escribe lo que quieras, para dejar de escribir en el archivo escribe 'salir'.");
		
		
		FileWriter fw = new FileWriter(ficheroNuevo);	
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		String wt;
		while(!(wt = scanner.next()).equalsIgnoreCase("exit")) {	//Se actualiza el valor de wt con el scanner y escribe siempre que sea diferente a salir, ignorando mayus y minus.
			bw.write(wt);
			bw.newLine();
			
		}
		System.out.println("Fichero: " + ficheroNuevo + " creado y escrito con exito.");
		bw.close();
		fw.close();
		scanner.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner pedirNumero = new Scanner(System.in);

		System.out.print("Elige el numero de ejercicio. --> ");
		int numEjercicio = pedirNumero.nextInt();

		switch (numEjercicio) {
		case 1:
			Ejercicio01(args);
			break;
		case 2:
			Ejercicio02(args);
			break;
		case 3:
			Ejercicio03(args);
			break;
		case 4:
			Ejercicio04(args);
			break;
		case 5:
			Ejercicio05(args);
			break;
		case 6:
			Ejercicio06(args);
			break;
		case 7:
			Ejercicio07(args);
			break;
		case 8:
			Ejercicio08(args);
			break;
		default:
			break;
		}
		pedirNumero.close();
	}

}