package gui;

import javax.swing.JFrame;

import domain.Tarjeta;

public class VentanaTarjeta extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaTarjeta(Tarjeta trj) {
		setTitle("Tarjeta");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		
		setVisible(true);
	}
	
	

}
