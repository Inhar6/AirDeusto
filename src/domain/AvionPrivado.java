package domain;

public class AvionPrivado extends Avion {
	
	//Elementos
	private Usuario user;
	private float tama�o;
	//Constructor
	public AvionPrivado() {
		super();
	}
	public AvionPrivado(Usuario user, float tama�o) {
		super();
		this.user = user;
		this.tama�o = tama�o;
	}
	//Getters y Setters
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public float getTama�o() {
		return tama�o;
	}
	public void setTama�o(float tama�o) {
		this.tama�o = tama�o;
	}
	//toString
	@Override
	public String toString() {
		return "AvionPrivado [user=" + user + ", tama�o=" + tama�o + "]";
	}
	
}
