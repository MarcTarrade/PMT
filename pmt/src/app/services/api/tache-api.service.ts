import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tache } from '../tache.service';

@Injectable({
  providedIn: 'root'
})
export class TacheApiService {
    private url = 'http://localhost:8090'
  constructor(private httpClient: HttpClient) { 

  }

  postTache(id_projet: number, tache: Tache) {
    return this.httpClient.post<Tache>(`${this.url}/projet/${id_projet}/tache`, tache)
  }

  getTachesByProject(id_projet: number) {
    return this.httpClient.get<Tache[]>(`${this.url}/projet/${id_projet}/taches`);
  }

  updateTache(tacheId: number, tache: Tache) {
    return this.httpClient.patch<Tache>(`${this.url}/tache/${tacheId}`, tache)
  }

  assignerTache(id_utilisateur: number, id_tache: number) {
    return this.httpClient.put<Tache>(`${this.url}/user/${id_utilisateur}/tache/${id_tache}`, {})
  }

  getDetailTache(id: number) {
    return this.httpClient.get<Tache>(`${this.url}/tache/${id}`)
  }
}
