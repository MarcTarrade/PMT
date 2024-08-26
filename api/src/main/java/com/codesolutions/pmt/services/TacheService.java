package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.Tache;

public interface TacheService {

	Tache creer(int id_projet, Tache tache);

	Tache assigner(int id_user, int id_tache);

	Tache findById(int id);

	Tache partialUpdate(int id, Tache tache);

	List<Tache> findAllByProjet(int id_projet);

}
