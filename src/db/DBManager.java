package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Asiento;
import domain.Avion;
import domain.Tarjeta;
import domain.Usuario;

public class DBManager {
	
	//URL
	private static final String URL = "jdbc:sqlite:resources/db/AirDeusto.db";
	 
	/*
	 * Conexion con la BD
	 */
    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    // Método para cerrar una conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //Funciones
    public static List<Usuario> obtenerTodosLosUsuarios(){
		List<Usuario> lst = new ArrayList<>();
    	try (Connection conn = obtenerConexion();
    			Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String nombreU = rs.getString("nombre_usuario");
				String DNI =rs.getString("DNI");
				int edad = rs.getInt("edad");
				String contraseña = rs.getString("contraseña");
				Usuario user = new Usuario(DNI, nombre, apellido, nombreU, contraseña, edad, new ArrayList<>());
				lst.add(user);
			}
			ResultSet rsCartera = stmt.executeQuery("SELECT * FROM Usuario u, Cartera c WHERE u.nombre_usuario = c.nombre_usuario");
			while(rsCartera.next()) {
				for(Usuario u : lst) {
					if(u.getnUsuario().equals(rsCartera.getString("nombre_usuario"))) {
						int nEmbarque = rsCartera.getInt("nEmbarque");
						String puertaEmbarque = rsCartera.getString("puertaEmabrque");
						int asiento = rsCartera.getInt("asiento");
						long horaSalida = rsCartera.getLong("horaSalida");
						int idAvion = rsCartera.getInt("id_avion");
						List<Avion> lstAvion = obtenerTodosLosAviones();
						for(Avion a : lstAvion) {
							if(a.getId() == idAvion) {
								Tarjeta trj = new Tarjeta(nEmbarque, puertaEmbarque, u, a, horaSalida, asiento);
								/*
								//Avion
								a.addLstPasajero(trj);
								a.addPasajerosMapa(trj);
								*/
								//Usuario
								u.addTarjeta(trj);
							}
						}
					}
				}
			}
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
    }
    public static List<Avion> obtenerTodosLosAviones(){
  		List<Avion> lst = new ArrayList<>();
      	try (Connection conn = obtenerConexion();
      			Statement stmt = conn.createStatement()){
  			ResultSet rsAvion = stmt.executeQuery("SELECT * FROM Avion;");
				//Rellenar la lista de aviones
  				while(rsAvion.next()) {
						int id = rsAvion.getInt("id_Avion");
						String compania = rsAvion.getString("compania");
						String paisOrig = rsAvion.getString("paisOrigen");
						String paisDest = rsAvion.getString("paisDestino");
						int capacidad = rsAvion.getInt("capacidad");
						double duracion = rsAvion.getDouble("duracion");
						long horaSalidaAvion = rsAvion.getLong("horaSalidaAvion");
						int precio = rsAvion.getInt("precio");
						Avion avion = new Avion(id, paisOrig, paisDest, capacidad, duracion, horaSalidaAvion, new ArrayList<>(), new HashMap<Asiento,Tarjeta>(), compania, precio);
						lst.add(avion);
				}
  			return lst;
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return null;
  		}
      	
      }
  
    
  //Verificar existencia de usuario ( Login )
  	public static boolean existeUsuarioLogin(String nombreU, String contraseña) {
  		String sql= "SELECT * FROM Usuario WHERE nombre_usuario = ? AND contraseña = ?";
  		try (Connection conn = obtenerConexion();
  				PreparedStatement pstmt = conn.prepareStatement(sql)){
  			pstmt.setString(1, nombreU);
  			pstmt.setString(2, contraseña);
  			ResultSet rs = pstmt.executeQuery();
  			return rs.next();
  		} catch (SQLException e) {
  			e.printStackTrace();
  			return false;
  		}
  	}
    
    
    
    
    
    //TABLAS
    public static void crearTablaUsuario() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
			stmt.executeUpdate(" CREATE TABLE IF NOT EXISTS Usuario (\n"
					+ "    	nombre VARCHAR(50),\n"
					+ "    	apellido VARCHAR(50),\n"
					+ "    	DNI VARCHAR(50),\n"
					+ "    	edad INTEGER,\n"
					+ "    	contraseña VARCHAR(50),\n"
					+ "    	nombre_usuario VARCHAR(50) PRIMARY KEY); ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void crearTablaAvion() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
			stmt.executeUpdate(" CREATE TABLE IF NOT EXISTS Avion (\n"
					+ "    	id_Avion INTEGER PRIMARY KEY,\n"
					+ "    	compania VARCHAR(50),\n"
					+ "    	paisOrigen VARCHAR(50),\n"
					+ "    	paisDestino VARCHAR(50),\n"
					+ "    	capacidad INTEGER,\n"
					+ "    	duracion DOUBLE,\n"
					+ "    	horaSalidaAvion BIGINT,\n"
					+ "    	precio INTEGER ); ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}    
    public static void crearTablaCartera() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
			stmt.executeUpdate(" CREATE TABLE IF NOT EXISTS Cartera (\n"
					+ "    	nombre_usuario VARCHAR(50),\n"
					+ "    	id_Avion INTEGER,\n"
					+ "    	nEmbarque INTEGER,\n"
					+ "    	puertaEmabrque VARCHAR(50),\n"
					+ "    	asiento INTEGER,\n"
					+ "    	horaSalida BIGINT,\n"
					+ "		FOREIGN KEY (id_Avion) REFERENCES Avion(id_Avion),\n"
					+ "    	FOREIGN KEY (nombre_usuario) REFERENCES Usuario(nombre_usuario));");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    //Añadir datos
    public static void añadirUsuariosEjemplo() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
				for (int i = 1; i <= 10; i++) {
		            String insertUsuario = String.format(
		                    "INSERT INTO Usuario (nombre, apellido, DNI, edad, contraseña, nombre_usuario) " +
		                            "VALUES ('Usuario%d', 'Apellido%d', 'DNI%d', %d, 'clave%d', 'usuario%d');",
		                    i, i, i, 20 + i, i, i);
		            stmt.executeUpdate(insertUsuario);
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void añadirAvionesEjemplo() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
			
		   for (int i = 1; i <= 10; i++) {
	            String insertAvion = String.format(
	                    "INSERT INTO Avion (compania, paisOrigen, paisDestino, capacidad, duracion, horaSalidaAvion, precio) " +
	                            "VALUES ('Compania%d', 'Origen%d', 'Destino%d', %d, 2.5, %d, %d);",
	                    i, i, i, 100 + i,  System.currentTimeMillis(), 200 + i);
	            stmt.executeUpdate(insertAvion);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void añadirCarterasEjemplo() {
		try (Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
			for (int i = 1; i <= 10; i++) {
	            String insertCartera = String.format(
	                    "INSERT INTO Cartera (nombre_usuario, id_Avion, nEmbarque, puertaEmabrque, asiento, horaSalida) " +
	                            "VALUES ('usuario%d', %d, %d, 'Puerta%d', %d, %d);",
	                    i, i, i, i, i, System.currentTimeMillis());
	            stmt.executeUpdate(insertCartera);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
