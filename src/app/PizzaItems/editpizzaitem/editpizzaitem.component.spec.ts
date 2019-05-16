import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditpizzaitemComponent } from './editpizzaitem.component';

describe('EditpizzaitemComponent', () => {
  let component: EditpizzaitemComponent;
  let fixture: ComponentFixture<EditpizzaitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditpizzaitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditpizzaitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
