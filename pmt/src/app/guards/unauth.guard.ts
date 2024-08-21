import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';

export const unauthGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService)
  const router = inject(Router)
  if(authService.isLoggedIn()) {
    return false;
  }
  router.navigate(['/']);
  return true;
};
