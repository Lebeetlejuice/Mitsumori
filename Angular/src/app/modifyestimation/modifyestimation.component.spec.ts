import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyestimationComponent } from './modifyestimation.component';

describe('ModifyestimationComponent', () => {
  let component: ModifyestimationComponent;
  let fixture: ComponentFixture<ModifyestimationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyestimationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifyestimationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
