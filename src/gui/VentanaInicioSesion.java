package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Avion;
import domain.Tarjeta;
import domain.Usuario;
import main.Main;

public class VentanaInicioSesion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Elementos
	private JLabel cabecera;
	private JLabel nombreU;
	private JTextField txtNombreU;
	private JLabel contrasena;
	private JTextField txtContrasena;
	private JButton btnRegistro;
	private JButton btnInicioSesion;
	
	
	public VentanaInicioSesion() {
		setTitle("InicioSesion");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos 
		cabecera = new JLabel("Inicio de sesion");
		nombreU = new JLabel("Nombre de usuario: ");
		contrasena = new JLabel("Contraseña: ");
		txtNombreU = new JTextField(15);
		txtContrasena = new JTextField(15);
		btnRegistro = new JButton("Crear cuenta");
		btnInicioSesion = new JButton("Iniciar Sesion");
		
		//Paneles
		setLayout(new BorderLayout());
		//Cabecera
		JPanel pCabecera = new JPanel(new FlowLayout());
		pCabecera.add(cabecera);
		pCabecera.setBackground(Color.lightGray);
		add(pCabecera, BorderLayout.NORTH);
		//Centro
		JPanel pCentral = new JPanel(new GridLayout(2,1));
			JPanel pCentralAlto = new JPanel(new GridLayout(2,1));
				JPanel pNombreU = new JPanel(new FlowLayout());
					pNombreU.add(nombreU);
				JPanel pTxtNombreU = new JPanel(new FlowLayout());
					pTxtNombreU.add(txtNombreU);
			pCentralAlto.add(pNombreU);
			pCentralAlto.add(pTxtNombreU);
			JPanel pCentralBajo = new JPanel(new GridLayout(2,1));
				JPanel PContrasena = new JPanel(new FlowLayout());
					PContrasena.add(contrasena);
				JPanel pTxtContrasena = new JPanel(new FlowLayout());
					pTxtContrasena.add(txtContrasena);
			pCentralBajo.add(PContrasena);
			pCentralBajo.add(pTxtContrasena);
		pCentral.add(pCentralAlto);
		pCentral.add(pCentralBajo);
		add(pCentral, BorderLayout.CENTER);
		//Parte Baja
		JPanel pBotones = new JPanel(new FlowLayout());
		pBotones.add(btnRegistro);
		pBotones.add(btnInicioSesion);
		add(pBotones, BorderLayout.SOUTH);
		
		//ActionListeners
		btnRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new VentanaRegistro();
			}
		});
		btnInicioSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				//TODO
				Usuario user = new Usuario("Manolo", "","",""," ",12,new ArrayList<>());	
				Tarjeta t = new Tarjeta(10, "Enb", user,new Avion(), 101010101);
				user.addTarjeta(t);
				
				new VentanaPrincipal(user, Main.vuelos);
				
			}
		});
		
		pack();
		setVisible(true);
	}
}
