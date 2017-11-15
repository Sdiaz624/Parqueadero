package com.ceiba.domain;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "VEHICULO")
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", precision=4)
	private int id;
	
	@Column(name="placa")
	private String placa;
			
	@Column(name="tipoVehiculo")
	private char tipoVehiculo;
	
	@Column (name="cilindraje")
	private String cilindraje;	
		
	public Vehiculo() {
	}
	
	public Vehiculo(int id, String placa, char tipoVehiculo, String cilindraje) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public char getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(char tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
}
