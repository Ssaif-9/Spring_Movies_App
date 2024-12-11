import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../login/login.service';
import { MovieOperationService } from './movie-operation.service';
import { MovieOperation } from './movie-operation.model';

@Component({
  selector: 'app-movie-operation',
  standalone: true,
  
  templateUrl: './movie-operation.component.html',
  styleUrl: './movie-operation.component.css'
})
export class MovieOperationComponent  {
  movieOperation: MovieOperation = new MovieOperation();

  constructor(private movieOperationService: MovieOperationService, private router: Router) { }
  
  changeImdbId(newImdbId:string): void {
        this.movieOperation.imdbId = newImdbId;
  }
  changeTitle(newTitle:string): void {
        this.movieOperation.title = newTitle;
  }
  changeYear(newYear:string): void {
        this.movieOperation.year = newYear;
  }

  ngOnInit(): void { }

  addMovieByImdbId() {
    this.movieOperationService.addMovieByImdbId(this.movieOperation.imdbId).subscribe(data => {
      alert(data);
    });
  }

  addMovieByTitle() {
    this.movieOperationService.addMovieByTitle(this.movieOperation.title,this.movieOperation.year).subscribe(data => {
      alert(data);
    });
  }

  deleteMovieByImdbId() {
    this.movieOperationService.deleteMovieByImdbId(this.movieOperation.imdbId).subscribe(data => {
      alert(data);
    });
  }

  
  
  
  




  
}
