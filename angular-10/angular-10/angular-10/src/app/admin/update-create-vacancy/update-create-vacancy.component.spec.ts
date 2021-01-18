import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCreateVacancyComponent } from './update-create-vacancy.component';

describe('UpdateCreateVacancyComponent', () => {
  let component: UpdateCreateVacancyComponent;
  let fixture: ComponentFixture<UpdateCreateVacancyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCreateVacancyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCreateVacancyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
