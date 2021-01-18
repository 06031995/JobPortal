import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipleProfileComponent } from './principle-profile.component';

describe('PrincipleProfileComponent', () => {
  let component: PrincipleProfileComponent;
  let fixture: ComponentFixture<PrincipleProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrincipleProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrincipleProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
