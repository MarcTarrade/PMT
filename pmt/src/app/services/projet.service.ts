import { Injectable } from '@angular/core';
import { Projet, ProjetApiService, ProjetForm, ProjetUtilisateurRole } from './api/projet-api.service';
import { lastValueFrom } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {
    projet?: Projet;

  constructor(private projetApiService: ProjetApiService, private authService: AuthService) { }

  // Ajoute un projet pour un administrateur
  createProjet(id_utilisateur: number, projetForm: ProjetForm) {
    return this.projetApiService.postProjet(id_utilisateur, projetForm).subscribe();
  }

  // Recupere un projet
  async getProjet(id: number) {
    this.projet = await lastValueFrom(this.projetApiService.getProject(id));
    return this.projet
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

  // Verifie si l'utilisateur est un administrateur
  isAdmin(): boolean {
    if(!this.projet) return false
    const utilisateur = this.authService.userInfo();
    if(!utilisateur) return false
    return this.projet.administrateur.id === utilisateur.id ? true : false;
  }

  // Verifie si l'utilisateur est au moins un membre
  isMember(): boolean {
    if(!this.projet) return false
    const utilisateur = this.authService.userInfo();
    if(!utilisateur) return false
    return this.projet.utilisateurs.find(utilisateurElement => utilisateurElement.utilisateur.id === utilisateur.id && utilisateurElement.role.nom === 'Membre') || this.projet.administrateur.id === utilisateur.id ? true : false;
}

  // Recupere tous les utilisateurs d'un projet
  async getUsersByProject(id_projet: number) {
    return await lastValueFrom(this.projetApiService.getUsersByProject(id_projet));
  }
}
