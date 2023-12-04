import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { DoEstimationComponent } from './do-estimation.component';

describe('DoEstimationComponent', () => {
  let component: DoEstimationComponent;
  let fixture: ComponentFixture<DoEstimationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoEstimationComponent ],
      imports: [HttpClientModule,FormsModule],
      providers: [DoEstimationComponent]
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
