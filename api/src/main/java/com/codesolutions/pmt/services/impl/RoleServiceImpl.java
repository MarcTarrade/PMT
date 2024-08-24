package com.codesolutions.pmt.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.ProjetUtilisateurRoleRepository;
import com.codesolutions.pmt.dao.RoleRepository;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;
import com.codesolutions.pmt.models.Role;
import com.codesolutions.pmt.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	ProjetUtilisateurRoleRepository projetUtilisateurRoleRepository;
	@Autowired
	RoleRepository roleRepository;

	public ProjetUtilisateurRole creer(ProjetUtilisateurRole projetUtilisateurRole) {
		return projetUtilisateurRoleRepository.save(projetUtilisateurRole);
	}

	/**
	 * Recuperer tous les roles
	 */
	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		roleRepository.findAll().forEach(roles::add);
		return roles;
	}
}
