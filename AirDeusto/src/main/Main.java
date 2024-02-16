package main;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import domain.Avion;
import gui.VentanaPrincipal;

public class Main {
	
	public Main() {
		ArrayList<Avion> lst = new ArrayList<>();
		Avion avion1 = new Avion(1, "EE. UU.", "Francia", 200, 8.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Air France", 1200);
		Avion avion2 = new Avion(2, "España", "Italia", 150, 6.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Iberia", 1000);
		Avion avion3 = new Avion(3, "Alemania", "Japón", 300, 12.0, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Lufthansa", 1500);
		Avion avion4 = new Avion(4, "China", "Estados Unidos", 250, 10.0, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Air China", 1800);
		Avion avion5 = new Avion(5, "Italia", "Argentina", 180, 9.0, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Alitalia", 1100);
		Avion avion6 = new Avion(6, "Francia", "Canadá", 220, 7.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Air Canada", 1300);
		Avion avion7 = new Avion(7, "Japón", "Australia", 280, 11.0, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Qantas", 1600);
		Avion avion8 = new Avion(8, "India", "Rusia", 190, 8.0, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Aeroflot", 1400);
		Avion avion9 = new Avion(9, "Brasil", "Reino Unido", 200, 10.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "British Airways", 1700);
		Avion avion10 = new Avion(10, "México", "Turquía", 170, 9.5, System.currentTimeMillis(), new ArrayList<>(), new HashMap<>(), "Turkish Airlines", 1500);
		lst.add(avion1);
		lst.add(avion2);
		lst.add(avion3);
		lst.add(avion4);
		lst.add(avion5);
		lst.add(avion6);
		lst.add(avion7);
		lst.add(avion8);
		lst.add(avion9);
		lst.add(avion10);
		new VentanaPrincipal(lst);
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
