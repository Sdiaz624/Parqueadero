package com.ceiba.Parqueadero.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.Parqueadero.domain.Vehiculo;
import com.ceiba.Parqueadero.repository.VehiculoRepository;

@Service
public class VehiculoServicio {
	
	@Autowired
	private VehiculoRepository vehiculoRespository;
	
	public void registrar(Vehiculo vehiculo) {
	
	}
	
	public void salidaVehiculo(int vehiculo) {
		
	}
	
	public Vehiculo consultar(int vehiculo) {
		return null;
	}
	
}
