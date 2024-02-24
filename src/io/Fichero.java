package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;



public class Fichero {
	
	//Lectura de ficheros
	public static String leerFichero(String ruta) {
		 StringBuilder texto = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	            	texto.append(linea).append("\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Imposible acceder al fichero seleccionado");
	       }
	        return texto.toString();
	}
	

	
	
	
	
}
