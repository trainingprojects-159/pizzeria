import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaitemsDetailsComponent } from './pizzaitems-details.component';

describe('PizzaitemsDetailsComponent', () => {
  let component: PizzaitemsDetailsComponent;
  let fixture: ComponentFixture<PizzaitemsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PizzaitemsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaitemsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
