import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FulldemoComponent } from './fulldemo.component';

describe('FulldemoComponent', () => {
  let component: FulldemoComponent;
  let fixture: ComponentFixture<FulldemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FulldemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FulldemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
