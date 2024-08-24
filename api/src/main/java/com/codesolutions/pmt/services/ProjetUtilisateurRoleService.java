package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.ProjetUtilisateurRole;

public interface ProjetUtilisateurRoleService {

	List<ProjetUtilisateurRole> updateUtilisateursRole(int id, List<ProjetUtilisateurRole> utilisateursRole);
	
}
