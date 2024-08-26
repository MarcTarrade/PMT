package com.codesolutions.pmt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.ProjetRepository;
import com.codesolutions.pmt.exceptions.EntityDoesntExistsException;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetForm;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.models.Role;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	@Autowired
	private RoleServiceImpl roleServiceImpl;
	
	/**
	 * Creer un projet avec l'id de l'utilisateur et un objet projetForm qui correspond au nom et a la description du projet
	 */
	@Override
	public Projet create(int id_utilisateur, ProjetForm projetForm) {
		Utilisateur administrateur = utilisateurServiceImpl.findById(id_utilisateur);
		Projet projet = new Projet(projetForm.getNom(), projetForm.getDescription(), administrateur);
		return projetRepository.save(projet);
	}
	/**
	 * Invite un utilisateur pour un projet donné
	 */

	@Override
	public ProjetUtilisateurRole invite(int id, String email) {
		Optional<Projet> optional = projetRepository.findById(id);
		if (!optional.isPresent()) throw new EntityDoesntExistsException();
		Projet projet = optional.get();
		//Recupere l'utilsateur grace a son email
		Utilisateur utilisateur = utilisateurServiceImpl.findByEmail(email);
		ProjetUtilisateurRole projetUtilisateurRole = roleServiceImpl.creer(new ProjetUtilisateurRole(projet, utilisateur, new Role(1000, "Membre")));
		projetRepository.save(projet);
		return projetUtilisateurRole;
	}

	/**
	 * Recuperer les infos d'un projet grace a son id
	 */
	@Override
	public Projet findById(int id) {
	 Optional<Projet> projet = projetRepository.findById(id);
	 if (projet.isPresent()) {
		 return projet.get();
	 }
	 throw new EntityDoesntExistsException();
	}

	
	/**
	 * Recupere tous les projets pour un utilisateur 
	 */
	@Override
	public List<Projet> findProjetsByUtilisateurId(int id) {
		List<Projet> projets = new ArrayList<Projet>();
		projetRepository.findProjetsByUtilisateurId(id).forEach(projets::add);
		return projets;
	}
}
