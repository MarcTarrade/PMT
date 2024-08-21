package com.codesolutions.pmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.ProjetRepository;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetForm;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	
	@Override
	public Projet create(int id_utilisateur, ProjetForm projetForm) {
		Utilisateur administrateur = utilisateurServiceImpl.findById(id_utilisateur);
		Projet projet = new Projet(projetForm.getNom(), projetForm.getDescription(), administrateur);
		return projetRepository.save(projet);
	}
	
}
