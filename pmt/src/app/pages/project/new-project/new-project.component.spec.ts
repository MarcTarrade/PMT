import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProjectComponent } from './new-project.component';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { routes } from '../../../app.routes';

describe('NewProjectComponent', () => {
  let component: NewProjectComponent;
  let fixture: ComponentFixture<NewProjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewProjectComponent],
      providers: [provideHttpClient(), provideRouter(routes)]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should display new project form', () => {
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.form-group')).toBeTruthy();
  })
});
