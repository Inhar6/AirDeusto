package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Tarjeta;

public class VentanaTarjeta extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JLabel nombrePasajero;
	private JLabel vueloDestino;
	private JLabel horarioSalida;
	private JLabel puertaEmbarque;

	public VentanaTarjeta(Tarjeta trj) {
		setTitle("Tarjeta ->" + trj.getnEmbarque());
		setSize(600,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		nombrePasajero = new JLabel("Pasajero: "+trj.getUser().toString());
		vueloDestino = new JLabel("" + trj.getAvion().getPaisOrg() + " -> " + trj.getAvion().getPaisDest());
		horarioSalida = new JLabel("" + trj.getHoraSalida());
		puertaEmbarque = new JLabel("" + trj.getPuertaEmbarque());
		
		//Paneles
		JPanel pGeneral = new JPanel(new GridLayout(3,1));
			JPanel pAlto = new JPanel(new GridLayout(1, 2));
			//Imagen
			pAlto.add(new JPanel());
				JPanel pUsuario = new JPanel(new FlowLayout());
					pUsuario.add(nombrePasajero);
			pAlto.add(pUsuario);
		pGeneral.add(pAlto);
			JPanel pMedio = new JPanel(new FlowLayout());
				pMedio.add(vueloDestino);
		pGeneral.add(pMedio);
			JPanel pBajo = new JPanel(new GridLayout(1,2));
				pBajo.add(horarioSalida);
				pBajo.add(puertaEmbarque);
		pGeneral.add(pBajo);
		add(pGeneral);
		
		setVisible(true);
	}
	
	

}
