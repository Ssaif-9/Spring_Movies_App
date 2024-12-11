import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationDeleteByImdbidComponent } from './operation-delete-by-imdbid.component';

describe('OperationDeleteByImdbidComponent', () => {
  let component: OperationDeleteByImdbidComponent;
  let fixture: ComponentFixture<OperationDeleteByImdbidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [OperationDeleteByImdbidComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OperationDeleteByImdbidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
