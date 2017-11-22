package com.ceiba.parqueadero.domain;

public class VehiculoTestBuilder {

	private String placa;
	private char tipoVehiculo;
	private int cilindraje;
	
	public VehiculoTestBuilder() {
		this.placa = "AD4K83K";
		this.tipoVehiculo = 'C';
		this.cilindraje = 600;
	}
	
	public Vehiculo buildCarro() {
		return new Vehiculo (this.placa,this.tipoVehiculo,this.cilindraje);
	}
	
	public Vehiculo buildMoto() {
		return new Vehiculo (1141,this.placa,'M',this.cilindraje);
	}
	
	public Vehiculo buildWithPlaca(String placa) {
		return new Vehiculo (1141,placa,'M',this.cilindraje);
	}
	
}
