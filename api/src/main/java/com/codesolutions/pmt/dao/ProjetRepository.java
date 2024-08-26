package com.codesolutions.pmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.Utilisateur;

public interface ProjetRepository extends CrudRepository<Projet, Integer>{

	@Query(value="SELECT DISTINCT p.* FROM projet_utilisateur_role u RIGHT JOIN projet p ON u.projet_id = p.id WHERE utilisateur_id = ?1 OR p.id_administrateur = ?1", nativeQuery = true)
	List<Projet> findProjetsByUtilisateurId(int id);
}
