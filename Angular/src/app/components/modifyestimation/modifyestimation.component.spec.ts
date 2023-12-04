import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { ModifyestimationComponent } from './modifyestimation.component';
import { RouterTestingModule } from "@angular/router/testing";

describe('ModifyestimationComponent', () => {
  let component: ModifyestimationComponent;
  let fixture: ComponentFixture<ModifyestimationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifyestimationComponent ],
      imports: [HttpClientModule, RouterTestingModule, FormsModule],
      providers: [ModifyestimationComponent]
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
