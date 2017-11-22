package com.ceiba.parqueadero.service;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.ParqueaderoApplication;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.domain.VehiculoTestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class VehiculoServicioTest {

	@Autowired
	VehiculoServicio vehiculoServicio;
	
	@Test
	public void vehiculoEsNulo() {
		//Arrange
		Vehiculo vehiculo = null;
		//Assert
		assertTrue(vehiculoServicio.vehiculoEsNulo(vehiculo));		
	}
		
	@Test
	public void vehiculoNOEsNulo() {
		//Arrange
		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();
		//Assert
		assertFalse(vehiculoServicio.vehiculoEsNulo(vehiculo));		
	}
	
	@Test 
	public void ingresoVehiculo() {
		
		//Arrage
		Vehiculo carro = new VehiculoTestBuilder().buildCarro();
		//Assert
		assertNotNull(vehiculoServicio.registrar(carro));
	}
	@Test 
	public void ingresoVehiculoNuevo() {
		
		//Arrage
		Vehiculo carro = new VehiculoTestBuilder().buildWithPlaca("KOIL");
		//Assert
		assertNotNull(vehiculoServicio.registrar(carro));
	}
	@Test 
	public void consultarPorPlaca() {
		
		//Arrage
		Vehiculo carro = new VehiculoTestBuilder().buildCarro();
		//Assert
		assertNotNull(vehiculoServicio.consultar(carro.getPlaca()));
	}
	@Test 
	public void consultarPorPlacaNoExistente() {
		
		//Assert
		assertNull(vehiculoServicio.consultar("QWERTY"));
	}
	
	
	
	
}
