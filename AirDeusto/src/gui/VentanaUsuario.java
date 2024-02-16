package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
	//Parte Alta
	private JLabel nombre;
	private JTextField txtNombre;
	private JLabel apellido;
	private JTextField txtApellido;
	private JLabel nUsuario;
	private JTextField txtnUsuario;
	private JLabel contrasena;
	private JTextField txtContrasena;
	private JLabel DNI;
	private JTextField txtDNI;
	
	//Parte Baja
	private JList<Tarjeta> jLstTarjetas;
	private DefaultListModel<Tarjeta> dlmTarjetas;
	private JScrollPane scroll;
	
	
	public VentanaUsuario(Usuario user) {
		setTitle("Usuario");
		setSize(700,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		//Elementos
		//Parte Alta
		nombre = new JLabel("Nombre");
		apellido = new JLabel("Apellido");
		nUsuario = new JLabel("Nombre de Usuario");
		contrasena = new JLabel("Contrasena");
		DNI = new JLabel("DNI");
		txtNombre = new JTextField(20);
			txtNombre.setText(user.getNombre());
		txtApellido = new JTextField(20);
			txtApellido.setText(user.getApellido());
		txtnUsuario = new JTextField(20);
			txtnUsuario.setText(user.getnUsuario());
		txtContrasena = new JTextField(20);
			txtContrasena.setText(user.getContrasena());
		txtDNI = new JTextField(20);
			txtDNI.setText(user.getDNI());
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtnUsuario.setEnabled(false);
		txtContrasena.setEnabled(false);
		txtDNI.setEnabled(false);
		//Parte Baja
		//Cartera
		Border lineaCartera = BorderFactory.createLineBorder(Color.RED);
		Border tituloCartera = BorderFactory.createTitledBorder(lineaCartera, "Cartera");
		dlmTarjetas = new DefaultListModel<>();
		//dlmTarjetas.addAll(user.getCartera());
		
		jLstTarjetas = new JList<Tarjeta>(dlmTarjetas);
		scroll = new JScrollPane(jLstTarjetas);
		
		//Paneles
		JPanel PGeneral = new JPanel(new GridLayout(2, 1));
		JPanel PAlto = new JPanel(new GridLayout(3,2));
			JPanel PNombre = new JPanel(new FlowLayout());
				PNombre.add(nombre);
				PNombre.add(txtNombre);
			JPanel PApellido = new JPanel();
				PApellido.add(apellido);
				PApellido.add(txtApellido);
			JPanel PDNI = new JPanel();
				PDNI.add(DNI);
				PDNI.add(txtDNI);
			JPanel PNUsuario = new JPanel();
				PNUsuario.add(nUsuario);
				PNUsuario.add(txtnUsuario);
			JPanel PContrasena = new JPanel();
				PContrasena.add(contrasena);
				PContrasena.add(txtContrasena);
		PAlto.add(PNombre);
		PAlto.add(PApellido);
		PAlto.add(PDNI);
		PAlto.add(PNUsuario);
		PAlto.add(PContrasena);
		JPanel PBajo = new JPanel();
			PBajo.add(scroll);
			PBajo.setBorder(tituloCartera);
		PGeneral.add(PAlto);
		PGeneral.add(PBajo);
		
		add(PGeneral);
		
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
