package com.ceiba.parqueadero.service;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import com.ceiba.parqueadero.domain.Parqueadero;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.service.ParqueaderoServicio;
import junit.framework.Assert;

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
		Assert.assertNotNull(total);		
	}
	
	@Test
	public void salidaDeCarro() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		int horas = 10;
		//act
		//Assert
		Assert.assertEquals(8000.0, parqueaderoServicio.salidaDeCarro(parqueadero, horas));
	}
	
	@Test
	public void salidaDeMarro() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCilindraje(600);
		int horas = 30;
		//act
		//Assert
		Assert.assertEquals(14000.0, parqueaderoServicio.salidaDeMoto(vehiculo,parqueadero, horas));
	}
	
	@Test
	public void parqueaderoEsNulo() {
		//Arrange
		Parqueadero parqueadero = null;
		//Assert
		Assert.assertTrue(parqueaderoServicio.parqueaderoEsNulo(parqueadero));
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
		Assert.assertFalse(parqueaderoServicio.parqueaderoEsNulo(parqueadero));
	}
	
	@Test
	public void horasACobrar() {
		//Arrange
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setId(25);
		parqueadero.setTotal(450.0);
		parqueadero.setFechaIngreso(Calendar.getInstance());
		parqueadero.setFechaSalida(Calendar.getInstance());
		
		//Assert
		Assert.assertEquals(0,(parqueaderoServicio.horasACobrar(parqueadero)));
	}
	
	
}
