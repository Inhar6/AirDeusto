package domain;

public class Asiento {
	
	//Atributos
	private int lugar;
	private boolean ocupado;
	
	//Constructor
	public Asiento() {
		super();
	}

	public Asiento(int lugar) {
		super();
		this.lugar = lugar;
		this.ocupado = false;
	}

	public Asiento(int lugar, boolean ocupado) {
		super();
		this.lugar = lugar;
		this.ocupado = ocupado;
	}
	
	//Gettes y Setters
	public int getLugar() {
		return lugar;
	}
	public void setLugar(int lugar) {
		this.lugar = lugar;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	//toString
	@Override
	public String toString() {
		return "Asiento: " + lugar;
	}
	
	
	
}
