import { Component } from '@angular/core';
import { MovieOperationService } from '../movie-operation/movie-operation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-operation-add-by-title',
  standalone: true,
  
  templateUrl: './operation-add-by-title.component.html',
  styleUrl: './operation-add-by-title.component.css'
})
export class OperationAddByTitleComponent {
 title: string='';
  year: String = '';

   changeTitle(newTitle:string): void {
        this.title = newTitle;
  }
  changeYear(newYear:string): void {
        this.year = newYear;
  }
  constructor(private movieOperationService: MovieOperationService, private router: Router) { }

  addMovieByTitle() {
    this.movieOperationService.addMovieByTitle(this.title,this.year).subscribe(data => {
      alert(data);
    });
    this.router.navigate(['/dashboard']).then(() => {
    window.location.reload();
  });
    }
}
