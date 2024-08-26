import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {
    constructor(private authService: AuthService, private router: Router) {
    
    }

    onLogout() {
        this.authService.logout();
        this.router.navigate(['/login']);
    }
}
