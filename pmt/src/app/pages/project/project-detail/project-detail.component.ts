import { Component, LOCALE_ID } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjetService } from '../../../services/projet.service';
import { Projet } from '../../../services/api/projet-api.service';
import { CommonModule } from '@angular/common';
import { UserItemComponent } from '../../../components/user-item/user-item.component';
import { FormsModule } from '@angular/forms';
import { Role } from '../../../services/api/role-api.service';
import { ErrorToastComponent } from '../../../components/error-toast/error-toast.component';
import { ListTacheComponent } from '../../../components/list-tache/list-tache.component';


@Component({
  selector: 'app-project-detail',
  standalone: true,
  imports: [CommonModule, UserItemComponent,FormsModule, ErrorToastComponent, ListTacheComponent],
  templateUrl: './project-detail.component.html',
  styleUrl: './project-detail.component.scss'
})
export class ProjectDetailComponent {
    currentId = 0;
    projet?: Projet;
    newUtilisateurEmail: string = '';
    errorMessage: string = '';
    showErrorToast = false;
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
        // Verifie que l'utilisateur est un administrateur et qu'il est possible de changer le role des utilisateurs
        if(!this.projetService.isAdmin()) return this.showError("Impossible de changer le role des utilisateurs. Vous devez être administrateur du projet.", true);
        this.projetService.updateRoles(this.currentId, this.projet!.utilisateurs)
    }

    onRoleChange(newRole: Role, index: number) {
        // Met à jour le role de l'utilisateur au changement de role
        this.projet!.utilisateurs[index].role = newRole;
    }

    async onAddUtilisateur() {
        // Verifie que l'utilisateur est un administrateur et qu'il est possible d'ajouter un utilisateur
        if (!this.projetService.isAdmin()) return this.showError("Impossible d'ajouter un utilisateur. Vous devez être administrateur du projet.", true);
        const newUtilisateur = await this.projetService.addUtilisateurToProjet(this.currentId, this.newUtilisateurEmail)
        this.projet?.utilisateurs.push(newUtilisateur);
    }

    showError(message: string, show: boolean) {
        // Affiche un message d'erreur si une erreur est survenue
        this.errorMessage = message;
        this.showErrorToast = show;
    }
}
