package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import domain.Avion;
import domain.AvionPrivado;
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
	private JLabel dia;
	private JTextField txtDia;
	
	//Tabla
	private JTable tablaVuelos;
	private TableModel modelo;
	private JScrollPane scrollVuelos;
	
	//Lista
	private JList<AvionPrivado> lstAvionPrivado;
	private DefaultListModel<AvionPrivado> dlmAvionPrivado;
	private JScrollPane scrollAvionPrivado;
	
	//Botones
	private JButton btnUsuario;
	private JButton btnReserva;
	private JButton btnBusqueda;
	private JButton btnAvionPrivado;
	
	//Objetos
	private Avion avion ;
	private AvionPrivado avionPrivado;
	
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
		dia = new JLabel("Dia de Salida: ");
		txtDia = new JTextField(15);
	
		//Botones
		btnUsuario = new JButton("Perfil");
		btnReserva = new JButton("Reservar Plaza");
			btnReserva.setEnabled(false);
		btnBusqueda = new JButton("Buscar");
		btnAvionPrivado = new JButton("Reservar vuelo privado");
			btnAvionPrivado.setEnabled(false);
	
		//Lista
		dlmAvionPrivado = new DefaultListModel<>();
			//dlmAvionPrivado.addAll(DBlstAvionPrivado);
		for(AvionPrivado avp : Main.DBlstAvionesPrivados) {
			if(avp.getUser().equals(user)) {
				dlmAvionPrivado.addElement(avp);
			}
		}
		lstAvionPrivado = new JList<AvionPrivado>(dlmAvionPrivado);
		scrollAvionPrivado = new JScrollPane(lstAvionPrivado);
		
		//Tabla
		modelo = new TableModel(lstVuelos);
		tablaVuelos = new JTable(modelo);
		tablaVuelos.setDefaultRenderer(Object.class, new MyTableRender());
		scrollVuelos = new JScrollPane(tablaVuelos);
		
		//Objetos
		avion = new Avion();
		avionPrivado = new AvionPrivado();
		
		setLayout(new BorderLayout());
		JPanel pCabecera = new JPanel(new FlowLayout());
			pCabecera.add(titulo);
			pCabecera.setBackground(Color.cyan);
		add(pCabecera, BorderLayout.NORTH);
		JPanel pGeneral = new JPanel(new GridLayout(2,1));
			JPanel pGeneralAlto = new JPanel(new GridLayout(1,2));
				JPanel pGeneralAltoIzq = new JPanel(new GridLayout(3,1));	
				JPanel pOpciones = new JPanel(new FlowLayout());
					pOpciones.add(destino);	
					pOpciones.add(comboBox);
				pGeneralAltoIzq.add(pOpciones);
				JPanel pDias = new JPanel(new FlowLayout());
					pDias.add(dia);
					pDias.add(txtDia);
				pGeneralAltoIzq.add(pDias);
				JPanel pBusqueda = new JPanel(new FlowLayout());
					pBusqueda.add(btnBusqueda);
				pGeneralAltoIzq.add(pBusqueda);
				JPanel pBotones = new JPanel(new BorderLayout());
				if(user.getNombre() != null) {
					pBotones.add(btnUsuario, BorderLayout.NORTH);
					pBotones.add(scrollAvionPrivado, BorderLayout.CENTER);
					pBotones.add(btnAvionPrivado, BorderLayout.SOUTH);
				}		
				pGeneralAlto.add(pGeneralAltoIzq);
				pGeneralAlto.add(pBotones);
			pGeneral.add(pGeneralAlto);
			JPanel pBajo = new JPanel(new BorderLayout());
				pBajo.add(scrollVuelos, BorderLayout.CENTER);
			pGeneral.add(pBajo);
		add(pGeneral, BorderLayout.CENTER);
		JPanel pSur = new JPanel(new FlowLayout());
			pSur.add(btnReserva);
		add(pSur, BorderLayout.SOUTH);
		
		//ActionListeners
		btnUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaUsuario(user);
			}
		});
		
		btnBusqueda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tablaVuelos.getSelectedRow();
		        if (selectedRow != -1) {
		            modelo.setAvionSeleccionado(selectedRow);
		            avion = modelo.getAvionSeleccionado();
		            new VentanaReserva(avion, user);
		        }
			}
		});
		
		btnAvionPrivado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new VentanaAvionPrivado(avionPrivado);
				
			}
		});
		
		setVisible(true);
	}
	
	//TableModel
	class TableModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Avion avionSeleccionado = new Avion();
		//A�adidos
		private String[] cabecera = {"Aerolinea","Origen","Destino","Salida","Duracion","Asientos libres","Precio"};
		List<Avion> aviones;
		
		public TableModel(List<Avion> aviones) {
			this.aviones = aviones;
			
		}
		
		@Override
		public String getColumnName(int column) {
			return cabecera[column];
		}

		@Override
		public int getRowCount() {
			return aviones.size();
		}

		@Override
		public int getColumnCount() {
			return cabecera.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Avion a = aviones.get(rowIndex);
			switch(columnIndex) {
				case 0: return a.getCompania();
				case 1: return a.getPaisOrg();
				case 2: return a.getPaisDest();
				case 3: return a.LongAFecha(a.getHoraSalida());//a.getHoraSalida();
				case 4: return a.getDuracionViaje();
				case 5: return a.getCapacidad();
				case 6: return a.getPrecio();
				default:return null;
			}
			
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			avionSeleccionado = aviones.get(rowIndex);
		}
		
		public Avion getAvionSeleccionado() {
			return avionSeleccionado;
		}
		public void setAvionSeleccionado(int rowIndex) {
	        avionSeleccionado = aviones.get(rowIndex);
	    }
		
	}
	
	//Render
	class MyTableRender extends JLabel implements TableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			if(row % 2 == 0) {
				setBackground(Color.cyan);
			}else {
				setBackground(Color.white);
			}
			if(isSelected) {
				setBackground(Color.lightGray);
				btnReserva.setEnabled(true);
				avion = modelo.getAvionSeleccionado();
			}
			return this;
		}
		
	}
	
	class MyListRender extends JLabel implements ListCellRenderer<AvionPrivado>{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends AvionPrivado> list, AvionPrivado value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			if(isSelected) {
				avionPrivado = value;
				btnAvionPrivado.setEnabled(true);
				setBackground(Color.green);
			}else {
				setBackground(Color.white);
			}
			return this;
		}
		
	}

}
