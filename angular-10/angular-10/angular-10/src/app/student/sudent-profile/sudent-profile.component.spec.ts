import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SudentProfileComponent } from './sudent-profile.component';

describe('SudentProfileComponent', () => {
  let component: SudentProfileComponent;
  let fixture: ComponentFixture<SudentProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SudentProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SudentProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
