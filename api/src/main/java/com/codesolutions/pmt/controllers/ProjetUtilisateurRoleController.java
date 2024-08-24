package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.services.ProjetUtilisateurRoleService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProjetUtilisateurRoleController {
	@Autowired
	private ProjetUtilisateurRoleService projetUtilisateurRoleService;
	/**
	 * Met à jour les roles de tous les utilisateurs pour un projet donné
	 * @param id
	 * @param utilisateursRole
	 * @return List<ProjetUtilisateurRole>
	 */
	@PutMapping("/projet/{id}/roles")
	public List<ProjetUtilisateurRole> updateUstilisateursRole(@PathVariable int id, @RequestBody List<ProjetUtilisateurRole> utilisateursRole) {
		return projetUtilisateurRoleService.updateUtilisateursRole(id, utilisateursRole);
	}
}
