package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetForm;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.models.Utilisateur;

public interface ProjetService {

	Projet create(int id_utilisateur, ProjetForm projetForm);

	ProjetUtilisateurRole invite(int id, String email);

	Projet findById(int id);

	List<Projet> findProjetsByUtilisateurId(int id);
	
}
