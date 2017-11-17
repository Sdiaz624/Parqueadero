package com.ceiba.Parqueadero.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceiba.Parqueadero.repository.ParqueaderoRepository;

@Service
public class ParqueaderoServicio {

	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	public void ingresoVehiculo(String placa) {
		
	}
	
	public void salidaVehiculo(String placa) {
		
	}
	
}
