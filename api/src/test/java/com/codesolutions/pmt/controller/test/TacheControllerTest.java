package com.codesolutions.pmt.controller.test;

import java.time.LocalDate;

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

import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Tache;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TacheControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Order(value = 1)
	@Test
	void testerFindAllByProjet() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projet/1000/taches");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Connexion/Inscription Front"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].utilisateur.nom").value("Paul"));
	}
	
	@Test
	void testerFindAllById() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tache/1000");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Connexion/Inscription Front"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.utilisateur.nom").value("Paul"));
	}
	@Test
	void testerCreer() throws Exception {
		Tache tache = new Tache("Test Unitaire", "Test unitaire", LocalDate.now(), "BASSE", "Creé");
		String tacheJson = objectMapper.writeValueAsString(tache);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/projet/2000/tache")
		.contentType(MediaType.APPLICATION_JSON)
		.content(tacheJson);
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(tache.getNom()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.description").value(tache.getDescription()));
	}
	@Test
	void testerPartialUpdate() throws Exception {
		Tache tache = new Tache("Connexion/Inscription BackEnd");
		String tacheJson = objectMapper.writeValueAsString(tache);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/tache/2000")
		.header("id_user", 1000)
		.contentType(MediaType.APPLICATION_JSON)
		.content(tacheJson);
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(tache.getNom()));
	}
	@Test
	void testerAssigner() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/user/1000/tache/3000");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Creer projet Front"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.utilisateur.nom").value("Pierre"));
	}
	
}
