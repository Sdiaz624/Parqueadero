package com.ceiba.parqueadero.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.service.ParqueaderoServicio;

@RestController
@RequestMapping(value ="/parqueadero")
public class ParqueaderoController {

	@Autowired
	public ParqueaderoServicio parqueaderoServicio;
	    

	/**
	 * 
	 * @param placa
	 */
	@GetMapping(value ="/salida/{placa}")
	public ResponseEntity<Void> salidaDeVehiculo(@PathVariable String placa) {
		parqueaderoServicio.salidaVehiculo(placa);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param placa
	 */
	@GetMapping(value ="/ingreso/{placa}")
	public ResponseEntity<Void> ingresoDeVehiculo(@PathVariable String placa) {
		parqueaderoServicio.ingresoVehiculo(placa);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}	
	
	@GetMapping(value = "/consultar/{placa}")
	public ResponseEntity<ArrayList<Parqueadero>> consultar(@PathVariable String placa) {
		return ResponseEntity.ok().body(parqueaderoServicio.consultarParqueadero(placa));	
		
	}
	
	
}
