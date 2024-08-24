import { Injectable } from '@angular/core';
import { RoleApiService } from './api/role-api.service';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private roleApiService: RoleApiService) { }

  // Récupère tous les roles
  async getRoles() {
    return await lastValueFrom(this.roleApiService.getRoles());
  }
}
