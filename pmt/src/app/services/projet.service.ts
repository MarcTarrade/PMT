import { Injectable } from '@angular/core';
import { ProjetApiService, ProjetForm } from './api/projet-api.service';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private projetApiService: ProjetApiService) { }

  createProjet(id_utilisateur: number, projetForm: ProjetForm) {
    return this.projetApiService.postProjet(id_utilisateur, projetForm).subscribe();
  }
}
