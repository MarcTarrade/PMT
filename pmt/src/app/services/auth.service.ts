import { Injectable } from '@angular/core';
import { LoginForm, UserApiService, Utilisateur } from './api/user-api.service';
import { lastValueFrom } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private utilisateur?: Utilisateur;
    constructor(private userApiService: UserApiService, private router: Router) { }

    // Vérifie si l'utilisateur est connecté
  isLoggedIn(){
    // Verifie si la variable utilisateur est définie ou si l'utilisateur est stocké dans le localStorage
    return this.utilisateur || localStorage.getItem('user') ? true : false;
  }

  // Connecte l'utilisateur
  async login(loginForm : LoginForm) {
    try {
        const utilisateur = await lastValueFrom(this.userApiService.connect(loginForm))
        if (utilisateur) {
            this.utilisateur = utilisateur;
            // Lorsque l'utilisateur est connecté, on le stocke dans le localStorage
            localStorage.setItem('user', JSON.stringify(utilisateur));
        }
    } catch(e: any){
        alert(e.error.message);
    }
  }

  // Inscrit l'utilisateur
  register(utilisateur: Utilisateur) {
    this.userApiService.postUser(utilisateur).subscribe({
        next: (res: Utilisateur) => {
            this.utilisateur = res;
            // Lorsque l'utilisateur est connecté, on le stocke dans le localStorage
            localStorage.setItem('user', JSON.stringify(res));
        }
    });
  }

  // Retourne les infos de l'utilisateur
  userInfo() {
    if(this.utilisateur) return this.utilisateur;
    else if (this.isLoggedIn()) return JSON.parse(localStorage.getItem('user') || '{}') as Utilisateur;
    else {
        // Si l'utilisateur n'est pas connecté, on le redirige vers la page de connexion
        this.router.navigate(['/login']);
        return;
    }
  }

  logout() {
    this.utilisateur = undefined;
    localStorage.removeItem('user');
  }
}
