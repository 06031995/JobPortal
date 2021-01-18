import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredStudentlistComponent } from './registered-studentlist.component';

describe('RegisteredStudentlistComponent', () => {
  let component: RegisteredStudentlistComponent;
  let fixture: ComponentFixture<RegisteredStudentlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredStudentlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteredStudentlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
