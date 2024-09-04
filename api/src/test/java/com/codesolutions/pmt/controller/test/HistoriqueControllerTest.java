package com.codesolutions.pmt.controller.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class HistoriqueControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Order(value = 1)
	@Test
	void testerFindHistoriqueByTache() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tache/1000/historique");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Connexion Front"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].utilisateur_modificateur.nom").value("Paul"));
	}
}
