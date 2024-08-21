import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface ProjetForm {
    nom: string;
    description: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProjetApiService {
    private url = 'http://localhost:8090';
  constructor(private httpClient: HttpClient) { }

  postProjet(id_administrateur: number, projet: ProjetForm) {
    return this.httpClient.post<ProjetForm>(`${this.url}/user/${id_administrateur}/projet`, projet);
  }
}
