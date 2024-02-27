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
			 	writer.write(trj.getUser().toString() + "\n");
	            writer.write("\t Puerta de Embarque: " +trj.getPuertaEmbarque()+ "\n");
	            writer.write("\t Hora de Salida: " + trj.LongAFechaHora(trj.getHoraSalida())+ "\n");
	            writer.write("\t Asiento: " +trj.getAsiento()+ "\n");
	            writer.write("\t Compania: " +trj.getAvion().getCompania()+ "\n");
	            writer.write("\t Duracion de Viaje: " +trj.getAvion().getDuracionViaje()+ " horas \n");
	            writer.write("\t Origen : " +trj.getAvion().getPaisDest()+ "\n");
	            writer.write("\t Destino: " +trj.getAvion().getPaisDest()+ "\n");
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
	
	
	
	
}
