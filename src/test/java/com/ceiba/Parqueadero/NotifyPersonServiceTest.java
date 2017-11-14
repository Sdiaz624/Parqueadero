package com.ceiba.Parqueadero;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.service.EmailService;
import co.ceiba.service.NotifyPersonService;
import junit.framework.Assert;

public class NotifyPersonServiceTest {

	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup() {
		emailService = new EmailService();
		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest() {
		
		
		//arrange
		Person person = new PersonTestDataBuilder().build();
		//act
		String message = notifyPersonService.notify(person);
		//Assert
		Assert.assertNotNull(message);		
		System.out.println(message);
	}
	
	
}
