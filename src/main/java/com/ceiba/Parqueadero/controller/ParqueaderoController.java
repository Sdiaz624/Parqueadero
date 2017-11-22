package com.ceiba.parqueadero.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.domain.Parqueadero;
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
	public ResponseEntity<Parqueadero> salidaDeVehiculo(@PathVariable String placa) {
		
		Parqueadero parqueadero = parqueaderoServicio.salidaVehiculo(placa);
		
		if (parqueaderoServicio.parqueaderoEsNulo(parqueadero)) {
			return ResponseEntity.badRequest().header("Error", "10" ).body(parqueadero);
		}else {
			return ResponseEntity.ok().body(parqueadero);
		}
		
	}
	
	/**
	 * 
	 * @param placa
	 */
	@GetMapping(value ="/ingreso/{placa}")
	public ResponseEntity<Parqueadero> ingresoDeVehiculo(@PathVariable String placa) {
				
		Parqueadero parqueadero = parqueaderoServicio.ingresoVehiculo(placa);
		
		if (parqueaderoServicio.parqueaderoEsNulo(parqueadero)) {
			return ResponseEntity.badRequest().header("Error", "10" ).body(parqueadero);
		}else {
			return ResponseEntity.ok().body(parqueadero);
		}
		
	}	
	
	@GetMapping(value = "/consultar/{placa}")
	public ResponseEntity<ArrayList<Parqueadero>> consultar(@PathVariable String placa) {
		return ResponseEntity.ok().body(parqueaderoServicio.consultarParqueadero(placa));	
		
	}
	
	
}
