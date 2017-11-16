package com.ceiba.Parqueadero.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ceiba.Parqueadero.domain.Vehiculo;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoCont {

	@PostMapping("/registrar")
	public void registrar(Vehiculo vehiculo) {
			
	}

	@GetMapping("/salida")
	public void salidaDeVehiculo(int vehiculo) {

		
	}

	@GetMapping("/consultar")
	public Vehiculo consultar(int vehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

}
