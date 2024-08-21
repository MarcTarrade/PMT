package com.codesolutions.pmt.services;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetForm;

public interface ProjetService {

	Projet create(int id_utilisateur, ProjetForm projetForm);
	
}
