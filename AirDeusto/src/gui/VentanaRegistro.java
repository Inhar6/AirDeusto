package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Elementos
	private JLabel cabecera;
	private JLabel DNI;
	private JTextField txtDNI;
	private JLabel nombre;
	private JTextField txtNombre;
	private JLabel apellido;
	private JTextField txtApellido;
	private JLabel nombreU;
	private JTextField txtNombreU;
	private JLabel contrasena;
	private JTextField txtContrasena;
	private JLabel fecha;
	private JTextField txtFecha;
	private JRadioButton PoliticaDePrivacidad;
	private JButton btnPoliticaDePrivacidad;
	private JButton btnCrearCuenta;
	
	public VentanaRegistro() {
		setTitle("Registro");
		setSize(450,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//Elementos
		cabecera = new JLabel("Registro");
		DNI = new JLabel("DNI: ");
		nombre = new JLabel("Nombre: ");
		apellido = new JLabel("Apellidos: ");
		nombreU = new JLabel("Nombre de Usuario: ");
		contrasena = new JLabel("Contraseña: ");
		fecha = new JLabel("Fecha de nacimiento: ");
		txtDNI = new JTextField(20);
		txtNombre = new JTextField(20);
		txtApellido = new JTextField(20);
		txtNombreU = new JTextField(20);
		txtContrasena = new JTextField(20);
		txtFecha = new JTextField(20);
		PoliticaDePrivacidad = new JRadioButton("He leido la politica de privacidad");
			PoliticaDePrivacidad.setEnabled(false);
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnPoliticaDePrivacidad = new JButton("Politica de Privacidad");
		//Paneles
		setLayout(new BorderLayout());
		//Cabecera
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.lightGray);
		add(pCabecera, BorderLayout.NORTH);
		//Centro
		JPanel pCentral = new JPanel(new GridLayout(7,1));
			//Nombre
			JPanel pCentralNombre = new JPanel(new GridLayout(2,1));
				JPanel pNombre = new JPanel(new FlowLayout());
					pNombre.add(nombre);
				JPanel pTxtNombre = new JPanel(new FlowLayout());
					pTxtNombre.add(txtNombre);
			pCentralNombre.add(pNombre);
			pCentralNombre.add(pTxtNombre);
		pCentral.add(pCentralNombre);
			//Apellido
			JPanel pCentralApellido = new JPanel(new GridLayout(2,1));
				JPanel pApellido = new JPanel(new FlowLayout());
					pApellido.add(apellido);
				JPanel pTxtApellido = new JPanel(new FlowLayout());
					pTxtApellido.add(txtApellido);
			pCentralApellido.add(pApellido);
			pCentralApellido.add(pTxtApellido);
		pCentral.add(pCentralApellido);
			//DNI
			JPanel pCentralDNI = new JPanel(new GridLayout(2,1));
				JPanel pDNI = new JPanel(new FlowLayout());
					pDNI.add(DNI);
				JPanel pTxtDNI = new JPanel(new FlowLayout());
					pTxtDNI.add(txtDNI);
			pCentralDNI.add(pDNI);
			pCentralDNI.add(pTxtDNI);
		pCentral.add(pCentralDNI);
			//Fecha
			JPanel pCentralFecha = new JPanel(new GridLayout(2,1));
				JPanel pFecha = new JPanel(new FlowLayout());
					pFecha.add(fecha);
				JPanel pTxtFecha = new JPanel(new FlowLayout());
					pTxtFecha.add(txtFecha);
			pCentralFecha.add(pFecha);
			pCentralFecha.add(pTxtFecha);
		pCentral.add(pCentralFecha);
			//Nombre de Usuario
			JPanel pCentralNombreU = new JPanel(new GridLayout(2,1));
				JPanel pNombreU = new JPanel(new FlowLayout());
					pNombreU.add(nombreU);
				JPanel pTxtNombreU = new JPanel(new FlowLayout());
					pTxtNombreU.add(txtNombreU);
			pCentralNombreU.add(pNombreU);
			pCentralNombreU.add(pTxtNombreU);
		pCentral.add(pCentralNombreU);
			//Contraseña
			JPanel pCentralContrasena = new JPanel(new GridLayout(2,1));
				JPanel pContrasena = new JPanel(new FlowLayout());
					pContrasena.add(contrasena);
				JPanel pTxtContrasena = new JPanel(new FlowLayout());
					pTxtContrasena.add(txtContrasena);
			pCentralContrasena.add(pContrasena);
			pCentralContrasena.add(pTxtContrasena);
		pCentral.add(pCentralContrasena);
			//Politica de Privacidad
			JPanel pCentralPP = new JPanel(new GridLayout(2,1));
				JPanel pPP = new JPanel(new FlowLayout());
					pPP.add(btnPoliticaDePrivacidad);
				JPanel pTxtPP = new JPanel(new FlowLayout());
					pTxtPP.add(PoliticaDePrivacidad);
			pCentralPP.add(pPP);
			pCentralPP.add(pTxtPP);
		pCentral.add(pCentralPP);
		add(pCentral, BorderLayout.CENTER);
		//Bajo
		JPanel pBtn = new JPanel(new FlowLayout());
			pBtn.add(btnCrearCuenta);
		add(pBtn, BorderLayout.SOUTH);
		
		//ActionListeners
		btnPoliticaDePrivacidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Leer la politica de privacidad
				
			}
		});
		btnCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Revisar Y crear la cuenta
				dispose();
				new VentanaInicioSesion();
				
			}
		});
		
		pack();
		setVisible(true);
	}
}
