package com.codesolutions.pmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codesolutions.pmt.models.Historique;
import com.codesolutions.pmt.services.HistoriqueService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HistoriqueController {
	
	@Autowired
	private HistoriqueService historiqueService;
	
	@GetMapping("/tache/{id}/historique")
	public List<Historique> findHistoriqueByTache(@PathVariable int id){
		return historiqueService.findAllByTache(id);
	}
}
