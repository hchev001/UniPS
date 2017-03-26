import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessImageComponent } from './business-image.component';

describe('BusinessImageComponent', () => {
  let component: BusinessImageComponent;
  let fixture: ComponentFixture<BusinessImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusinessImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
