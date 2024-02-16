package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import domain.Avion;
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
	
	
	
	public VentanaPrincipal(List<Avion> lstVuelos) {
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
		
		//Tabla
		dtmVuelos = new DefaultTableModel();
			dtmVuelos.addColumn("Destino");
			for(Avion avion:lstVuelos) {
				dtmVuelos.addRow(new Object[] {avion.getPaisOrg()});
			}
		tablaVuelos = new JTable(dtmVuelos);
		scrollVuelos = new JScrollPane(tablaVuelos);
		
		setLayout(new GridLayout(2,1));
		JPanel pAlto = new JPanel(new GridLayout(2,1));
			JPanel pSuperior = new JPanel(new GridLayout(2,1));
				JPanel pTitulo = new JPanel(new FlowLayout());
					pTitulo.add(titulo);
					pTitulo.setBackground(Color.lightGray);
				JPanel pOpciones = new JPanel(new FlowLayout());
					pOpciones.add(destino);	
					pOpciones.add(comboBox);
				pSuperior.add(pTitulo);
				pSuperior.add(pOpciones);				
				pSuperior.setBackground(Color.LIGHT_GRAY);
			pAlto.add(pSuperior);
		JPanel pBajo = new JPanel(new BorderLayout());
			pBajo.add(scrollVuelos, BorderLayout.CENTER);

		add(pAlto);
		add(pBajo);
		setVisible(true);
	}
	

}
