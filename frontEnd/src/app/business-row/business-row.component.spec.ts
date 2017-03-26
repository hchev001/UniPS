import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessRowComponent } from './business-row.component';

describe('BusinessRowComponent', () => {
  let component: BusinessRowComponent;
  let fixture: ComponentFixture<BusinessRowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusinessRowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
