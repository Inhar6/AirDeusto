package db;

public class DBCreator {
	
	public static void main(String[] args) {
		
		System.out.println("Conectando a la BD");
		
		//Creacion de tablas
		System.out.println("Tabla Usuarios");
		DBManager.crearTablaUsuario();
		
		System.out.println("Tabla Avion");
		DBManager.crearTablaAvion();
		
		System.out.println("Tabla Cartera");
		DBManager.crearTablaCartera();
		
		
		//Insercion de Usuarios
		/*
		System.out.println("Usuarios introducidos");
		DBManager.añadirUsuariosEjemplo();
		
		System.out.println("Aviones introducidos");
		DBManager.añadirAvionesEjemplo();
		
		System.out.println("Carteras introducidas");
		DBManager.añadirCarterasEjemplo();
		*/
	}
}
