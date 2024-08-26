import { TestBed } from '@angular/core/testing';

import { TacheApiService } from './tache-api.service';

describe('TacheApiService', () => {
  let service: TacheApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TacheApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
