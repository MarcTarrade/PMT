import { Injectable } from '@angular/core';
import { Projet, ProjetApiService, ProjetForm, ProjetUtilisateurRole } from './api/projet-api.service';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private projetApiService: ProjetApiService) { }

  createProjet(id_utilisateur: number, projetForm: ProjetForm) {
    return this.projetApiService.postProjet(id_utilisateur, projetForm).subscribe();
  }

  async getProjet(id: number) {
    return await lastValueFrom(this.projetApiService.getProject(id));
  }

  async getProjetsByUser(id_user: number) {
    return await lastValueFrom(this.projetApiService.getProjectsByUser(id_user));
  }

  async addUtilisateurToProjet(id_projet: number, email: string) {
    return await lastValueFrom(this.projetApiService.addUtilisateurToProjet(id_projet, email));
  }

  updateRoles(id_projet: number, projetUtilisateurRole: ProjetUtilisateurRole[]) {
    this.projetApiService.updateRoles(id_projet, projetUtilisateurRole).subscribe();
  }
}
