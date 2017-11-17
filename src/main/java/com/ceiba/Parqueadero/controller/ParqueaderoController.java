package com.ceiba.Parqueadero.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.Parqueadero.service.ParqueaderoServicio;

@RestController
@RequestMapping(value ="/parqueadero")
public class ParqueaderoController {

	@Autowired
	private ParqueaderoServicio parqueaderoServicio;
	
	@GetMapping(value ="/salida/{vehiculo}")
	public void salidaDeVehiculo(@PathVariable String placa) {
		parqueaderoServicio.salidaVehiculo(placa);
	}
	
	@GetMapping(value ="/ingreso/{vehiculo}")
	public void ingresoDeVehiculo(@PathVariable String placa) {
		parqueaderoServicio.ingresoVehiculo(placa);
	}	
	
	
}
