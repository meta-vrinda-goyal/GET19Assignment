import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InProcessTaskComponent } from './in-process-task.component';

describe('InProcessTaskComponent', () => {
  let component: InProcessTaskComponent;
  let fixture: ComponentFixture<InProcessTaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InProcessTaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InProcessTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
