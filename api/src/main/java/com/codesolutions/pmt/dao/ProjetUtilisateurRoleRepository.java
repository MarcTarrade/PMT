package com.codesolutions.pmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.ProjetUtilisateurRole;

public interface ProjetUtilisateurRoleRepository extends CrudRepository<ProjetUtilisateurRole, Integer>{


}
