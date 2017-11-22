package com.ceiba.parqueadero.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	
}
