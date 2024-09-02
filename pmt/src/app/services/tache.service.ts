import { Injectable } from '@angular/core';
import { Utilisateur } from './api/user-api.service';
import { TacheApiService } from './api/tache-api.service';
import { lastValueFrom } from 'rxjs';

export interface Tache {
    id?: number;
    nom: string;
    description: string;
    dateEcheance?: Date;
    priorite: string;
    status: string;
    utilisateur?: Utilisateur;
}
export interface Historique {
    id?: number;
    nom: string;
    description: string;
    dateEcheance?: Date;
    priorite: string;
    status: string;
    utilisateur_modificateur?: Utilisateur;
}

@Injectable({
  providedIn: 'root'
})
export class TacheService {

  constructor(private tacheApiService: TacheApiService) { }
  // Creer une nouvelle tache pour un projet
  postTache(id_projet:number, tache: Tache) {
    this.tacheApiService.postTache(id_projet, tache).subscribe();
  }

  // Recupere toutes les taches d'un projet
  async getTachesByProject(id_projet: number) {
    return await lastValueFrom(this.tacheApiService.getTachesByProject(id_projet));
  }

  // Met a jour une tache
  updateTache(tacheId: number, tache: Tache) {
    this.tacheApiService.updateTache(tacheId, tache).subscribe();
  }

  // Ajoute un utilisateur a une tache
  assignerTache(id_utilisateur: number, id_tache: number) {
    this.tacheApiService.assignerTache(id_utilisateur, id_tache).subscribe()
  }

  // Recupere les détails d'une tache
  async getDetailTache(id: number) {
    return await lastValueFrom(this.tacheApiService.getDetailTache(id));
  }

  // Recupere l'historique d'une tache
  async getHistorique(id_tache: number) {
    return await lastValueFrom(this.tacheApiService.getHistorique(id_tache));
  }
}
