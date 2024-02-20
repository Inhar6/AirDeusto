package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Usuario;
import main.Main;

public class VentanaPresentacion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JButton botonInvitado;
	private JButton botonUsuario;
	//Imagen
	private JLabel logo;
	private JLabel nombre;
	
	public VentanaPresentacion(){
		setTitle("AirDeusto");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		botonInvitado = new JButton("Iniciar como Invitado");
		botonUsuario = new JButton("Iniciar como Usuario");
		//Imagen
		logo = new JLabel(new ImageIcon("resources/images/LogoAvion.png"));
		nombre = new JLabel("AirDeusto");
		Font font = nombre.getFont();
		Font f = new Font(font.getName(), Font.PLAIN, 30);
		nombre.setFont(f);
		
		setLayout(new BorderLayout());
		JPanel pBotones = new JPanel(new FlowLayout());
			pBotones.add(botonInvitado);
			pBotones.add(botonUsuario);
		JPanel pLogo = new JPanel(new BorderLayout());
			pLogo.add(logo, BorderLayout.CENTER);
			JPanel pNombre = new JPanel(new FlowLayout());
				pNombre.add(nombre);
				pNombre.setBackground(Color.cyan);
			pLogo.add(pNombre, BorderLayout.SOUTH);
			pLogo.setBackground(Color.cyan);
			
		add(pLogo, BorderLayout.CENTER);
		add(pBotones, BorderLayout.SOUTH);	
			
		//ActionListeners
		botonInvitado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Usuario u = new Usuario();
				new VentanaPrincipal(u ,Main.vuelos);
			}
		});
		
		botonUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicioSesion();
			}
		});
			
			
		setVisible(true);
	}
}
