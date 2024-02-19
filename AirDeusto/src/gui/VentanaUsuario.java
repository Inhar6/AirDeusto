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
	private JLabel cabecera;
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
	
	//Botones
	private JButton btnGuardarDatos;
	private JButton btnInfo;
	private JButton btnEditar;
	
	
	public VentanaUsuario(Usuario user) {
		setTitle("Usuario");
		setSize(700,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		//Elementos
		//Parte Alta
		cabecera = new JLabel("Perfil de Usuario");
		nombre = new JLabel("Nombre: ");
		apellido = new JLabel("Apellido: ");
		nUsuario = new JLabel("Usuario: ");
		contrasena = new JLabel("Contrasena: ");
		DNI = new JLabel("DNI: ");
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
		//Botones
		btnInfo = new JButton("Mostrar Info");
		btnGuardarDatos = new JButton("Guardar Datos");
		btnEditar = new JButton("Editar Datos");
		
		//Paneles
		JPanel p = new JPanel(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.lightGray);
		p.add(pCabecera, BorderLayout.NORTH);
		JPanel pSur = new JPanel(new GridLayout(1,2));
			JPanel pSurIzq = new JPanel(new FlowLayout());
			pSurIzq.add(btnEditar);
			pSurIzq.add(btnGuardarDatos);
			pSurIzq.setBackground(Color.lightGray);
			JPanel pSurDrch = new JPanel(new FlowLayout());
			pSurDrch.add(btnInfo);
			pSurDrch.setBackground(Color.lightGray);
		pSur.add(pSurIzq);
		pSur.add(pSurDrch);
		pSur.setBackground(Color.lightGray);
		p.add(pSur, BorderLayout.SOUTH);
		JPanel pEste = new JPanel(new FlowLayout());
			pEste.setBackground(Color.lightGray);
		p.add(pEste, BorderLayout.EAST);
		JPanel pOeste = new JPanel(new FlowLayout());
			pOeste.setBackground(Color.lightGray);
		p.add(pOeste, BorderLayout.WEST);
		JPanel PGeneral = new JPanel(new GridLayout(1, 2));
		JPanel PIzq = new JPanel(new GridLayout(3,1));
			JPanel PNombre = new JPanel(new FlowLayout());
				PNombre.add(nombre);
				PNombre.add(txtNombre);
			JPanel PApellido = new JPanel();
				PApellido.add(apellido);
				PApellido.add(txtApellido);
			JPanel PDNI = new JPanel();
				PDNI.add(DNI);
				PDNI.add(txtDNI);
			PIzq.add(PNombre);
			PIzq.add(PApellido);
			PIzq.add(PDNI);
		JPanel PDrch = new JPanel(new GridLayout(2,1));
			JPanel PDrchAlto = new JPanel(new GridLayout(2,1));
				JPanel PNUsuario = new JPanel();
					PNUsuario.add(nUsuario);
					PNUsuario.add(txtnUsuario);
				JPanel PContrasena = new JPanel();
					PContrasena.add(contrasena);
					PContrasena.add(txtContrasena);
			PDrchAlto.add(PNUsuario);
			PDrchAlto.add(PContrasena);	
			JPanel PDrchBajo = new JPanel(new BorderLayout());
				PDrchBajo.add(scroll, BorderLayout.CENTER);
				PDrchBajo.setBorder(tituloCartera);
			PDrch.add(PDrchAlto);
			PDrch.add(PDrchBajo);
		PGeneral.add(PIzq);
		PGeneral.add(PDrch);
		
		p.add(PGeneral, BorderLayout.CENTER);
		add(p);
		
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
