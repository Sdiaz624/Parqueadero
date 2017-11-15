package com.ceiba.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name = "PARQUEADERO")
public class Parqueadero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", precision=5)
	private int id;
	
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	
	@Column(name="fechaSalida")
	private Date fechaSalida;

	@Column(name= "vehiculo")
	private Vehiculo vehiculo;
		
	public Parqueadero() {
	}

	public Parqueadero(int id, Date fechaIngreso, Date fechaSalida, Vehiculo vehiculo) {
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
}
