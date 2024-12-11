import { TestBed } from '@angular/core/testing';

import { MovieOperationService } from './movie-operation.service';

describe('MovieOperationService', () => {
  let service: MovieOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
