package com.codesolutions.pmt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.UtilisateurRepository;
import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur connect(LoginForm loginForm) {
		return utilisateurRepository.connect(loginForm.getEmail(), loginForm.getPassword());
	}

	@Override
	public Utilisateur create(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

}
