package com.ceiba.parqueadero.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.service.ParqueaderoServicio;


public class ParqueaderoServicioTest {
	
	
	ParqueaderoServicio parqueaderoServicio;
	
	@Before
	public void setup(){
		parqueaderoServicio =  new ParqueaderoServicio();
	
	}
		
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
		Parqueadero parqueadero = new Parqueadero();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCilindraje(600);
		int horas = 30;
		//act
		int Salida = (int)parqueaderoServicio.salidaDeMoto(vehiculo,parqueadero, horas);
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
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setId(25);
		parqueadero.setTotal(450.0);
		parqueadero.setFechaIngreso(Calendar.getInstance());
		parqueadero.setFechaSalida(Calendar.getInstance());
		
		//Assert
		assertFalse(parqueaderoServicio.parqueaderoEsNulo(parqueadero));
	}
	
	@Test
	public void horasACobrar() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setFechaIngreso(Calendar.getInstance());
		parqueadero.setFechaSalida(Calendar.getInstance());
		
		//Assert
		assertEquals(0,(parqueaderoServicio.horasACobrar(parqueadero)));
	}
	
	@Test
	public void diferenciaEnMilisegundos() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setFechaIngreso(Calendar.getInstance());
		parqueadero.setFechaSalida(Calendar.getInstance());
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
		Vehiculo vehiculo = new Vehiculo();
		//Assert
		assertFalse(parqueaderoServicio.vehiculoEsNulo(vehiculo));		
	}
	
}
