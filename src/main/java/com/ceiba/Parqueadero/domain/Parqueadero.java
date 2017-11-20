package com.ceiba.parqueadero.domain;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

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
	private Calendar fechaIngreso;
	
	@Column(name="FECHASALIDA")
	private Calendar fechaSalida;
	
	@Column(name="TOTAL")
	private double total;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICULO_ID")
	private Vehiculo vehiculo;
			
	public Parqueadero() {
	}

	public Parqueadero(int id, Calendar fechaIngreso, Calendar fechaSalida, Vehiculo vehiculo) {
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
	}
	
	public Parqueadero(Calendar fechaIngreso, Vehiculo vehiculo) {
		this.fechaIngreso = fechaIngreso;
		this.vehiculo = vehiculo;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
}
