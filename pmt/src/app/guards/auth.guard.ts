import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';
// Verifie si l'utilisateur est connecté et redirige vers la page de connexion si ce n'est pas le cas
export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);
  if(authService.isLoggedIn()) {
    return true;
  }
  router.navigate(['/login']);
  return false;
};
