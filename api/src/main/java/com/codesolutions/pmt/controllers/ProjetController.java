package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetForm;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.ProjetService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProjetController {
	
	@Autowired
	private ProjetService projetService;
	
	@PostMapping("user/{id_utilisateur}/projet")
	public Projet create(@PathVariable("id_utilisateur") int id_utilisateur, @RequestBody ProjetForm projetForm) {
		return projetService.create(id_utilisateur, projetForm);
	}
	
	@PostMapping("projet/{id}/invite")
	public ProjetUtilisateurRole invite(@PathVariable int id, @RequestBody String email) {
		return projetService.invite(id, email);
	}
	
	@GetMapping("projet/{id}")
	public Projet findById(@PathVariable int id) {
		return projetService.findById(id);
	}

	@GetMapping("user/{id}/projets")
	public List<Projet> findProjetsByUserId(@PathVariable int id){
		return projetService.findProjetsByUtilisateurId(id);
	}
}
