package com.ceiba.parqueadero.domain;
import java.util.Calendar;

public class ParqueaderoTestBuilder {

	private int id;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private double total;
	private Vehiculo vehiculo;
	
	public ParqueaderoTestBuilder() {
		this.id = 4444;
		this.fechaIngreso = Calendar.getInstance();
		this.vehiculo = new VehiculoTestBuilder().buildMoto();
		this.fechaSalida = Calendar.getInstance();
		this.total = 58585;
	}
	
	public Parqueadero build() {
		return new Parqueadero (this.fechaIngreso, this.vehiculo);
	}
	
	public Parqueadero buildSalida() {
		return new Parqueadero (this.id, this.fechaIngreso, this.fechaSalida, this.vehiculo);
	}
	
	
	
}
