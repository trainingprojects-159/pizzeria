import { TestBed, inject } from '@angular/core/testing';

import { PizzastoreService } from './pizzastore.service';

describe('PizzastoreService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PizzastoreService]
    });
  });

  it('should be created', inject([PizzastoreService], (service: PizzastoreService) => {
    expect(service).toBeTruthy();
  }));
});
