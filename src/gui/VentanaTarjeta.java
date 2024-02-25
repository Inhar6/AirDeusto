package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	private JLabel asiento;
	
	//Imagen
	private JLabel imagen;

	public VentanaTarjeta(Tarjeta trj) {
		setTitle("Tarjeta ->" + trj.getnEmbarque());
		setSize(600,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		nombrePasajero = new JLabel("Pasajero: "+trj.getUser().toString());
		vueloDestino = new JLabel("" + trj.getAvion().getPaisOrg() + " -> " + trj.getAvion().getPaisDest());
		horarioSalida = new JLabel("Hora de Salida: " + trj.LongAFechaHora(trj.getHoraSalida()) );
		puertaEmbarque = new JLabel("Puerta de Embarque: " + trj.getPuertaEmbarque());
		asiento = new JLabel("Asiento: " + trj.getAsiento());
		//Imagen
		ImageIcon icono = new ImageIcon("resources/images/LogoAvion.png");
        Image imagenEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        imagen = new JLabel(iconoEscalado);
		//Borde
		Border bNegro = BorderFactory.createLineBorder(Color.BLACK);
		//Paneles
		JPanel pGeneral = new JPanel(new GridLayout(3,1));
			JPanel pAlto = new JPanel(new GridLayout(1, 2));
			//Imagen
			pAlto.add(imagen);
				JPanel pUsuario = new JPanel(new FlowLayout());
					pUsuario.add(nombrePasajero);
			pAlto.add(pUsuario);
			pUsuario.setBackground(Color.LIGHT_GRAY);
		pGeneral.add(pAlto);
			JPanel pMedio = new JPanel(new FlowLayout());
				pMedio.add(vueloDestino);
				pMedio.setBackground(Color.orange);
		pGeneral.add(pMedio);
			JPanel pBajo = new JPanel(new GridLayout(1,3));
				JPanel pHorario = new JPanel(new FlowLayout());
					pHorario.add(horarioSalida);
					
				pBajo.add(pHorario);
				JPanel pEmbarque = new JPanel(new FlowLayout());
					pEmbarque.add(puertaEmbarque);
				pBajo.add(pEmbarque);
				JPanel pAsiento = new JPanel(new FlowLayout());
					pAsiento.add(asiento);
				pBajo.add(pAsiento);
				pBajo.setBorder(bNegro);
		pGeneral.add(pBajo);
		add(pGeneral);
		
		setVisible(true);
	}
	
	

}
