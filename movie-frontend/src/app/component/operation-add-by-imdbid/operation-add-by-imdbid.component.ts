import { Component } from '@angular/core';
import { MovieOperationService } from '../../movie-operation-service/movie-operation.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-operation-add-by-imdbid',
  standalone: true,
  
  templateUrl: './operation-add-by-imdbid.component.html',
  styleUrl: './operation-add-by-imdbid.component.css',
  imports:[NgFor,NgIf]
})
export class OperationAddByImdbidComponent {
  imdbId: string = '';
  imdbIdList: String[] = [];

  changeImdbId(newImdbId:string): void {
        this.imdbId = newImdbId;
  }

   setImdbIdList(newImdb: String): void {
    if (newImdb && !this.imdbIdList.includes(newImdb)) {
      this.imdbIdList.push(newImdb);
     }
    
  }
  constructor(private movieOperationService: MovieOperationService, private router: Router) { }

  addMovieByImdbId() {
    this.movieOperationService.addMovieByImdbId(this.imdbId).subscribe(data => {
     
    });
  }

   addBatchMovieByImdbId() {
    if (this.imdbIdList.length > 0) {
      this.movieOperationService.addMoviesImdbIdList(this.imdbIdList).subscribe(data => {
       
        this.imdbIdList = []; // Clear the list after successful addition
      });
    } else {
      alert('No IMDB IDs to add');
     }
     this.router.navigate(['/dashboard']).then(() => {
     window.location.reload();
});
  }
}


