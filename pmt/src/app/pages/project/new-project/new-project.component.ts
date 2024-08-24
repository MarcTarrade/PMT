import { Component } from '@angular/core';
import { MenuComponent } from "../../../components/menu/menu.component";
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProjetService } from '../../../services/projet.service';
import { ProjetForm } from '../../../services/api/projet-api.service';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-new-project',
  standalone: true,
  imports: [MenuComponent, ReactiveFormsModule],
  templateUrl: './new-project.component.html',
  styleUrl: './new-project.component.scss'
})
export class NewProjectComponent {
    projectForm: FormGroup;
    constructor(private projetService: ProjetService, private authService: AuthService) {
        this.projectForm = new FormGroup({
            nom: new FormControl('', [Validators.required]),
            description: new FormControl('', [Validators.required])
        });
    }

    onSubmit(){
        this.projetService.createProjet(this.authService.userInfo()!.id, this.projectForm.value as ProjetForm);
    }
}
