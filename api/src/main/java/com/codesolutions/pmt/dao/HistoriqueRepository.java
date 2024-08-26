package com.codesolutions.pmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Historique;

public interface HistoriqueRepository extends CrudRepository<Historique, Integer> {
	
	@Query(value = "SELECT * FROM historique WHERE id_tache = ?1", nativeQuery = true)
	List<Historique> findAllByIdTache(int id);
}
