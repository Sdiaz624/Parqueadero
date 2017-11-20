package com.ceiba.parqueadero.service;
import org.junit.Before;
import org.junit.Test;
import com.ceiba.parqueadero.service.ParqueaderoServicio;
import junit.framework.Assert;


public class ParqueaderoServicioTest {

	ParqueaderoServicio parqueaderoServicio;
	

	@Before
	public void setup(){
		parqueaderoServicio =  new ParqueaderoServicio();
	}
		
	@Test
	public void notifyTest() {
	
		//arrange
		int horas = 50;
		double valor =1000;
		double valorDia = 8000;
		
		//act
		double total = parqueaderoServicio.totalAPagar(horas,valor,valorDia);
		//Assert
		Assert.assertNotNull(total);		
		System.out.println(total);
	}
	
}
