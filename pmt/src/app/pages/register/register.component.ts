import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { Utilisateur } from '../../services/api/user-api.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
    loginForm: FormGroup;
    constructor(private authService: AuthService, private router: Router){
        this.loginForm = new FormGroup({
            email: new FormControl('', [Validators.required, Validators.email]),
            nom: new FormControl('', [Validators.required]),
            password: new FormControl('', [Validators.required])
        })
    }

    onSubmit(){
        this.authService.register(this.loginForm.value as Utilisateur)
    }
}
