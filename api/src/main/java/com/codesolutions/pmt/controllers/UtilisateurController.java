package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.exceptions.CannotConnectException;
import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Projet;
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
	
	@GetMapping("user/{id}")
	public Utilisateur findById(@PathVariable int id) {
		return utilisateurService.findById(id);
	}
}
