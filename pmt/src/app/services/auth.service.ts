import { Injectable } from '@angular/core';
import { LoginForm, UserApiService, Utilisateur } from './api/user-api.service';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private utilisateur?: Utilisateur;
    constructor(private userApiService: UserApiService) { }

  isLoggedIn(){
    return this.utilisateur || localStorage.getItem('user') ? true : false;
  }

  async login(loginForm : LoginForm) {
    try {
        const utilisateur = await lastValueFrom(this.userApiService.connect(loginForm))
        if (utilisateur) {
            this.utilisateur = utilisateur;
            localStorage.setItem('user', JSON.stringify(utilisateur));
        }
    } catch(e: any){
        alert(e.error.message);
    }
  }

  register(utilisateur: Utilisateur) {
    this.userApiService.postUser(utilisateur).subscribe({
        next: (res: Utilisateur) => {
            this.utilisateur = res;
            localStorage.setItem('user', JSON.stringify(res));
        }
    });
  }
}
