import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TacheDetailComponent } from './tache-detail.component';
import { provideHttpClient } from '@angular/common/http';
import { ActivatedRoute, provideRouter } from '@angular/router';
import { routes } from '../../../app.routes';
import { of } from 'rxjs';

describe('TacheDetailComponent', () => {
  let component: TacheDetailComponent;
  let fixture: ComponentFixture<TacheDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TacheDetailComponent],
      providers: [provideHttpClient(), provideRouter(routes), {
        provide: ActivatedRoute,
        useValue: {
            params: of({
                id: 1000,
                tacheId: 1000
            })
        }
      }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TacheDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should display tache name', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h2')).toBeTruthy();
  });
  it('should display history', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.list-group')).toBeTruthy();
  })
});
