import { TestBed } from '@angular/core/testing';

import { FolkloreService } from './folklore.service';

describe('FolkloreService', () => {
  let service: FolkloreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FolkloreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
