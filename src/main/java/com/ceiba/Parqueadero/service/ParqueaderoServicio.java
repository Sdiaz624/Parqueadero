package com.ceiba.parqueadero.service;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.repository.ParqueaderoRepository;
import com.ceiba.parqueadero.repository.VehiculoRepository;

@Service
public class ParqueaderoServicio {

	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	@Autowired
	private VehiculoRepository vehiculoRepository;
		
	public void ingresoVehiculo(String placa) {
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		
		if(!vehiculo.equals(null)){
			
			parqueaderoRepository.save(new Parqueadero(7,LocalDateTime.now(),null,vehiculo));
			
		}else {
			return;
		}
		
	}
	
	/**
	 * 
	 * @param placa
	 */
	public void salidaVehiculo(String placa) {
		
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		
		Parqueadero parqueadero =  parqueaderoRepository.findByVehiculo(vehiculo.getId());
		
		if(!parqueadero.equals(null)) {
			
			parqueadero.setFechaSalida(LocalDateTime.now());
			int horas = parqueadero.getFechaSalida().compareTo(parqueadero.getFechaIngreso());
			if (vehiculo.getTipoVehiculo()=='M'){
				parqueadero.setTotal(totalAPagar(horas,1000.00,8000.00));	
			}
			if (vehiculo.getTipoVehiculo()=='C') {
				parqueadero.setTotal(totalAPagar(horas,500.00,6000.00));
			}
			parqueaderoRepository.save(parqueadero);
						
		}else {
			return;
		}
		
	}
	
	/*
	 * 
	 */
	public double totalAPagar(int horas, Double valor,Double Valordia) {
		
		double total = 0;
						
		if (horas < 9 ) {
			total = horas*valor;
		}else {
			if(horas>=9 && horas<24) {
				total = 8000;
			}
			if(horas>=24) {
				total = totalAPagar(horas-24, valor,Valordia) + Valordia;
			}
		}
		
		return total;
	}
	
}