package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Avion;
import domain.Usuario;
import main.Main;

public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Elementos
	private JLabel titulo;
	private JLabel destino;
	private JComboBox<String> comboBox;

	//Tabla
	private JTable tablaVuelos;
	private DefaultTableModel dtmVuelos;
	private JScrollPane scrollVuelos;
	
	//Botones
	private JButton btnUsuario;
	
	
	public VentanaPrincipal(Usuario user, List<Avion> lstVuelos) {
		setTitle("AirDeusto");
		setSize(850,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//Elementos
		titulo = new JLabel("AirDeusto");
		Font font = titulo.getFont();
		Font f = new Font(font.getName(), Font.PLAIN, 30);
		titulo.setFont(f);
		destino = new JLabel("Destino: ");
		comboBox = new JComboBox<>();
		for(String pais :Main.paises) {
			comboBox.addItem(pais);
		}
		//Botones
		btnUsuario = new JButton("Perfil");
		
		//Tabla
		dtmVuelos = new DefaultTableModel();
			dtmVuelos.addColumn("Destino");
			for(Avion avion:lstVuelos) {
				dtmVuelos.addRow(new Object[] {avion.getPaisOrg()});
			}
		tablaVuelos = new JTable(dtmVuelos);
		scrollVuelos = new JScrollPane(tablaVuelos);
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(titulo);
			pCabecera.setBackground(Color.lightGray);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pGeneral = new JPanel(new GridLayout(2,1));
			JPanel pOpciones = new JPanel(new FlowLayout());
				pOpciones.add(destino);	
				pOpciones.add(comboBox);
				if(user.getNombre() != null) {
					pOpciones.add(btnUsuario);
				}
			pGeneral.add(pOpciones);
			JPanel pBajo = new JPanel(new BorderLayout());
				pBajo.add(scrollVuelos, BorderLayout.CENTER);
			pGeneral.add(pBajo);
		add(pGeneral, BorderLayout.CENTER);
		
		
		//ActionListeners
		btnUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaUsuario(user);
			}
		});
		
		
		setVisible(true);
	}
	

}
