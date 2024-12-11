import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationAddByImdbidComponent } from './operation-add-by-imdbid.component';

describe('OperationAddByImdbidComponent', () => {
  let component: OperationAddByImdbidComponent;
  let fixture: ComponentFixture<OperationAddByImdbidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OperationAddByImdbidComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperationAddByImdbidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
