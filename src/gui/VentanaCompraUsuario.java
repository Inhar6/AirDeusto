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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.DBManager;
import domain.Avion;
import domain.Tarjeta;
import domain.Usuario;
import io.Fichero;

public class VentanaCompraUsuario extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JLabel cabecera;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel DNI;
	private JLabel nombreU;
	private JTextField txtNombre;
	private JTextField txtNombreU;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JLabel lugar;
	private JLabel precio;
	
	//Boton
	private JButton btnCompra;
	
	public VentanaCompraUsuario(Avion avion, Usuario user, int asiento) {
		setTitle("Compra de ticket");
		setSize(450, 200);
		setLocationRelativeTo(null);
		//Elementos
		cabecera = new JLabel("Compra de ticket");
		nombre = new JLabel("Nombre: ");
		nombreU = new JLabel("Nombre de Usuario: ");
		apellido = new JLabel("Apellidos: ");
		DNI = new JLabel("DNI: ");
		txtNombre = new JTextField(20);
		txtNombreU = new JTextField(20);
		txtApellido = new JTextField(20);
		txtDNI = new JTextField(20);
		txtDNI = new JTextField(20);
		//No esta registrado
		if(user.getNombre() != null) {
			txtNombreU.setText(user.getnUsuario());
			txtApellido.setText(user.getApellido());
			txtDNI.setText(user.getDNI());
		}
		lugar = new JLabel("Asiento: " + asiento);
		precio = new JLabel("Precio: " + avion.getPrecio());
		
		//Boton
		btnCompra = new JButton("Comprar Ticket");
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pCentral = new JPanel(new GridLayout(3,1));
			JPanel pUsuario = new JPanel(new FlowLayout());
			//No esta registrado
			if(user.getNombre() == null) {
				pUsuario.add(nombre);
				pUsuario.add(txtNombre);
			}else {
				pUsuario.add(nombreU);
				pUsuario.add(txtNombreU);
			}
			JPanel pApellido = new JPanel(new FlowLayout());
				pApellido.add(apellido);
				pApellido.add(txtApellido);
			JPanel pDNI = new JPanel(new FlowLayout());
				pDNI.add(DNI);
				pDNI.add(txtDNI);
			pCentral.add(pUsuario);
			pCentral.add(pApellido);
			pCentral.add(pDNI);
		add(pCentral, BorderLayout.CENTER);
		JPanel pInfo = new JPanel(new FlowLayout());
			pInfo.add(lugar);
			pInfo.add(precio);
			pInfo.add(btnCompra);
		add(pInfo, BorderLayout.SOUTH);
		
		btnCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Esta registrado
				if(user.getnUsuario() == null) {
					String n =txtNombre.getText();
					String a =txtApellido.getText();
					String c =txtDNI.getText();
					Usuario u = new Usuario(c, n, a);
					long horaSalida = avion.getHoraSalida();
					Tarjeta trj = new Tarjeta(10, "14A", u, avion, horaSalida, asiento);
					Fichero.crearInforme(trj);
					JOptionPane.showMessageDialog(null, "Tarjeta de Embarque Imprimida");
					dispose();
				}else {
					long horaSalida = avion.getHoraSalida();
					Tarjeta trj = new Tarjeta(10, "14A", user, avion, horaSalida, asiento);
					user.addTarjeta(trj);
					DBManager.anyadirTarjeta(trj);
					dispose();
				}
				
			}
		});
		
		setVisible(true);
	}
	public void imprimirRecibo(Tarjeta trj) {
		System.out.println("Recibo");
		//System.out.println(trj);
	}
}
