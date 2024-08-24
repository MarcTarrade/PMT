import { Injectable } from '@angular/core';
import { Projet, ProjetApiService, ProjetForm, ProjetUtilisateurRole } from './api/projet-api.service';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private projetApiService: ProjetApiService) { }

  // Ajoute un projet pour un administrateur
  createProjet(id_utilisateur: number, projetForm: ProjetForm) {
    return this.projetApiService.postProjet(id_utilisateur, projetForm).subscribe();
  }

  // Recupere un projet
  async getProjet(id: number) {
    return await lastValueFrom(this.projetApiService.getProject(id));
  }

 // Recupere tous les projets d'un utilisateur
  async getProjetsByUser(id_user: number) {
    return await lastValueFrom(this.projetApiService.getProjectsByUser(id_user));
  }

  // Ajoute un utilisateur a un projet
  async addUtilisateurToProjet(id_projet: number, email: string) {
    return await lastValueFrom(this.projetApiService.addUtilisateurToProjet(id_projet, email));
  }

  // Met a jour les roles de tous les utilisateurs pour un projet
  updateRoles(id_projet: number, projetUtilisateurRole: ProjetUtilisateurRole[]) {
    this.projetApiService.updateRoles(id_projet, projetUtilisateurRole).subscribe();
  }
}
