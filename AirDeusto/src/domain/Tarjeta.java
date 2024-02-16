package domain;

public class Tarjeta {
	
	//Atributos
	private int nEmbarque;
	private String puertaEmbarque;
	private Usuario user;
	private Avion avion;

	//Constructor
	public Tarjeta(int nEmbarque, String puertaEmbarque, Usuario user, Avion avion) {
		super();
		this.nEmbarque = nEmbarque;
		this.puertaEmbarque = puertaEmbarque;
		this.user = user;
		this.avion = avion;
	}
	
	//Getters y Setters
	public int getnEmbarque() {
		return nEmbarque;
	}

	public void setnEmbarque(int nEmbarque) {
		this.nEmbarque = nEmbarque;
	}

	public String getPuertaEmbarque() {
		return puertaEmbarque;
	}

	public void setPuertaEmbarque(String puertaEmbarque) {
		this.puertaEmbarque = puertaEmbarque;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
}
