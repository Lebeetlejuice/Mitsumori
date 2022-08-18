import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoEstimationComponent } from './do-estimation.component';

describe('DoEstimationComponent', () => {
  let component: DoEstimationComponent;
  let fixture: ComponentFixture<DoEstimationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoEstimationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoEstimationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
