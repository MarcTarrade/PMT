import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from './user-api.service';
import { Role } from './role-api.service';

export interface ProjetForm {
    nom: string;
    description: string;
}

export interface ProjetUtilisateurRole {
    id: number;
    utilisateur: Utilisateur;
    role: Role;
}

export interface Projet{
    id: number;
    nom: string;
    description: string;
    dateDebut: Date;
    administrateur: Utilisateur;
    utilisateurs: ProjetUtilisateurRole[];
}

@Injectable({
  providedIn: 'root'
})
export class ProjetApiService {
    private url = 'http://localhost:8090';
  constructor(private httpClient: HttpClient) { }
// Ajoute un projet pour un administrateur
  postProjet(id_administrateur: number, projet: ProjetForm) {
    return this.httpClient.post<ProjetForm>(`${this.url}/user/${id_administrateur}/projet`, projet);
  }
// Recupere un projet
  getProject(id: number){
    return this.httpClient.get<Projet>(`${this.url}/projet/${id}`);
  }
// Recupere tous les projets d'un utilisateur
  getProjectsByUser(id_user: number){
    return this.httpClient.get<Projet[]>(`${this.url}/user/${id_user}/projets`);
  }
  // Ajoute un utilisateur a un projet
  addUtilisateurToProjet(id_projet: number, email: string){
    return this.httpClient.post<ProjetUtilisateurRole>(`${this.url}/projet/${id_projet}/invite`, email);
  }
  // Met a jour les roles de tous les utilisateurs pour un projet
  updateRoles(id_projet: number, projetUtilisateurRole: ProjetUtilisateurRole[]){
    return this.httpClient.put<ProjetUtilisateurRole[]>(`${this.url}/projet/${id_projet}/roles`, projetUtilisateurRole);
  }
}
