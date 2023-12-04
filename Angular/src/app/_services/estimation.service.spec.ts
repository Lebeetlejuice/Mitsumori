import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { EstimationService } from './estimation.service';

describe('EstimationService', () => {
  let service: EstimationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
      providers: [EstimationService]
    });
    
    service = TestBed.inject(EstimationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
