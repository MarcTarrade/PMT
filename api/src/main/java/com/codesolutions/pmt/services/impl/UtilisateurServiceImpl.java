package com.codesolutions.pmt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.ProjetRepository;
import com.codesolutions.pmt.dao.UtilisateurRepository;
import com.codesolutions.pmt.exceptions.EntityDoesntExistsException;
import com.codesolutions.pmt.models.LoginForm;
import com.codesolutions.pmt.models.Projet;
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

	public Utilisateur findById(int id) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
		if (utilisateur.isPresent()) {
			return utilisateur.get();
		}
		throw new EntityDoesntExistsException();
	}

	public Utilisateur findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	

}
