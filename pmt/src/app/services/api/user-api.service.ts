import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface Utilisateur {
    id: number;
    nom: string;
    email: string;
    password: string;
}

export interface LoginForm {
    email: string;
    password: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserApiService {
    private url = 'http://localhost:8090';
    constructor(private http: HttpClient) { }

    // Ajoute un utilisateur
    postUser(user: Utilisateur) {
        return this.http.post<Utilisateur>(`${this.url}/user`, user);
    }
    // Verifie que l'email et le mot de passe sont correctes en base de donnée
    connect(loginForm : LoginForm) {
        return this.http.post<Utilisateur>(`${this.url}/connexion`, loginForm);
    }
}
