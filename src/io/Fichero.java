package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.AvionComercial;
import domain.AvionPrivado;
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
		
	//Escritura de Tarjeta de Embarque
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
	/*
	 * AVIONES PRIVADOS
	 */
	//Lectura de Fichero binario que guarda la lista de AvionesPrivados
	public static void guardarBinAvionesPrivados(List<AvionPrivado> lista) {
		try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("resources/data/AvionesPrivados.dat"))){
			oos.writeObject(lista);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<AvionPrivado> leerBinAvionesPrivados() {
		ArrayList<AvionPrivado> lista=new ArrayList<AvionPrivado>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/data/AvionesPrivados.dat"))){
			 lista = (ArrayList<AvionPrivado>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	/*
	 * AVIONES COMERCIALES
	 */
	//Lectura de Fichero binario que guarda la lista de AvionesPrivados
	public static void guardarBinAvionesComerciales(List<AvionComercial> lista) {
		try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("resources/data/AvionesComerciales.dat"))){
			oos.writeObject(lista);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<AvionComercial> leerBinAvionesComerciales() {
		ArrayList<AvionComercial> lista=new ArrayList<AvionComercial>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/data/AvionesComerciales.dat"))){
			 lista = (ArrayList<AvionComercial>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
