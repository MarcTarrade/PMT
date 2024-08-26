package com.codesolutions.pmt.services;

import java.util.List;

import com.codesolutions.pmt.models.Historique;

public interface HistoriqueService {

	List<Historique> findAllByTache(int id);

}
