import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipleRegisterComponent } from './principle-register.component';

describe('PrincipleRegisterComponent', () => {
  let component: PrincipleRegisterComponent;
  let fixture: ComponentFixture<PrincipleRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrincipleRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrincipleRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
