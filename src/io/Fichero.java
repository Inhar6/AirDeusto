package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import domain.Tarjeta;



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
		
	//EScritura de Tarjeta de Embarque
	public static void crearInforme(Tarjeta trj){
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/data/TarjetaDeEmbarque.txt"))) {
	            // Escribe el contenido en el archivo
	            //Inicio
			 	writer.write("El presente informe tiene como objetivo proporcionar un an�lisis estad�stico detallado sobre el rendimiento y las tendencias observadas en el casino NoEscasino "
	            		+ ". Este an�lisis abordar� varios aspectos clave, incluidos ingresos, participaci�n de jugadores, juegos m�s populares y otros indicadores relevantes que ofrecer�n una"
	            		+ " visi�n comprehensiva del estado actual del casino.\n");
	            writer.write(trj.toString());
	            //Final
	            writer.write("\nEn conclusi�n, el presente informe destaca la din�mica y el rendimiento s�lido observado en NoEscasino durante el per�odo analizado. Los datos detallados revelan "
	            		+ "tendencias significativas en la participaci�n de jugadores, los ingresos generados por diferentes juegos y la eficacia de estrategias de retenci�n de clientes. Estos hallazgos"
	            		+ " proporcionan una base s�lida para la toma de decisiones futuras y la implementaci�n de mejoras espec�ficas para maximizar la satisfacci�n del cliente y la rentabilidad. "
	            		+ "NoEscasino contin�a siendo un actor destacado en la industria del entretenimiento y los juegos de azar, y este informe sienta las bases para abordar desaf�os y aprovechar oportunidades "
	            		+ "emergentes en el panorama competitivo.");
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
	
	
	
	
}
