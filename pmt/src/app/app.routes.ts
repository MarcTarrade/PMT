import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { unauthGuard } from './guards/unauth.guard';
import { HomeComponent } from './pages/home/home.component';
import { authGuard } from './guards/auth.guard';
import { ProjectComponent } from './pages/project/project.component';

export const routes: Routes = [
{
    path: 'login',
    component: LoginComponent,
    canActivate: [unauthGuard],
}, {
    path: 'register',
    component: RegisterComponent,
    canActivate: [unauthGuard],
}, {
    path: '',
    component: HomeComponent,
    canActivate: [authGuard],
}, {
    path: 'project',
    component: ProjectComponent,
    canActivate: [authGuard],
}];
