import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Historique, Tache } from '../tache.service';

@Injectable({
  providedIn: 'root'
})
export class TacheApiService {
    private url = 'http://localhost:8090'
  constructor(private httpClient: HttpClient) { 

  }

  // Creer une nouvelle tache pour un projet
  postTache(id_projet: number, tache: Tache) {
    return this.httpClient.post<Tache>(`${this.url}/projet/${id_projet}/tache`, tache)
  }

  // Recupere toutes les taches d'un projet
  getTachesByProject(id_projet: number) {
    return this.httpClient.get<Tache[]>(`${this.url}/projet/${id_projet}/taches`);
  }

  // Met a jour une tache
  updateTache(tacheId: number, tache: Tache) {
    return this.httpClient.patch<Tache>(`${this.url}/tache/${tacheId}`, tache)
  }

  // Ajoute un utilisateur a une tache
  assignerTache(id_utilisateur: number, id_tache: number) {
    return this.httpClient.put<Tache>(`${this.url}/user/${id_utilisateur}/tache/${id_tache}`, {})
  }

  // Recupere les détails d'une tache
  getDetailTache(id: number) {
    return this.httpClient.get<Tache>(`${this.url}/tache/${id}`)
  }

  // Recupere l'historique d'une tache
  getHistorique(id_tache: number){
    return this.httpClient.get<Historique[]>(`${this.url}/tache/${id_tache}/historique`)
  }
}
