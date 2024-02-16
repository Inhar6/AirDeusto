package domain;

import java.util.List;
import java.util.Map;

public class Avion implements Comparable<Avion>{
	
	//Atributos
	private int id;
	private String paisOrg;
	private String paisDest;
	private int capacidad;
	private double duracionViaje;
	private long horaSalida;
	private List<Tarjeta> pasajeros;
	private Map<Integer, Usuario> mapaPasajeros;
	
	//Constructores
	public Avion(int id, int capacidad) {
		super();
		this.id = id;
		this.capacidad = capacidad;
	}
	
	public Avion(int id, String paisOrg, String paisDest, int capacidad, double duracionViaje, long horaSalida,
			List<Tarjeta> pasajeros,Map<Integer, Usuario> mapaPasajeros) {
		super();
		this.id = id;
		this.paisOrg = paisOrg;
		this.paisDest = paisDest;
		this.capacidad = capacidad;
		this.duracionViaje = duracionViaje;
		this.horaSalida = horaSalida;
		this.pasajeros = pasajeros;
		this.mapaPasajeros = mapaPasajeros;
	}

	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaisOrg() {
		return paisOrg;
	}

	public void setPaisOrg(String paisOrg) {
		this.paisOrg = paisOrg;
	}

	public String getPaisDest() {
		return paisDest;
	}

	public void setPaisDest(String paisDest) {
		this.paisDest = paisDest;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getDuracionViaje() {
		return duracionViaje;
	}

	public void setDuracionViaje(double duracionViaje) {
		this.duracionViaje = duracionViaje;
	}

	public long getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(long horaSalida) {
		this.horaSalida = horaSalida;
	}

	public List<Tarjeta> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Tarjeta> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Map<Integer, Usuario> getMapaPasajeros() {
		return mapaPasajeros;
	}

	public void setMapaPasajeros(Map<Integer, Usuario> mapaPasajeros) {
		this.mapaPasajeros = mapaPasajeros;
	}
	//Metodos
	//TODO
	public void addLstPasajero(Tarjeta trj){
		pasajeros.add(trj);
	}
	public void addMapPasajeros(int asiento, Usuario user) {
		mapaPasajeros.put(asiento, user);
	}
	//toString
	
	
	@Override
	public String toString() {
		return "Avion [id=" + id + ", paisOrg=" + paisOrg + ", paisDest=" + paisDest + ", capacidad=" + capacidad
				+ ", duracionViaje=" + duracionViaje + ", horaSalida=" + horaSalida + ", pasajeros=" + pasajeros + "]";
	}
	
	//Extras
	
	@Override
	public int compareTo(Avion o) {
		return this.getId()- o.getId();
	}
}
