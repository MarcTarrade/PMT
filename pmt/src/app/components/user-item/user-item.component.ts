import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Utilisateur } from '../../services/api/user-api.service';
import { RoleService } from '../../services/role.service';
import { Role } from '../../services/api/role-api.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-item',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './user-item.component.html',
  styleUrl: './user-item.component.scss'
})
export class UserItemComponent {
    roles: Role[] = [];
    @Input() role!: Role;
    @Output() roleChange = new EventEmitter<Role>();
    @Input() utilisateur!: Utilisateur;
    constructor(private roleService: RoleService) {
        this.getRoles();
    }

    async getRoles(){
        this.roles = await this.roleService.getRoles();
        // Retrouve le role de l'utilisateur dans la liste des roles pour pouvoir le changer avec ngModel
        this.role = this.roles.find(role => role.id === this.role.id)!;
    }

    onSelectionChange() {
        // Envoie le role selectionne au composant parent
        this.roleChange.emit(this.role);
    }
}
