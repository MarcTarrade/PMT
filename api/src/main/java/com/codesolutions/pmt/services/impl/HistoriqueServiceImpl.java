package com.codesolutions.pmt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.HistoriqueRepository;
import com.codesolutions.pmt.models.Historique;
import com.codesolutions.pmt.models.Tache;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.HistoriqueService;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

	@Autowired
	private HistoriqueRepository historiqueRepository;
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	
	/**
	 * Recupere l'historique de la tache donnée
	 */
	@Override
	public List<Historique> findAllByTache(int id) {
		return historiqueRepository.findAllByIdTache(id);
	}
	
	/**
	 * Ajoute la tache à l'historique et l'utilisateur qui l'a modifié
	 */
	public void saveTacheHistorique(Tache tache, int id_user) {
		Utilisateur utilisateur = utilisateurServiceImpl.findById(id_user);
		Historique historique = new Historique(tache.getNom(), tache.getDescription(), tache.getDateEcheance(), tache.getPriorite(), utilisateur, tache, tache.getStatus());
		historiqueRepository.save(historique);
	}

}
