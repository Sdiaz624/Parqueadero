package com.ceiba.parqueadero.controller;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ceiba.parqueadero.ParqueaderoApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class ParqueaderoControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private ParqueaderoController parqueaderoController;
	@Autowired
	private PageableHandlerMethodArgumentResolver pageableArgumentResolver;
	@Autowired
	private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	public static FormattingConversionService createFormattingConversionService() {
		DefaultFormattingConversionService dfcs = new DefaultFormattingConversionService();
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setUseIsoFormat(true);
		registrar.registerFormatters(dfcs);
		return dfcs;
	}

	@Before
	public void beforeTest() {
		mockMvc = MockMvcBuilders.standaloneSetup(parqueaderoController)
				.setCustomArgumentResolvers(pageableArgumentResolver)
				.setConversionService(createFormattingConversionService()).setMessageConverters(jacksonMessageConverter)
				.build();
	}

	@Test
	@Transactional
	public void SimularEntrada() throws Exception {
		
		mockMvc.perform(get("/parqueadero/ingreso/AD4K83K")).andExpect(status().isOk());
		mockMvc.perform(get("/parqueadero/salida/AD4K83K")).andExpect(status().isOk());
	}

}
