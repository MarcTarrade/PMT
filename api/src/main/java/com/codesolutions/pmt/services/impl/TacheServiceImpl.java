package com.codesolutions.pmt.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolutions.pmt.dao.TacheRepository;
import com.codesolutions.pmt.exceptions.EntityDoesntExistsException;
import com.codesolutions.pmt.models.Historique;
import com.codesolutions.pmt.models.Projet;
import com.codesolutions.pmt.models.Tache;
import com.codesolutions.pmt.models.Utilisateur;
import com.codesolutions.pmt.services.TacheService;

@Service
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheRepository tacheRepository;
	@Autowired
	private ProjetServiceImpl projetServiceImpl;
	@Autowired
	private UtilisateurServiceImpl utilisateurServiceImpl;
	@Autowired
	private HistoriqueServiceImpl historiqueServiceImpl;
	
	/**
	 * Creer une nouvelle tache
	 */
	@Override
	public Tache creer(int id_projet, Tache tache) {
		Projet projet = projetServiceImpl.findById(id_projet);
		projet.getTaches().add(tache);
		tache.setUtilisateur(null);
		return tacheRepository.save(tache);
	}

	/**
	 * Assigne une tache à un utilisateur donné
	 */
	@Override
	public Tache assigner(int id_user, int id_tache) {
		Utilisateur utilisateur = utilisateurServiceImpl.findById(id_user);
		Tache tache = findById(id_tache);
		tache.setUtilisateur(utilisateur);
		return tacheRepository.save(tache);
	}

	/**
	 * Recupere les details d'un tache
	 */
	@Override
	public Tache findById(int id) {
		Optional<Tache> optional = tacheRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityDoesntExistsException();
	}

	// Met à jour une tache donnée
	@Override
	public Tache partialUpdate(int id, Tache newTache, int id_user) {
		Tache tacheExistante = findById(id);
		historiqueServiceImpl.saveTacheHistorique(tacheExistante, id_user);
		if(newTache.getNom() != null) {
			tacheExistante.setNom(newTache.getNom());
		}
		if(newTache.getDescription() != null) {
			tacheExistante.setDescription(newTache.getDescription());
		}
		if(newTache.getDateEcheance() != null) {
			tacheExistante.setDateEcheance(newTache.getDateEcheance());
		}
		if(newTache.getPriorite() != null) {
			tacheExistante.setPriorite(newTache.getPriorite());
		}
		if(newTache.getStatus() != null) {
			tacheExistante.setStatus(newTache.getStatus());
		}
		return tacheRepository.save(tacheExistante);
	}

	// Recupere toutes les taches pour un projet donné
	@Override
	public List<Tache> findAllByProjet(int id_projet) {
		return tacheRepository.findAllByProjet(id_projet);
	}

	


}
