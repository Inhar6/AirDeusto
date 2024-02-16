package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import domain.Tarjeta;
import domain.Usuario;

public class VentanaUsuario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JList<Tarjeta> jLstTarjetas;
	private DefaultListModel<Tarjeta> dlmTarjetas;
	private JScrollPane scroll;
	
	public VentanaUsuario(Usuario user) {
		setTitle("Usuario");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		
		
		//Elementos
		//Cartera
		Border lineaCartera = BorderFactory.createLineBorder(Color.RED);
		Border tituloCartera = BorderFactory.createTitledBorder(lineaCartera, "Cartera");
		dlmTarjetas = new DefaultListModel<>();
		//dlmTarjetas.addAll(user.getCartera());
		
		jLstTarjetas = new JList<Tarjeta>(dlmTarjetas);
		scroll = new JScrollPane(jLstTarjetas);
		
		
		JPanel PGeneral = new JPanel(new GridLayout(2, 1));
		JPanel PScroll = new JPanel();
			PScroll.add(scroll);
			PScroll.setBorder(tituloCartera);
		PGeneral.add(new JPanel());
		PGeneral.add(PScroll);
		PGeneral.setBackground(Color.red);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		Usuario u = new Usuario();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaUsuario(u);
			}
		});
		
	}
}
