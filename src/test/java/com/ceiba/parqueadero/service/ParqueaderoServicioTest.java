package com.ceiba.parqueadero.service;
import org.junit.Before;
import org.junit.Test;
import com.ceiba.parqueadero.domain.Parqueadero;
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
		Assert.assertEquals(8000.0, parqueaderoServicio.SalidaDeCarro(parqueadero, horas));
	}
	
	
}
