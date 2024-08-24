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
	
	@Override
	public Projet create(int id_utilisateur, ProjetForm projetForm) {
		Utilisateur administrateur = utilisateurServiceImpl.findById(id_utilisateur);
		Projet projet = new Projet(projetForm.getNom(), projetForm.getDescription(), administrateur);
		return projetRepository.save(projet);
	}

	@Override
	public ProjetUtilisateurRole invite(int id, String email) {
		Optional<Projet> optional = projetRepository.findById(id);
		if (!optional.isPresent()) throw new EntityDoesntExistsException();
		Projet projet = optional.get();
		Utilisateur utilisateur = utilisateurServiceImpl.findByEmail(email);
		ProjetUtilisateurRole projetUtilisateurRole = roleServiceImpl.creer(new ProjetUtilisateurRole(projet, utilisateur, new Role(1000, "Membre")));
		projetRepository.save(projet);
		return projetUtilisateurRole;
	}

	@Override
	public Projet findById(int id) {
	 Optional<Projet> projet = projetRepository.findById(id);
	 if (projet.isPresent()) {
		 return projet.get();
	 }
	 throw new EntityDoesntExistsException();
	}

	@Override
	public List<Utilisateur> findUsersByProjectId(int id) {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		projetRepository.findUsers(id).forEach(utilisateurs::add);
		return utilisateurs;
	}
	
	@Override
	public List<Projet> findProjetsByUtilisateurId(int id) {
		List<Projet> projets = new ArrayList<Projet>();
		projetRepository.findProjetsByUtilisateurId(id).forEach(projets::add);
		return projets;
	}
}
