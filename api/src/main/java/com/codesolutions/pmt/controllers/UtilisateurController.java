package com.codesolutions.pmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.exceptions.CannotConnectException;
import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.UtilisateurService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping("/connexion")
	public Utilisateur connexion(@RequestBody LoginForm loginForm ) {
		Utilisateur utilisateur = utilisateurService.connect(loginForm);
		if (utilisateur == null) {
			throw new CannotConnectException();
		}
		return utilisateur;
	}
	
	@PostMapping("user")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.create(utilisateur);
	}

}
