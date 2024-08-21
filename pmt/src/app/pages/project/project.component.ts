import { Component } from '@angular/core';
import { MenuComponent } from "../../components/menu/menu.component";
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-project',
  standalone: true,
  imports: [MenuComponent, ReactiveFormsModule],
  templateUrl: './project.component.html',
  styleUrl: './project.component.scss'
})
export class ProjectComponent {
    projectForm: FormGroup;
    constructor(){
        this.projectForm = new FormGroup({
            nom: new FormControl('', [Validators.required]),
            description: new FormControl('', [Validators.required])
        });
    }

    onSubmit(){

    }
}
