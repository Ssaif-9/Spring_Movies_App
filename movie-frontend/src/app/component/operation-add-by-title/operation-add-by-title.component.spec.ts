import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationAddByTitleComponent } from './operation-add-by-title.component';

describe('OperationAddByTitleComponent', () => {
  let component: OperationAddByTitleComponent;
  let fixture: ComponentFixture<OperationAddByTitleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OperationAddByTitleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperationAddByTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
