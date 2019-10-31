import { TestBed } from '@angular/core/testing';

import { ShoppingSiteService } from './shopping-site.service';

describe('ShoppingSiteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ShoppingSiteService = TestBed.get(ShoppingSiteService);
    expect(service).toBeTruthy();
  });
});
