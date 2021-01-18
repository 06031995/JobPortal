import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppliedJobbystudnetListComponent } from './applied-jobbystudnet-list.component';

describe('AppliedJobbystudnetListComponent', () => {
  let component: AppliedJobbystudnetListComponent;
  let fixture: ComponentFixture<AppliedJobbystudnetListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppliedJobbystudnetListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppliedJobbystudnetListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
