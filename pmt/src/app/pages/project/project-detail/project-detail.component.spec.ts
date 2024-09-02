import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectDetailComponent } from './project-detail.component';
import { ActivatedRoute, provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { routes } from '../../../app.routes';
import { of } from 'rxjs';

describe('ProjectDetailComponent', () => {
  let component: ProjectDetailComponent;
  let fixture: ComponentFixture<ProjectDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProjectDetailComponent],
      providers: [provideHttpClient(), provideRouter(routes), {
        provide: ActivatedRoute,
        useValue: {
            params: of({
                id: 1000
            })
        }
      }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjectDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should display project name', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')).toBeTruthy();
  });
  it('should display members', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.list-group')).toBeTruthy();
  });
  it('should display tasks', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('app-list-tache')).toBeTruthy();
  });
});
