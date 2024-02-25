package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import domain.Asiento;
import domain.Avion;
import domain.Usuario;

public class VentanaReserva extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Elementos
	private JLabel cabecera;
	private JLabel info;
	private JLabel asiento;
	private JTextField txtAsiento;
	
	//Botones
	private JButton btnReserva;
	
	//Tabla
	private DefaultTableModel dtmAsientos;
	private JTable asientos;
	private JScrollPane scroll ;
	
	public VentanaReserva(Avion avion, Usuario user) {
		setTitle("Reserva de Ticket");
		setSize(600,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//Elementos
		cabecera = new JLabel("Reserva de asientos");
		info= new JLabel("Mapa de asientos (Asientos libres: " + (avion.getCapacidad() - avion.getPasajeros().size()) + ")");
		asiento = new JLabel("Asiento: ");
		txtAsiento = new JTextField(3);
		
		//Boton
		btnReserva = new JButton("Reservar");
		
		//Tabla
		dtmAsientos = rrellenadoTabla(avion.getCapacidad());
		asientos = new JTable(dtmAsientos);
		asientos.setEnabled(false);
		if(avion.getCapacidad() <= 300) {
			asientos.setDefaultRenderer(Object.class, new MyRender300());
		}else {
			asientos.setDefaultRenderer(Object.class, new MyRender1000());
		}
		scroll = new JScrollPane(asientos);
		
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(cabecera);
			pCabecera.setBackground(Color.cyan);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pCentral = new JPanel(new BorderLayout());
			JPanel pInfo = new JPanel(new FlowLayout());
				pInfo.add(info);
			pCentral.add(pInfo, BorderLayout.NORTH);
			pCentral.add(scroll, BorderLayout.CENTER);
		add(pCentral, BorderLayout.CENTER);
		JPanel pDerecha = new JPanel();
		add(pDerecha, BorderLayout.EAST);
		JPanel pIzq = new JPanel();
		add(pIzq, BorderLayout.WEST);
		JPanel pBajo = new JPanel(new GridLayout(2,1));
			JPanel pBajoAlto = new JPanel(new FlowLayout());
				pBajoAlto.add(asiento);
				pBajoAlto.add(txtAsiento);
			pBajo.add(pBajoAlto);
			JPanel pBajoBajo = new JPanel(new FlowLayout());
				pBajoBajo.add(btnReserva);
			pBajo.add(pBajoBajo);
		add(pBajo, BorderLayout.SOUTH);
		
		btnReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaCompraUsuario(avion, user, Integer.parseInt(txtAsiento.getText()));
				
			}
		});
		
		setVisible(true);
	}
	
	//Para rrellenar la tabla con algunos parametros
	public DefaultTableModel rrellenadoTabla(int capacidad) {
		DefaultTableModel dtm = new DefaultTableModel();
		int contador=1;
		if(capacidad <= 300) {
			//Columnas
			dtm.addColumn("Fila 1");
			dtm.addColumn("Fila 2");
			dtm.addColumn("Pasillo");
			dtm.addColumn("Pasillo");
			dtm.addColumn("Fila 3");
			dtm.addColumn("Fila 4");
			for(int i = 1;i<= capacidad ; i++ ) {
				dtm.addRow(new Object[] {contador,contador+1," "," ",contador+2,contador+3});
				contador+=4;
				if(contador >= capacidad) {
					break;
				}
			}
		}else {
			//Columnas
			dtm.addColumn("Fila 1");
			dtm.addColumn("Fila 2");
			dtm.addColumn("Fila 3");
			dtm.addColumn("Pasillo");
			dtm.addColumn("Pasillo");
			dtm.addColumn("Fila 4");
			dtm.addColumn("Fila 5");
			dtm.addColumn("Fila 6");
			for(int i = 1;i<= capacidad ; i++ ) {
				dtm.addRow(new Object[] {contador,contador+1,contador+2," "," ",contador+3, contador+4,contador+5});
				contador +=6;
				if(contador >= capacidad) {
					break;
				}
			}
		}
		return dtm;
	}
	
	//Render
	class MyRender300 extends JLabel implements TableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MyRender300() {
	        super();
	        setOpaque(true);
	        setHorizontalAlignment(CENTER);
	    }

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			
			if(column== 2 || column == 3) {
				setBackground(Color.lightGray);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				setBackground(Color.red);
			}
			if(value == " ") {
				
			}else {
				Asiento ob = new Asiento(Integer.parseInt(value.toString()));
				if(ob.isOcupado()) {
					setBackground(Color.red);
				}else{
					setBackground(Color.white);
				}
			}
			
			return this;
		}
		
	}
	
	class MyRender1000 extends JLabel implements TableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		 
		public MyRender1000() {
		        super();
		        setOpaque(true);
		        setHorizontalAlignment(CENTER);
		    }
		 
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			
			if(column== 3 || column == 4) {
				setBackground(Color.lightGray);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				setBackground(Color.red);
			}
			if(value == " ") {
				
			}else {
				Asiento ob = new Asiento(Integer.parseInt(value.toString()));
				if(ob.isOcupado()) {
					setBackground(Color.red);
				}else{
					setBackground(Color.white);
				}
			}
			return this;
		}
		
	}
	
	
}
