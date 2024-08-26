package com.codesolutions.pmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codesolutions.pmt.models.Tache;

public interface TacheRepository extends CrudRepository<Tache, Integer>{
	@Query(value="SELECT t.* FROM tache t JOIN projet_taches p ON t.id = p.taches_id WHERE p.projet_id = ?1", nativeQuery = true)
	List<Tache> findAllByProjet(int id_projet);
}
