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

  userInfo() {
    if(this.utilisateur) return this.utilisateur;
    else if (this.isLoggedIn()) return JSON.parse(localStorage.getItem('user') || '{}') as Utilisateur;
    else {
        this.router.navigate(['/login']);
        return;
    }
  }
}
