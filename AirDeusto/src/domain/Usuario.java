package domain;

import java.util.List;


public class Usuario {
	
	//Atributos
	private String DNI;
	private String nombre;
	private String apellido;
	private String nUsuario;
	private String contrasena;
	private int edad;
	private List<Tarjeta> cartera;
	
	//Constructor
	public Usuario() {
		super();
	}
	public Usuario(String dNI, String nombre, String apellido, String nUsuario, String contrasena, int edad,
			List<Tarjeta> cartera) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nUsuario = nUsuario;
		this.contrasena = contrasena;
		this.edad = edad;
		this.cartera = cartera;
	}
		
	//Getters y Setters	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getnUsuario() {
		return nUsuario;
	}
	public void setnUsuario(String nUsuario) {
		this.nUsuario = nUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public List<Tarjeta> getCartera() {
		return cartera;
	}
	public void setCartera(List<Tarjeta> cartera) {
		this.cartera = cartera;
	}
	//Metodos
	//TODO
	public void addTarjeta(Tarjeta trj) {
		cartera.add(trj);
	}
	
	
}
