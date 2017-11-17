package com.ceiba.parqueadero;
import org.junit.Test;
import com.ceiba.parqueadero.service.ParqueaderoServicio;
import junit.framework.Assert;

public class ParqueaderoApplicationTests {

	@Test
	public void notifyTest() {
		
		
		//arrange
		int horas = 50;
		double valor =1000;
		double valorDia = 8000;
		ParqueaderoServicio parqueaderoServicio =  new ParqueaderoServicio();
		//act
		double total = parqueaderoServicio.totalAPagar(horas,valor,valorDia);
		//Assert
		Assert.assertNotNull(total);		
		System.out.println(total);
	}

}
