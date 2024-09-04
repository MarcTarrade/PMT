package com.codesolutions.pmt.controller.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.codesolutions.pmt.models.ProjetForm;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class ProjetControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Order(value = 1)
	@Test
	void testerFindProjetsByUserId() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/1000/projets");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0].nom").value("PMT"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0].administrateur.email").value("pierre@pmt.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.[1].nom").value("Ikea"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.[1].administrateur.email").value("paul@pmt.com"));
	}
	@Test
	void testercreer() throws Exception {
		ProjetForm newProjet = new ProjetForm("Haribo", "Projet pour haribo");
		String projetJson = objectMapper.writeValueAsString(newProjet);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/1000/projet")
		.contentType(MediaType.APPLICATION_JSON)
		.content(projetJson);
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(newProjet.getNom()));
		
	}
	@Test
	void testerInvite() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projet/1000/invite")
		.content("pierre@pmt.com");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.utilisateur.email").value("pierre@pmt.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.role.nom").value("Membre"));
		
	}
	@Test
	void testerFindById() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projet/1000");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("PMT"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.administrateur.email").value("pierre@pmt.com"));
	}

	
	
}
