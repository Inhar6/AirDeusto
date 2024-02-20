package gui;

import javax.swing.JFrame;

import domain.Avion;

public class VentanaReserva extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaReserva(Avion avion) {
		setTitle("Reserva de Ticket");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}
