package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.models.Role;

public interface RoleService {

	public ProjetUtilisateurRole creer(ProjetUtilisateurRole projetUtilisateurRole);

	public List<Role> findAll();
	
	
}
