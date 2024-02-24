package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import domain.Usuario;
import io.Fichero;
import main.Main;

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
	private int anyos;
	
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
			String fech = "yyyy-MM-dd";
			txtFecha.setText(fech);
		PoliticaDePrivacidad = new JRadioButton("He leido la politica de privacidad");
			PoliticaDePrivacidad.setEnabled(false);
		btnCrearCuenta = new JButton("Crear Cuenta");
			btnCrearCuenta.setEnabled(false);
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
		
		//Fecha
		//Para mostrar al usuaro la manera de introducir los datos
		txtFecha.addFocusListener(new FocusListener() {
					
				@Override
				public void focusGained(FocusEvent e) {
					if(txtFecha.getText().equals(fech)) {
						txtFecha.setText("");
						txtFecha.setForeground(Color.black);
					}
					
				}
				
				@Override
				public void focusLost(FocusEvent e) {
					if(txtFecha.getText().isEmpty()) {
						txtFecha.setText(fech);
						txtFecha.setForeground(Color.gray);
				}
			
				
			}	
		});
		//Si la fecha no es valida el boton de registro no esta activo
		txtFecha.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validarFecha();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				validarFecha();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				validarFecha();
				
			}
		});
		//ActionListeners
		btnPoliticaDePrivacidad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Leer la politica de privacidad
				String rutaArchivo = "resources/data/PoliticaDePrivacidad.txt";
				String datos = Fichero.leerFichero(rutaArchivo);
				//Hacer que el tetxto aparezca en buenas condiciones
				JTextArea area = new JTextArea(datos);
				area.setEditable(false);
				area.setLineWrap(true);
				area.setWrapStyleWord(true);
				//Meter un scroll para que el texto no tenga problemas de visualizacion
				JScrollPane scroll = new JScrollPane(area);
				scroll.setPreferredSize(new Dimension(400,300));
				JOptionPane.showMessageDialog(null, scroll, "Reglas del juego", JOptionPane.INFORMATION_MESSAGE);
				PoliticaDePrivacidad.setSelected(true);
			}
		});
		btnCrearCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				//Revisar Y crear la cuenta
				if(camposCompletos()) {
					Usuario u = new Usuario(txtDNI.getText(), txtNombre.getText(), txtApellido.getText(), txtNombreU.getText(), txtContrasena.getText(), anyos, new ArrayList<>());
					Main.DBlstUsuarios.add(u);
					new VentanaInicioSesion();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Se debe introducir lod datos correctamente","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		pack();
		setVisible(true);
	}
	
	//Metodos
	public void validarFecha() {
        // Intentar analizar la fecha
		String fechaTexto = txtFecha.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
            int anyo = fecha.getYear();
            if(2024-anyo >=18) {
            	btnCrearCuenta.setEnabled(true);
            	anyos = 2024-anyo;
            }
        } catch (Exception e) {
           
        }
    }
	//Comprobar si todos los datos estan rellenados correctamente
	private boolean camposCompletos() {
	    return !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDNI.getText().isEmpty()
	            && !txtNombreU.getText().isEmpty() && !txtContrasena.getText().isEmpty();
	}
}
