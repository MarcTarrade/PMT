import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjetService } from '../../../services/projet.service';
import { Projet } from '../../../services/api/projet-api.service';
import { CommonModule } from '@angular/common';
import { UserItemComponent } from '../../../components/user-item/user-item.component';
import { FormsModule } from '@angular/forms';
import { Role } from '../../../services/api/role-api.service';

@Component({
  selector: 'app-project-detail',
  standalone: true,
  imports: [CommonModule, UserItemComponent,FormsModule],
  templateUrl: './project-detail.component.html',
  styleUrl: './project-detail.component.scss'
})
export class ProjectDetailComponent {
    currentId = 0;
    projet?: Projet;
    newUtilisateurEmail: string = '';
    constructor(private activatedRoute: ActivatedRoute, private projetService: ProjetService) {
        this.activatedRoute.params.subscribe(params => {
            const idStr = params['id'];
            const id = parseInt(idStr);
            this.currentId = id;
        })
        this.getProjectInfo();
    }

    async getProjectInfo() {
        this.projet = await this.projetService.getProjet(this.currentId);
    }

    onSaveUtilisateurs() {
        console.log(this.projet?.utilisateurs[0]);
        this.projetService.updateRoles(this.currentId, this.projet!.utilisateurs)
    }

    onRoleChange(newRole: Role, index: number) {
        this.projet!.utilisateurs[index].role = newRole;
    }

    async onAddUtilisateur() {
        const newUtilisateur = await this.projetService.addUtilisateurToProjet(this.currentId, this.newUtilisateurEmail)
        console.log(newUtilisateur)
        this.projet?.utilisateurs.push(newUtilisateur);
    }
}
