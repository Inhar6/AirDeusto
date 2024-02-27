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
			 	writer.write("El presente informe tiene como objetivo proporcionar un análisis estadístico detallado sobre el rendimiento y las tendencias observadas en el casino NoEscasino "
	            		+ ". Este análisis abordará varios aspectos clave, incluidos ingresos, participación de jugadores, juegos más populares y otros indicadores relevantes que ofrecerán una"
	            		+ " visión comprehensiva del estado actual del casino.\n");
	            writer.write(trj.toString());
	            //Final
	            writer.write("\nEn conclusión, el presente informe destaca la dinámica y el rendimiento sólido observado en NoEscasino durante el período analizado. Los datos detallados revelan "
	            		+ "tendencias significativas en la participación de jugadores, los ingresos generados por diferentes juegos y la eficacia de estrategias de retención de clientes. Estos hallazgos"
	            		+ " proporcionan una base sólida para la toma de decisiones futuras y la implementación de mejoras específicas para maximizar la satisfacción del cliente y la rentabilidad. "
	            		+ "NoEscasino continúa siendo un actor destacado en la industria del entretenimiento y los juegos de azar, y este informe sienta las bases para abordar desafíos y aprovechar oportunidades "
	            		+ "emergentes en el panorama competitivo.");
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
	
	
	
	
}
