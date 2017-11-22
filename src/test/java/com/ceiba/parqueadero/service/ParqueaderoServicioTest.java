package com.ceiba.parqueadero.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.ParqueaderoApplication;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.ParqueaderoTestBuilder;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.domain.VehiculoTestBuilder;
import com.ceiba.parqueadero.repository.ParqueaderoRepository;
import com.ceiba.parqueadero.repository.VehiculoRepository;
import com.ceiba.parqueadero.service.ParqueaderoServicio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class ParqueaderoServicioTest {
	
	@Autowired
	ParqueaderoServicio parqueaderoServicio;
	@Autowired
	VehiculoRepository vehculoRepository;
	@Autowired
	VehiculoServicio vehiculoServicio;
			
	@Test
	public void totalAPagar() {
	
		//arrange
		int horas = 50;
		double valor =1000;
		double valorDia = 8000;
		//act
		double total = parqueaderoServicio.totalAPagar(horas,valor,valorDia);
		//Assert
		assertNotNull(total);		
	}
	
	@Test
	public void salidaDeCarro() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		int horas = 10;
		//act
		int Salida = (int)  parqueaderoServicio.salidaDeCarro(parqueadero, horas);
		//Assert
		assertEquals(8000,Salida);
	}
	
	@Test
	public void salidaDeMoto() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestBuilder().buildSalida();
		int horas = 30;
		//act
		int Salida = (int)parqueaderoServicio.salidaDeMoto(parqueadero.getVehiculo(),parqueadero, horas);
		//Assert		
		assertEquals(14000,Salida);
		
	}
	
	@Test
	public void parqueaderoEsNulo() {
		//Arrange
		Parqueadero parqueadero = null;
		//Assert
		assertTrue(parqueaderoServicio.parqueaderoEsNulo(parqueadero));
	}
	
	@Test
	public void parqueaderoNoEsNulo() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestBuilder().buildSalida();
		//Assert
		assertFalse(parqueaderoServicio.parqueaderoEsNulo(parqueadero));
	}
	
	@Test
	public void horasACobrar() {
		//Arrange
		Parqueadero parqueadero =new ParqueaderoTestBuilder().buildSalida();
		//Assert
		assertEquals(0,(parqueaderoServicio.horasACobrar(parqueadero)));
	}
	
	@Test
	public void diferenciaEnMilisegundos() {
		//Arrange
		Parqueadero parqueadero = new ParqueaderoTestBuilder().buildSalida();
		//Assert
		assertNotNull(parqueaderoServicio.diferenciaDeFechasEnMilisegundos(parqueadero));
	}
	
	@Test
	public void vehiculoEsNulo() {
		//Arrange
		Vehiculo vehiculo = null;
		//Assert
		assertTrue(parqueaderoServicio.vehiculoEsNulo(vehiculo));		
	}
		
	@Test
	public void vehiculoNOEsNulo() {
		//Arrange
		Vehiculo vehiculo =new VehiculoTestBuilder().buildCarro();
		//Assert
		assertFalse(parqueaderoServicio.vehiculoEsNulo(vehiculo));		
	}
	
	@Test
	public void NoHayEspacioParaCarro() {
		//Assert		
		assertFalse(parqueaderoServicio.espacioEnElParqueadero('C',20));		
	}
	
	@Test
	public void NoHayEspacioParaMoto() {
		//Assert		
		assertFalse(parqueaderoServicio.espacioEnElParqueadero('M',10));		
	}
	
	@Test
	public void EspacioParaCarro() {
		//Assert		
		assertTrue(parqueaderoServicio.espacioEnElParqueadero('C',18));		
	}
	
	@Test
	public void EspacioParaMoto() {
		//Assert		
		assertTrue(parqueaderoServicio.espacioEnElParqueadero('M',9));		
	}
	
	@Test
	public void ingresarVehiculoNoExistente() {
		//Arrange
		Vehiculo vehiculo = new VehiculoTestBuilder().buildWithPlaca("ASDFG");
		//Assert
		assertNull(parqueaderoServicio.ingresoVehiculo(vehiculo.getPlaca()));
	}
	
	@Test
	public void ingresarVehiculoExistente() {
		//Arrenge
		Vehiculo vehiculo = new VehiculoTestBuilder().buildWithPlaca("AD4K83K");
		//vehculoRepository.save(vehiculo);
		//Assert
		assertNotNull(parqueaderoServicio.ingresoVehiculo(vehiculo.getPlaca()));
		parqueaderoServicio.salidaVehiculo(vehiculo.getPlaca());
	}
	
}
