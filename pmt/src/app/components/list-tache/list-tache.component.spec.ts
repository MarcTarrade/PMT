import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTacheComponent } from './list-tache.component';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from '../../app.routes';

describe('ListTacheComponent', () => {
  let component: ListTacheComponent;
  let fixture: ComponentFixture<ListTacheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListTacheComponent],
      providers: [provideHttpClient(), provideRouter(routes)]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListTacheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
