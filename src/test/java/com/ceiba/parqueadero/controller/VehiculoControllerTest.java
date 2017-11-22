package com.ceiba.parqueadero.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ceiba.parqueadero.ParqueaderoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
public class VehiculoControllerTest {

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
		public void consultarVehiculo() throws Exception {

			mockMvc.perform(get("/vehiculo/consultar/AD4K83K")).andExpect(status().isOk());
		}
		
		@Test
		@Transactional
		public void consultarVehiculoNoEfecitov() throws Exception {

			mockMvc.perform(get("/vehiculo/consultar/AD4K8Kc3")).andExpect(status().isBadRequest());
		}

	
}


