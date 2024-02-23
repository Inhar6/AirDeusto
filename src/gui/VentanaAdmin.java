package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Avion;
import domain.AvionComercial;
import domain.AvionPrivado;
import domain.Usuario;
import main.Main;

public class VentanaAdmin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Elementos
	private JLabel cabecera;
	
	//Lista
	//Usuarios
	private DefaultListModel<Usuario> dlmUsuarios;
	private JList<Usuario> usuarios;
	private JScrollPane scrollUsuarios;
	//Aviones
	private DefaultListModel<Avion> dlmAviones;
	private JList<Avion> aviones;
	private JScrollPane scrollAviones;
	//AvionesComerciales
	private DefaultListModel<AvionComercial> dlmAvionesComercial;
	private JList<AvionComercial> avionesComerciales;
	private JScrollPane scrollAvionesComerciales;
	//AvionesPrivados
	private DefaultListModel<AvionPrivado> dlmAvionesPrivados;
	private JList<AvionPrivado> avionesPrivados;
	private JScrollPane scrollAvionesPrivados;
	
	public VentanaAdmin() {
		setTitle("Ventana del administrador");
		setSize(800,900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera = new JLabel("Administrador");
		
		//Lista
		//Usuarios
		dlmUsuarios = new DefaultListModel<>();
		//dlmUsuarios.addAll(lstUsuarios);
		usuarios = new JList<Usuario>(dlmUsuarios);
		scrollUsuarios = new JScrollPane(usuarios);
		//Aviones
		dlmAviones = new DefaultListModel<>();
		dlmAviones.addAll(Main.vuelos);
		aviones = new JList<Avion>(dlmAviones);
		scrollAviones = new JScrollPane(aviones);
		//AvionesComerciales
		dlmAvionesComercial = new DefaultListModel<>();
		//dlmAvionesComercial.addAll(lstAvionesComerciales);
		avionesComerciales = new JList<AvionComercial>(dlmAvionesComercial);
		scrollAvionesComerciales = new JScrollPane(avionesComerciales);
		//AvionesComerciales
		dlmAvionesPrivados = new DefaultListModel<>();
		//dlmAvionesComercial.addAll(lstAvionesComerciales);
		avionesPrivados = new JList<AvionPrivado>(dlmAvionesPrivados);
		scrollAvionesPrivados = new JScrollPane(avionesPrivados);
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel();
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pUsuarios = new JPanel(new BorderLayout());
			pUsuarios.add(scrollUsuarios, BorderLayout.CENTER);
		JPanel pAvionesComerciales = new JPanel(new BorderLayout());
			pAvionesComerciales.add(scrollAvionesComerciales, BorderLayout.CENTER);
		JPanel pAvionesPrivados = new JPanel(new BorderLayout());
			pAvionesPrivados.add(scrollAvionesPrivados, BorderLayout.CENTER);
		JPanel pAviones = new JPanel(new GridLayout(2,1));
		pAviones.add(pAvionesComerciales);
		pAviones.add(pAvionesPrivados);
		JPanel pGeneral = new JPanel(new GridLayout(2,1));
			JPanel pGeneralAlto = new JPanel(new GridLayout(1,2));
				pGeneralAlto.add(pUsuarios);
				pGeneralAlto.add(pAviones);
			pGeneral.add(pGeneralAlto);
			pGeneral.add(scrollAviones);
		add(pGeneral, BorderLayout.CENTER);	
		
		setVisible(true);
	}

}
