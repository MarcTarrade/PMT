package com.codesolutions.pmt.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="projet")
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String description;
	@Column(name="dateDebut")
	private LocalDate dateDebut;
	@OneToOne
	@JoinColumn(name="id_administrateur", nullable=false)
	private Utilisateur administrateur;
	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProjetUtilisateurRole> utilisateurs = new ArrayList<>();
	@OneToMany
	private List<Tache> taches = new ArrayList<Tache>();
	
	public Projet() {}
	
	public Projet(String nom, String description, Utilisateur administrateur) {
		this.nom = nom;
		this.description = description;
		this.administrateur = administrateur;
		this.dateDebut = LocalDate.now();
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
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Utilisateur getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Utilisateur administrateur) {
		this.administrateur = administrateur;
	}
	public List<ProjetUtilisateurRole> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<ProjetUtilisateurRole> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
	
}
