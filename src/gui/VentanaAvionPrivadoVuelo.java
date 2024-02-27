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
import main.Main;

public class VentanaAvionPrivadoVuelo extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Elementos
	private JLabel cabecera;
	private JLabel usuario;
	private JLabel horaSalida;
	private JTextField txtHoraSalida;
	private JComboBox<String> txtComboUsuario;

	//Botones
	private JButton btnAnyadir;
	
	public VentanaAvionPrivadoVuelo(AvionPrivado avionPrivado, Usuario user) {
		setTitle("Datos del nuevo Avion");
		setSize(450,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera= new JLabel("Avion Privado");
		horaSalida= new JLabel("Hora de Salida: ");
		usuario= new JLabel("Usuario: ");
		txtHoraSalida= new JTextField(20);
		txtComboUsuario=new JComboBox<String>();
		for(String pais : Main.paises) {
			txtComboUsuario.addItem(pais);
		}
		
		//Botones
		btnAnyadir = new JButton("Reservar Vuelo");
		
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
			pTamanyo.add(horaSalida);
			pTamanyo.add(txtHoraSalida);
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
				avionPrivado.setHoraSalida(Long.parseLong(txtHoraSalida.getText()));
				avionPrivado.setPaisOrg((String)txtComboUsuario.getSelectedItem());
				//TODO
				/*
				DBManager.anyadirAvionPrivado(avp);
				*/
				
				Main.DBlstAvionesPrivados.add(avionPrivado);
				
				JOptionPane.showMessageDialog(null, "Vuelo Privado "+ avionPrivado + " anyadido");
				dispose();
			}
		});
		
		pack();
		setVisible(true);
	}
	
}
