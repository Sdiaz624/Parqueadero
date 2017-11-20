package com.ceiba.parqueadero.domain;
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
	
	@Column(name="FECHASALIDA")
	private LocalDateTime fechaSalida;
	
	@Column(name="TOTAL")
	private double total;
		
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
	
	public Parqueadero(LocalDateTime fechaIngreso, Vehiculo vehiculo) {
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
