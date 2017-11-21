package com.ceiba.parqueadero.service;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.domain.VehiculoTestBuilder;

public class VehiculoServicioTest {

	VehiculoServicio vehiculoServicio;
	
	@Before
	public void setup(){
		vehiculoServicio =  new VehiculoServicio();
	
	}
	
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
	
}
