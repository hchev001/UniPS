import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessRatingComponent } from './business-rating.component';

describe('BusinessRatingComponent', () => {
  let component: BusinessRatingComponent;
  let fixture: ComponentFixture<BusinessRatingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusinessRatingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessRatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
