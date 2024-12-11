import { TestBed } from '@angular/core/testing';

import { DachboardService } from './dachboard.service';

describe('DachboardService', () => {
  let service: DachboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DachboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
