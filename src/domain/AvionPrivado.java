package domain;

public class AvionPrivado extends Avion {
	
	//Elementos
	private Usuario user;
	private float tamaño;
	//Constructor
	public AvionPrivado() {
		super();
	}
	public AvionPrivado(Usuario user, float tamaño) {
		super();
		this.user = user;
		this.tamaño = tamaño;
	}
	//Getters y Setters
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public float getTamaño() {
		return tamaño;
	}
	public void setTamaño(float tamaño) {
		this.tamaño = tamaño;
	}
	//toString
	@Override
	public String toString() {
		return "AvionPrivado [user=" + user + ", tamaño=" + tamaño + "]";
	}
	
}
