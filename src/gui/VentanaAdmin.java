package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

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
	//Botones
	private JButton btnEliminar;
	private JButton btnPrivado;
	private JButton btnCancelarVuelo;
	private JButton btnAnyadirVuelo;
	
	public VentanaAdmin() {
		setTitle("Ventana del administrador");
		setSize(800,900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera = new JLabel("Administrador");
		btnEliminar = new JButton("Eliminar Usuario");
		btnPrivado = new JButton("Añadir Avion Privado");
		btnCancelarVuelo = new JButton("Cancelar Vuelo");
		btnAnyadirVuelo = new JButton("Añadir Vuelo");
		
		btnEliminar.setEnabled(false);
		btnPrivado.setEnabled(false);
		btnCancelarVuelo.setEnabled(false);
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
		//Border
		Border lineaAviones = BorderFactory.createLineBorder(Color.BLUE);
		Border tituloAviones = BorderFactory.createTitledBorder(lineaAviones, "Aviones");
		Border lineaUsuarios = BorderFactory.createLineBorder(Color.BLUE);
		Border tituloUsuarios = BorderFactory.createTitledBorder(lineaUsuarios, "Usuarios");
		Border lineaAvionesPrivados = BorderFactory.createLineBorder(Color.DARK_GRAY);
		Border tituloAvionesPrivados = BorderFactory.createTitledBorder(lineaAvionesPrivados, "AvionesPrivados");
		Border lineaAvionesComerciales = BorderFactory.createLineBorder(Color.DARK_GRAY);
		Border tituloAvionesComerciales = BorderFactory.createTitledBorder(lineaAvionesComerciales, "AvionesComerciales");
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel();
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pUsuarios = new JPanel(new BorderLayout());
			pUsuarios.add(scrollUsuarios, BorderLayout.CENTER);
			JPanel pBotones = new JPanel(new FlowLayout());
			pBotones.add(btnEliminar);
			pBotones.add(btnPrivado);
			pUsuarios.add(pBotones, BorderLayout.SOUTH);
			pUsuarios.setBorder(tituloUsuarios);
		JPanel pAvionesComerciales = new JPanel(new BorderLayout());
			pAvionesComerciales.add(scrollAvionesComerciales, BorderLayout.CENTER);
			pAvionesComerciales.setBorder(tituloAvionesComerciales);
		JPanel pAvionesPrivados = new JPanel(new BorderLayout());
			pAvionesPrivados.add(scrollAvionesPrivados, BorderLayout.CENTER);
			pAvionesPrivados.setBorder(tituloAvionesPrivados);
		JPanel pAviones = new JPanel(new GridLayout(2,1));
		pAviones.add(pAvionesComerciales);
		pAviones.add(pAvionesPrivados);
		JPanel pGeneral = new JPanel(new GridLayout(2,1));
			JPanel pGeneralAlto = new JPanel(new GridLayout(1,2));
				pGeneralAlto.add(pUsuarios);
				pGeneralAlto.add(pAviones);
			pGeneral.add(pGeneralAlto);
		JPanel pAvionesGeneral = new JPanel(new BorderLayout());
				pAvionesGeneral.add(scrollAviones, BorderLayout.CENTER);
				JPanel pBtn = new JPanel(new FlowLayout());
					pBtn.add(btnCancelarVuelo);
					pBtn.add(btnAnyadirVuelo);	
				pAvionesGeneral.add(pBtn, BorderLayout.SOUTH);
				pAvionesGeneral.setBorder(tituloAviones);
			pGeneral.add(pAvionesGeneral);
		add(pGeneral, BorderLayout.CENTER);	
		
		setVisible(true);
	}

}
