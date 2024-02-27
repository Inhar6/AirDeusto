package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import db.DBManager;
import domain.Avion;
import domain.AvionPrivado;
import domain.Usuario;
import gui.VentanaPresentacion;

public class Main {
	
	public static List<String> paises = new ArrayList<>();
	public static List<Avion> vuelos = DBManager.obtenerTodosLosAviones();
	public static List<Usuario> DBlstUsuarios = DBManager.obtenerTodosLosUsuarios();
	public static List<AvionPrivado> DBlstAvionesPrivados = new ArrayList<>();
	
	public Main() {

		for(Avion avion :vuelos) {
			paises.add(avion.getPaisDest());
			avion.llenarListasAvion(DBlstUsuarios);
		}
		
		new VentanaPresentacion();
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Main();
				
			}
		});
	}
}
