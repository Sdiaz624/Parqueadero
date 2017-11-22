package com.ceiba.parqueadero.controller;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ceiba.parqueadero.ParqueaderoApplication;
import com.ceiba.parqueadero.domain.Vehiculo;
import com.ceiba.parqueadero.domain.VehiculoTestBuilder;
import com.ceiba.parqueadero.util.Util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class ParqueaderoControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private VehiculoController vehiculoController;
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
		mockMvc = MockMvcBuilders.standaloneSetup(vehiculoController)
				.setCustomArgumentResolvers(pageableArgumentResolver)
				.setConversionService(createFormattingConversionService()).setMessageConverters(jacksonMessageConverter)
				.build();
	}

	@Test
	@Transactional
	public void createVehiculoWithExistingId() throws Exception {

		mockMvc.perform(get("/vehiculo/consultar/AD4K8K3")).andExpect(status().isOk());
	}

}
