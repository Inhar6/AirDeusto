package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.AvionPrivado;
import domain.Usuario;
import io.Fichero;
import main.Main;

public class VentanaAvionPrivado extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Elementos
	private JLabel cabecera;
	private JLabel usuario;
	private JLabel tamanyo;
	private JTextField txtTamanyo;
	private JComboBox<Usuario> txtComboUsuario;

	//Botones
	private JButton btnAnyadir;
	
	public VentanaAvionPrivado() {
		setTitle("Datos del nuevo Avion");
		setSize(450,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera= new JLabel("Insercion de datos para nuevo Avion Privado");
		tamanyo= new JLabel("Tamanyo: ");
		usuario= new JLabel("Usuario: ");
		txtTamanyo= new JTextField(20);
		txtComboUsuario=new JComboBox<Usuario>();
		for(Usuario user : Main.DBlstUsuarios) {
			txtComboUsuario.addItem(user);
		}
		
		//Botones
		btnAnyadir = new JButton("Anyadir Vuelo");
		
		//Paneles
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		JPanel pCentral = new JPanel(new GridLayout(2,1));
			JPanel pUsuario = new JPanel(new FlowLayout());
			pUsuario.add(usuario);
			pUsuario.add(txtComboUsuario);
			JPanel pTamanyo = new JPanel(new FlowLayout());
			pTamanyo.add(tamanyo);
			pTamanyo.add(txtTamanyo);
		pCentral.add(pUsuario);
		pCentral.add(pTamanyo);
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
				AvionPrivado avp = new AvionPrivado((Usuario)txtComboUsuario.getSelectedItem(), Float.parseFloat(txtTamanyo.getText()));
				//TODO
				/*
				DBManager.anyadirAvionPrivado(avp);
				*/
				Main.DBlstAvionesPrivados.add(avp);
				Fichero.guardarBinAvionesPrivados(Main.DBlstAvionesPrivados);
				JOptionPane.showMessageDialog(null, "Vuelo Privado "+ avp + " anyadido");
				dispose();
				new VentanaAdmin();
			}
		});
		
		pack();
		setVisible(true);
	}
	
}
