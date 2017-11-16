package com.ceiba.Parqueadero.domain;
import java.io.Serializable;
import java.time.LocalDateTime;


import javax.persistence.*;

@Entity
@Table (name = "PARQUEADERO")
public class Parqueadero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PARQUEADERO_ID", precision=5)
	private int id;
	
	@Column(name="FECHAINGRESO")
	private LocalDateTime fechaIngreso;
	
	@Column(name="FEHCASALIDA")
	private LocalDateTime fechaSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICULO_ID")
	private Vehiculo vehiculo;
			
	public Parqueadero() {
	}

	public Parqueadero(int id, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, Vehiculo vehiculo) {
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

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
}
