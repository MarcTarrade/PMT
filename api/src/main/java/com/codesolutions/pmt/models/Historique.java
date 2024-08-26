package com.codesolutions.pmt.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historique")
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String description;
	private LocalDate dateEcheance;
	private String priorite;
	@JoinColumn(name = "id_utilisateur_modificateur")
	@OneToOne
	private Utilisateur utilisateur_modificateur;
	@JoinColumn(name = "id_tache")
	@OneToOne
	private Tache tache;
	private String status;
	
	public Historique() {}
	
	public Historique(String nom, String description, LocalDate dateEcheance, String priorite,
			Utilisateur utilisateur_modificateur, Tache tache, String status) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateEcheance = dateEcheance;
		this.priorite = priorite;
		this.utilisateur_modificateur = utilisateur_modificateur;
		this.tache = tache;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(LocalDate dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public Utilisateur getUtilisateur_modificateur() {
		return utilisateur_modificateur;
	}
	public void setUtilisateur_modificateur(Utilisateur utilisateur_modificateur) {
		this.utilisateur_modificateur = utilisateur_modificateur;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
