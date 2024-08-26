package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.Utilisateur;

public interface UtilisateurService {

	Utilisateur connect(LoginForm loginForm);

	Utilisateur create(Utilisateur utilisateur);

	Utilisateur findById(int id);

	List<Utilisateur> findUsersByProjet(int id);

	
}
