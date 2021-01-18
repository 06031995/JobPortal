import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipleLoginComponent } from './principle-login.component';

describe('PrincipleLoginComponent', () => {
  let component: PrincipleLoginComponent;
  let fixture: ComponentFixture<PrincipleLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrincipleLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrincipleLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
