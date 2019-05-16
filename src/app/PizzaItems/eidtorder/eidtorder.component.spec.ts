import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EidtorderComponent } from './eidtorder.component';

describe('EidtorderComponent', () => {
  let component: EidtorderComponent;
  let fixture: ComponentFixture<EidtorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EidtorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EidtorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
