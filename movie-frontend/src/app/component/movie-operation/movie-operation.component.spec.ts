import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieOperationComponent } from './movie-operation.component';

describe('MovieOperationComponent', () => {
  let component: MovieOperationComponent;
  let fixture: ComponentFixture<MovieOperationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MovieOperationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
