package com.ceiba.parqueadero.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.service.VehiculoServicio;

@RestController
@RequestMapping(value ="/vehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoServicio vehiculoServicio;
			
	@PostMapping(value = "/registrar")
	public ResponseEntity<Void> registrar(@RequestBody Vehiculo vehiculo) {
		vehiculoServicio.registrar(vehiculo);
		return null	;
	}

/*	@GetMapping(value = "/consultar/{vehiculo}")
	public ResponseEntity<Vehiculo> consultar(@PathVariable int vehiculo) {
		return ResponseEntity.ok().body(vehiculoServicio.consultar(vehiculo));	
	}*/

}
