import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletepizzaitemComponent } from './deletepizzaitem.component';

describe('DeletepizzaitemComponent', () => {
  let component: DeletepizzaitemComponent;
  let fixture: ComponentFixture<DeletepizzaitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletepizzaitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletepizzaitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
