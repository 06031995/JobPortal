import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateStudentPdfComponent } from './generate-student-pdf.component';

describe('GenerateStudentPdfComponent', () => {
  let component: GenerateStudentPdfComponent;
  let fixture: ComponentFixture<GenerateStudentPdfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerateStudentPdfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateStudentPdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
