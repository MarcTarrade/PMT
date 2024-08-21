package com.codesolutions.pmt.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	@Query(value="SELECT * FROM utilisateur WHERE email=?1 AND password=?2", nativeQuery = true)
	Utilisateur connect(String email, String password);
}
