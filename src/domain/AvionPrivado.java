package domain;

import java.io.Serializable;

public class AvionPrivado extends Avion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Elementos
	private Usuario user;
	private float tamanyo;
	//Constructor
	public AvionPrivado() {
		super();
	}
	public AvionPrivado(Usuario user, float tamanyo) {
		super();
		this.user = user;
		this.tamanyo = tamanyo;
	}
	//Getters y Setters
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public float getTamanyo() {
		return tamanyo;
	}
	public void setTamanyo(float tamanyo) {
		this.tamanyo = tamanyo;
	}
	//toString
	@Override
	public String toString() {
		return "AvionPrivado [user=" + user + ", tama�o=" + tamanyo + "]";
	}
	
}
