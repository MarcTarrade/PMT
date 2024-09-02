import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProjectComponent } from './list-project.component';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from '../../../app.routes';
import { of } from 'rxjs';
import { AuthService } from '../../../services/auth.service';

class MockAuthService {

    userInfo() {
      // Retourne un utilisateur simulé
      return { id: 1000, nom: 'pierre', email: 'pierre@pmt.com', password: '1234' };
    }
}

describe('ListProjectComponent', () => {
  let component: ListProjectComponent;
  let fixture: ComponentFixture<ListProjectComponent>;
  let authService: AuthService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListProjectComponent],
      providers: [provideHttpClient(), provideRouter(routes), {provide: AuthService, useClass: MockAuthService}]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListProjectComponent);
    component = fixture.componentInstance;
    authService = TestBed.inject(AuthService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display list of projects', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.list-group')).toBeTruthy();
  });

  it('should display project name', () => {
    const compiled = fixture.nativeElement as HTMLElement;   
    expect(compiled.querySelector('.list-group-item h2')).toBeTruthy();
  });
});
