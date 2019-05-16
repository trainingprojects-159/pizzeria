import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpizzaitemComponent } from './addpizzaitem.component';

describe('AddpizzaitemComponent', () => {
  let component: AddpizzaitemComponent;
  let fixture: ComponentFixture<AddpizzaitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddpizzaitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpizzaitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
