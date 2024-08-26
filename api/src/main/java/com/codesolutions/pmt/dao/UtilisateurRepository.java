package com.codesolutions.pmt.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	@Query(value="SELECT * FROM utilisateur WHERE email=?1 AND password=?2", nativeQuery = true)
	Utilisateur connect(String email, String password);

	Utilisateur findByEmail(String email);
	
	@Query(value="SELECT u.* FROM utilisateur u JOIN projet_utilisateur_role r ON u.id = r.utilisateur_id WHERE r.projet_id = ?1", nativeQuery= true)
	List<Utilisateur> findUsersByProjet(int id);
}
