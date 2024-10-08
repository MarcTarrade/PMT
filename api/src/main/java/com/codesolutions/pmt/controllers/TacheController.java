package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.models.Historique;
import com.codesolutions.pmt.models.Tache;
import com.codesolutions.pmt.services.HistoriqueService;
import com.codesolutions.pmt.services.TacheService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TacheController {
	
	@Autowired
	private TacheService tacheService;

	/**
	 * 
	 * @param id_projet int
	 * @param tache Tache
	 * @return Tache
	 */
	@PostMapping("/projet/{id_projet}/tache")
	public Tache creer(@PathVariable int id_projet, @RequestBody Tache tache) {
		return tacheService.creer(id_projet, tache);
	}
	
	/**
	 * 
	 * @param id_user int
	 * @param id_tache int
	 * @return Tache
	 */
	@PutMapping("user/{id_user}/tache/{id_tache}")
	public Tache assigner(@PathVariable int id_user, @PathVariable int id_tache) {
		return tacheService.assigner(id_user, id_tache);
	}
	
	/**
	 * 
	 * @param id int
	 * @return Tache
	 */
	@GetMapping("tache/{id}")
	public Tache findById(@PathVariable int id) {
		return tacheService.findById(id);
	}
	
	/**
	 * 
	 * @param id int 
	 * @param tache Tache
	 * @param id_user int
	 * @return Tache
	 */
	@PatchMapping("tache/{id}")
	public Tache partialUpdate(@PathVariable int id, @RequestBody Tache tache, @RequestHeader int id_user) {
		return tacheService.partialUpdate(id, tache, id_user);
	}
	
	/**
	 * 
	 * @param id_projet int
	 * @return List<Tache>
	 */
	@GetMapping("/projet/{id_projet}/taches")
	public List<Tache> findAllByProjet(@PathVariable int id_projet) {
		return tacheService.findAllByProjet(id_projet);
	}
	

	
}
