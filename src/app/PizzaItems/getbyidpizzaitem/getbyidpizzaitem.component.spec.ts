import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetbyidpizzaitemComponent } from './getbyidpizzaitem.component';

describe('GetbyidpizzaitemComponent', () => {
  let component: GetbyidpizzaitemComponent;
  let fixture: ComponentFixture<GetbyidpizzaitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetbyidpizzaitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetbyidpizzaitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
