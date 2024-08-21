package com.codesolutions.pmt.services;

import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Utilisateur;

public interface UtilisateurService {

	Utilisateur connect(LoginForm loginForm);

	Utilisateur create(Utilisateur utilisateur);

	
}
