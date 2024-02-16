package gui;

import java.util.List;

import javax.swing.JFrame;


import domain.Avion;

public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	public VentanaPrincipal(List<Avion> lstVuelos) {
		setTitle("AirDeusto");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	

}
