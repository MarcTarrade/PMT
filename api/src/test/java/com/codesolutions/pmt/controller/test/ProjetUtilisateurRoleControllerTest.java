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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.codesolutions.pmt.models.ProjetForm;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@AutoConfigureMockMvc
public class ProjetUtilisateurRoleControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testerUpdateUtilisateursRole() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/projet/1000/roles")
		.contentType(MediaType.APPLICATION_JSON)
		.content("[{\"id\": 1000,\"utilisateur\": {\"id\": 2000,\"nom\": \"Paul\",\"email\": \"paul@pmt.com\",\"password\": 1234},\"role\": {\"id\": 1000,\"nom\": \"Membre\"}}]");
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].utilisateur.nom").value("Paul"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].role.nom").value("Membre"));
		
	}
}
