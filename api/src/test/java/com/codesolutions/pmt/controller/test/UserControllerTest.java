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

import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testerConnexion() throws Exception {
		LoginForm loginForm = new LoginForm("pierre@pmt.com", "1234");
		String loginJson = objectMapper.writeValueAsString(loginForm);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/connexion")
		.contentType(MediaType.APPLICATION_JSON)
		.content(loginJson);
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Pierre"));
	}
	
	@Test
	void testerCreer() throws Exception {
		Utilisateur newUtilisateur = new Utilisateur("Jean", "jean@pmt.com", "1234");
		String utilisateurJson = objectMapper.writeValueAsString(newUtilisateur);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
		.contentType(MediaType.APPLICATION_JSON)
		.content(utilisateurJson);
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Jean"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("jean@pmt.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.password").value("1234"));
	}
	
	@Test
	void testerFindUsersByProjetId() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projet/1000/users");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Paul"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("paul@pmt.com"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].nom").value("Jacques"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("jacques@pmt.com"));
	}
	
}
