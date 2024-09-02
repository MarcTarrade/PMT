import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';

// Verifie si l'utilisateur n'est pas connecté et redirige vers la page d'accueil s'il l'est deja
export const unauthGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService)
  const router = inject(Router)
  if(!authService.isLoggedIn()) {
    return true;
  }
  router.navigate(['/']);
  return true;
};
