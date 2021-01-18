import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppliedJobbystudnetComponent } from './applied-jobbystudnet.component';

describe('AppliedJobbystudnetComponent', () => {
  let component: AppliedJobbystudnetComponent;
  let fixture: ComponentFixture<AppliedJobbystudnetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppliedJobbystudnetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppliedJobbystudnetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
