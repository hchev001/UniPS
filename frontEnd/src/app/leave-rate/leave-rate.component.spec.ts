import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveRateComponent } from './leave-rate.component';

describe('LeaveRateComponent', () => {
  let component: LeaveRateComponent;
  let fixture: ComponentFixture<LeaveRateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveRateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});