import { Component } from '@angular/core';
import { ProjetService } from '../../../services/projet.service';
import { Projet } from '../../../services/api/projet-api.service';
import { AuthService } from '../../../services/auth.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-list-project',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-project.component.html',
  styleUrl: './list-project.component.scss'
})
export class ListProjectComponent {
    projets: Projet[] = [];
    constructor(private projetService: ProjetService, private authService: AuthService) {
        this.getProjectsByUser();
    }

    async getProjectsByUser(){ this.projets = await this.projetService.getProjetsByUser(this.authService.userInfo()!.id) }
}
