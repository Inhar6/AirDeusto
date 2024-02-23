package domain;

import java.util.Map;

public class AvionComercial extends Avion{

	//Elementos
	private String producto;
	private Map<Integer, String> productos;
	private int pesoMax;
	//Constructor
	public AvionComercial() {
		super();
	}
	public AvionComercial(String producto, Map<Integer, String> productos, int pesoMax) {
		super();
		this.producto = producto;
		this.productos = productos;
		this.pesoMax = pesoMax;
	}
	//Getters y Setters
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Map<Integer, String> getProductos() {
		return productos;
	}
	public void setProductos(Map<Integer, String> productos) {
		this.productos = productos;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}
	//toString
	@Override
	public String toString() {
		return "AvionComercial [producto=" + producto + ", productos=" + productos + ", pesoMax=" + pesoMax + "]";
	}
	
}
