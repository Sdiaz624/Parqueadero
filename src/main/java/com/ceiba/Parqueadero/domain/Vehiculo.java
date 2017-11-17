package com.ceiba.parqueadero.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "VEHICULO")
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VEHICULO_ID", precision=4)
	private int id;
	
	
	@Column(name="PLACA", unique=true)
	private String placa;
			
	@Column(name="TIPOVEHICULO")
	private char tipoVehiculo;
	
	@Column (name="CILINDRAJE")
	private int cilindraje;
	
	@OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
	private List<Parqueadero> parqueadero = new ArrayList<>();
 
	public Vehiculo() {
	}
			
	public Vehiculo(int id, String placa, char tipoVehiculo, int cilindraje) {
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}
	
	public Vehiculo(String placa, char tipoVehiculo, int cilindraje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}


	public List<Parqueadero> getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(ArrayList<Parqueadero> parqueadero) {
		this.parqueadero = parqueadero;
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

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
}
