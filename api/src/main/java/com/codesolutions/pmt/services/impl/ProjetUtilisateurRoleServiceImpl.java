package com.codesolutions.pmt.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.ProjetUtilisateurRoleRepository;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.services.ProjetUtilisateurRoleService;

@Service
public class ProjetUtilisateurRoleServiceImpl implements ProjetUtilisateurRoleService{

	@Autowired
	private ProjetUtilisateurRoleRepository projetUtilisateurRoleRepository;
	@Autowired
	private ProjetServiceImpl projetServiceImpl;
	
	/**
	 * Modifie les roles de tous les utilisateurs pour un projet donné
	 */
	@Override
	public List<ProjetUtilisateurRole> updateUtilisateursRole(int id, List<ProjetUtilisateurRole> utilisateursRole) {
		List<ProjetUtilisateurRole> results = new ArrayList<ProjetUtilisateurRole>();
		//Recupere le projet
		Projet projet = projetServiceImpl.findById(id);
		// Pour chaque lien entre utilisateur le role est mis à jour
		for (ProjetUtilisateurRole projetUtilisateurRole : utilisateursRole) {
			projetUtilisateurRole.setProjet(projet);
			results.add(projetUtilisateurRoleRepository.save(projetUtilisateurRole));
		}
		return results;
	}
	
}
