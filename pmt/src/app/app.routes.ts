import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { unauthGuard } from './guards/unauth.guard';
import { HomeComponent } from './pages/home/home.component';
import { authGuard } from './guards/auth.guard';
import { ProjectComponent } from './pages/project/project.component';
import { ProjectDetailComponent } from './pages/project/project-detail/project-detail.component';
import { NewProjectComponent } from './pages/project/new-project/new-project.component';
import { ListProjectComponent } from './pages/project/list-project/list-project.component';
import { TacheDetailComponent } from './pages/tache/tache-detail/tache-detail.component';
import { TacheComponent } from './pages/tache/tache.component';

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
    children: [{
        path: 'new',
        component: NewProjectComponent,
        canActivate: [authGuard]
    }, {
        path: 'list',
        component: ListProjectComponent,
        canActivate: [authGuard]
    }, {
        path: ':id',
        component: ProjectDetailComponent,
        canActivate: [authGuard]
    }]
}, {
    path: 'project/:id/tache',
    component: TacheComponent,
    children: [{
        path: 'new',
        component: TacheDetailComponent,
        canActivate: [authGuard]
    }, {
        path: ':tacheId',
        component: TacheDetailComponent,
        canActivate: [authGuard],
    }],
}];
