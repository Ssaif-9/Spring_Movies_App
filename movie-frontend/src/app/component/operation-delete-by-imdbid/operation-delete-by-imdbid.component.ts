import { Component } from '@angular/core';
import { MovieOperationService } from '../../movie-operation-service/movie-operation.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-operation-delete-by-imdbid',
  standalone: true,
  
  templateUrl: './operation-delete-by-imdbid.component.html',
  styleUrl: './operation-delete-by-imdbid.component.css',
  imports:[NgFor,NgIf]
})
export class OperationDeleteByImdbidComponent {
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

  deleteMovieByImdbId() {
    this.movieOperationService.deleteMovieByImdbId(this.imdbId).subscribe(data => {
      alert(data);
    });
  }

   deleteBatchMovieByImdbId() {
    if (this.imdbIdList.length > 0) {
      this.movieOperationService.deleteMovieByImdbIdList(this.imdbIdList).subscribe(data => {
       
        this.imdbIdList = []; // Clear the list after successful addition
      });
    } else {
      alert('No IMDB IDs to dalete');
     }
    this.router.navigate(['/dashboard']).then(() => {
    window.location.reload();
});
   }
}


