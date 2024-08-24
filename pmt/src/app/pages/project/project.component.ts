import { Component } from '@angular/core';
import { MenuComponent } from "../../components/menu/menu.component";
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ProjetService } from '../../services/projet.service';
import { ProjetForm } from '../../services/api/projet-api.service';
import { AuthService } from '../../services/auth.service';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-project',
  standalone: true,
  imports: [MenuComponent, RouterOutlet],
  templateUrl: './project.component.html',
  styleUrl: './project.component.scss'
})
export class ProjectComponent {
    
}
