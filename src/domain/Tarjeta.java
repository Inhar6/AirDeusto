package domain;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Tarjeta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int nEmbarque;
	private String puertaEmbarque;
	private int asiento;
	private long horaSalida;
	private Usuario user;
	private Avion avion;

	//Constructor
	public Tarjeta() {
		super();
	}
	
	public Tarjeta(int nEmbarque, String puertaEmbarque, Usuario user, Avion avion, long horaSalida, int asiento) {
		super();
		this.nEmbarque = nEmbarque;
		this.puertaEmbarque = puertaEmbarque;
		this.user = user;
		this.avion = avion;
		this.horaSalida = horaSalida;
		this.asiento = asiento;
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
	
	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
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
	//Metodos
	//TODO
	public String LongAFechaHora(long l) {
		Date date = new Date(l);
		//Formato
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        // Formatear la fecha como una cadena
        String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	//toString
	@Override
	public String toString() {
		return "Tarjeta de Embarque: " + nEmbarque;
	}
	
}
