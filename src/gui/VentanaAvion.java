package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.DBManager;
import domain.Avion;
import main.Main;

public class VentanaAvion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Elementos
	private JLabel cabecera;
	private JLabel compania;
	private JLabel horaSalida;
	private JLabel duracion;
	private JLabel paisDest;
	private JLabel precio;
	private JLabel capacidad;
	private JTextField txtCompania;
	private JTextField txtHoraSalida;
	private JTextField txtDuracion;
	private JComboBox<String> txtComboPaisDest;
	private JTextField txtPrecio;
	private JTextField txtCapacidad;
	
	//Botones
	private JButton btnAnyadir;
	
	public VentanaAvion() {
		setTitle("Datos del nuevo Avion");
		setSize(450,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera= new JLabel("Insercion de datos para nuevo Avion");
		compania= new JLabel("Compania: ");
		horaSalida= new JLabel("Hora de Salida: ");
		duracion= new JLabel("Duracion: ");
		paisDest= new JLabel("Pais Destino: ");
		precio= new JLabel("Precio: ");
		capacidad= new JLabel("Capacidad: ");
		txtCompania= new JTextField(20);
		txtHoraSalida=new JTextField(20);
		txtDuracion=new  JTextField(20);
		txtComboPaisDest=new JComboBox<String>();
		for(String pais : Main.paises) {
			txtComboPaisDest.addItem(pais);
		}
		txtPrecio=new JTextField(20);
		txtCapacidad=new JTextField(20);
		
		//Botones
		btnAnyadir = new JButton("Anyadir Vuelo");
		
		//Paneles
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		JPanel pCentral = new JPanel(new GridLayout(6,1));
			JPanel pCompania = new JPanel(new FlowLayout());
				pCompania.add(compania);
				pCompania.add(txtCompania);
			JPanel pDuracion = new JPanel(new FlowLayout());
				pDuracion.add(duracion);
				pDuracion.add(txtDuracion);
			JPanel pCapacidad = new JPanel(new FlowLayout());
				pCapacidad.add(capacidad);
				pCapacidad.add(txtCapacidad);
			JPanel pPais = new JPanel(new FlowLayout());
				pPais.add(paisDest);
				pPais.add(txtComboPaisDest);
			JPanel pHoraSalida = new JPanel(new FlowLayout());
				pHoraSalida.add(horaSalida);
				pHoraSalida.add(txtHoraSalida);
			JPanel pPrecio = new JPanel(new FlowLayout());
				pPrecio.add(precio);
				pPrecio.add(txtPrecio);
		pCentral.add(pCompania);
		pCentral.add(pCapacidad);
		pCentral.add(pPais);
		pCentral.add(pHoraSalida);
		pCentral.add(pDuracion);
		pCentral.add(pPrecio);
		
		
		JPanel pBtn = new JPanel(new FlowLayout());
			pBtn.add(btnAnyadir);
			pBtn.setBackground(Color.lightGray);
		
		add(pCabecera, BorderLayout.NORTH);
		add(pBtn, BorderLayout.SOUTH);
		add(pCentral, BorderLayout.CENTER);
		
		//ActionListeners
		btnAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Avion av = new Avion(Main.vuelos.size(), "Espanya", (String)txtComboPaisDest.getSelectedItem(), Integer.parseInt(txtCapacidad.getText()), Double.parseDouble(txtDuracion.getText()), Long.parseLong(txtHoraSalida.getText()), new ArrayList<>(), new HashMap<>(),txtCompania.getText(), Integer.parseInt(txtPrecio.getText()));
				DBManager.anyadirAvion(av);
				Main.vuelos.add(av);
				JOptionPane.showMessageDialog(null, "Vuelo "+ av + " anyadido");
				dispose();
				new VentanaAdmin();
			}
		});
		
		pack();
		setVisible(true);
	}
	
}
