package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

public class VentanaPresentacion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JButton botonInvitado;
	private JButton botonUsuario;
	
	public VentanaPresentacion(){
		setTitle("AirDeusto");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		botonInvitado = new JButton("Iniciar como Invitado");
		botonUsuario = new JButton("Iniciar como Usuario");
		
		setLayout(new BorderLayout());
		JPanel pBotones = new JPanel(new FlowLayout());
			pBotones.add(botonInvitado);
			pBotones.add(botonUsuario);
		
		add(pBotones, BorderLayout.SOUTH);	
			
		//ActionListeners
		botonInvitado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaPrincipal(Main.vuelos);
			}
		});
		
		botonUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaPrincipal(Main.vuelos);
			}
		});
			
			
		setVisible(true);
	}
}
