package domain;

public class Tarjeta {
	
	//Atributos
	private int nEmbarque;
	private String puertaEmbarque;
	private long horaSalida;
	private Usuario user;
	private Avion avion;

	//Constructor
	public Tarjeta() {
		super();
	}
	
	public Tarjeta(int nEmbarque, String puertaEmbarque, Usuario user, Avion avion, long horaSalida) {
		super();
		this.nEmbarque = nEmbarque;
		this.puertaEmbarque = puertaEmbarque;
		this.user = user;
		this.avion = avion;
		this.horaSalida = horaSalida;
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

	public long getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(long horaSalida) {
		this.horaSalida = horaSalida;
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

	//toString
		@Override
	public String toString() {
		return "Tarjeta de Embarque: " + nEmbarque;
	}
	
}
