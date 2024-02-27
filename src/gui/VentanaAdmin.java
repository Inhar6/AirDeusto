package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import db.DBManager;
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
	private JButton btnAnyadirPrivado;
	private JButton btnEliminarPrivado;
	private JButton btnCancelarVuelo;
	private JButton btnAnyadirVuelo;
	private JButton btnInfo;
	
	//Objetos
	private Usuario user;
	private Avion avion;
	private AvionPrivado avionPrivado;
	
	public VentanaAdmin() {
		setTitle("Ventana del administrador");
		setSize(800,900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Objetos
		user = new Usuario();
		avion = new Avion();
		avionPrivado = new AvionPrivado();
		
		//Elementos
		cabecera = new JLabel("Administrador");
		btnEliminar = new JButton("Eliminar Usuario");
		btnAnyadirPrivado = new JButton("Añadir Avion Privado");
		btnEliminarPrivado = new JButton("Eliminar Avion Privado");
		btnCancelarVuelo = new JButton("Cancelar Vuelo");
		btnAnyadirVuelo = new JButton("Añadir Vuelo");
		btnInfo = new JButton("Mas informacion");
		
		btnEliminar.setEnabled(false);
		btnEliminarPrivado.setEnabled(false);
		btnCancelarVuelo.setEnabled(false);
		btnInfo.setEnabled(false);
		//Lista
		//Usuarios
		dlmUsuarios = new DefaultListModel<>();
		dlmUsuarios.addAll(Main.DBlstUsuarios);
		usuarios = new JList<Usuario>(dlmUsuarios);
		usuarios.setCellRenderer(new UsuarioRender());
		scrollUsuarios = new JScrollPane(usuarios);
		//Aviones
		dlmAviones = new DefaultListModel<>();
		dlmAviones.addAll(Main.vuelos);
		aviones = new JList<Avion>(dlmAviones);
		aviones.setCellRenderer(new AvionRender());
		scrollAviones = new JScrollPane(aviones);
		//AvionesComerciales
		dlmAvionesComercial = new DefaultListModel<>();
		//dlmAvionesComercial.addAll(lstAvionesComerciales);
		avionesComerciales = new JList<AvionComercial>(dlmAvionesComercial);
		scrollAvionesComerciales = new JScrollPane(avionesComerciales);
		//AvionesPrivados
		dlmAvionesPrivados = new DefaultListModel<>();
		//dlmAvionesComercial.addAll(lstAvionesComerciales);
		avionesPrivados = new JList<AvionPrivado>(dlmAvionesPrivados);
		avionesPrivados.setCellRenderer(new AvionPrivadoRender());
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
			pBotones.add(btnInfo);
			pUsuarios.add(pBotones, BorderLayout.SOUTH);
			pUsuarios.setBorder(tituloUsuarios);
		JPanel pAvionesComerciales = new JPanel(new BorderLayout());
			pAvionesComerciales.add(scrollAvionesComerciales, BorderLayout.CENTER);
			pAvionesComerciales.setBorder(tituloAvionesComerciales);
		JPanel pAvionesPrivados = new JPanel(new BorderLayout());
			pAvionesPrivados.add(scrollAvionesPrivados, BorderLayout.CENTER);
			JPanel pBtnAvionesPrivados = new JPanel(new FlowLayout());
				pBtnAvionesPrivados.add(btnEliminarPrivado);	
				pBtnAvionesPrivados.add(btnAnyadirPrivado);
			pAvionesPrivados.add(pBtnAvionesPrivados, BorderLayout.SOUTH);
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
		
		//ActionListeners
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option =JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario: "+ user);
				if(option == JOptionPane.YES_OPTION) {
					DBManager.eliminarUsuario(user);
				}
			}
		});
		btnInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaUsuarioAdmin(user);
				
			}
		});
		btnCancelarVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option =JOptionPane.showConfirmDialog(null, "Desea cancelar el vuelo: "+ avion);
				if(option == JOptionPane.YES_OPTION) {
					DBManager.eliminarAvion(avion);
				}
			}
		});
		btnAnyadirVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaAvion();
				
			}
		});
		btnAnyadirPrivado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaAvionPrivado();
				
			}
		});
		btnEliminarPrivado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setVisible(true);
	}
	
	//Rendres
	class UsuarioRender extends JLabel implements ListCellRenderer<Usuario>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends Usuario> list, Usuario value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			setHorizontalAlignment(CENTER);
			setOpaque(true);
			if(index % 2 != 0) {
				setBackground(Color.cyan);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				user = value;
				btnInfo.setEnabled(true);
				btnEliminar.setEnabled(true);
				setBackground(Color.lightGray);
			}
			return this;
		}
		
	}
	
	class AvionRender extends JLabel implements ListCellRenderer<Avion>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends Avion> list, Avion value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			setHorizontalAlignment(CENTER);
			setOpaque(true);
			if(index % 2 != 0) {
				setBackground(Color.cyan);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				avion = value;
				btnCancelarVuelo.setEnabled(true);
				setBackground(Color.lightGray);
			}
			return this;
		}
		
	}
	
	class AvionPrivadoRender extends JLabel implements ListCellRenderer<AvionPrivado>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends AvionPrivado> list, AvionPrivado value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			setHorizontalAlignment(CENTER);
			setOpaque(true);
			if(index % 2 != 0) {
				setBackground(Color.green);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				avionPrivado = value;
				btnEliminarPrivado.setEnabled(true);
				setBackground(Color.lightGray);
			}
			return this;
		}
		
	}

}
