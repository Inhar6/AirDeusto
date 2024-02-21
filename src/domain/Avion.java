package domain;

import java.util.List;
import java.util.Map;

public class Avion implements Comparable<Avion>{
	
	//Atributos
	private int id;
	private String compania;
	private String paisOrg;
	private String paisDest;
	private int capacidad;
	private double duracionViaje;
	private long horaSalida;
	private int precio;
	private List<Tarjeta> pasajeros;
	private Map<Asiento, Tarjeta> mapaPasajeros;
	
	//Constructores
	public Avion() {
		super();
	}
	
	public Avion(int id, int capacidad) {
		super();
		this.id = id;
		this.capacidad = capacidad;
	}
	
	public Avion(int id, String paisOrg, String paisDest, int capacidad, double duracionViaje, long horaSalida,
			List<Tarjeta> pasajeros,Map<Asiento, Tarjeta> mapaPasajeros, String compania, int precio) {
		super();
		this.id = id;
		this.paisOrg = paisOrg;
		this.paisDest = paisDest;
		this.capacidad = capacidad;
		this.duracionViaje = duracionViaje;
		this.horaSalida = horaSalida;
		this.pasajeros = pasajeros;
		this.mapaPasajeros = mapaPasajeros;
		this.compania = compania;
		this.precio = precio;
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
	public Map<Asiento, Tarjeta> getMapaPasajeros() {
		return mapaPasajeros;
	}

	public void setMapaPasajeros(Map<Asiento, Tarjeta> mapaPasajeros) {
		this.mapaPasajeros = mapaPasajeros;
	}
	public String getCompania() {
		return compania;
	}
	
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	//Metodos
	//TODO
	public void addLstPasajero(Tarjeta trj){
		pasajeros.add(trj);
	}
	public void addMapPasajeros(Asiento asiento, Tarjeta trj) {
		mapaPasajeros.put(asiento, trj);
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
