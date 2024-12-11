import { Component } from '@angular/core';
import { MovieDto } from './dashboard.model';
import { AuthService } from '../login/login.service';
import { Router } from '@angular/router';
import { DachboardService } from './dachboard.service';
import { NgFor, NgIf } from '@angular/common';
import { MovieService } from '../movie/movie.service';
import { MovieFullInfo } from '../movie/movie.model';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
  imports: [NgIf,NgFor],

})
export class DashboardComponent {
  movieDto: MovieDto = new MovieDto();
  moviesDto: MovieDto[] = new Array<MovieDto>();
  fullMovie:MovieFullInfo= new MovieFullInfo();
  
  constructor(private movieService:MovieService,private dachboardService: DachboardService, private router: Router) { }
  
   changeImdbId(newImdbId:string): void {
        this.movieDto.imdbId = newImdbId;
  }
  changeTitle(newTitle:string): void {
        this.movieDto.title = newTitle;
  }
  changeYear(newYear:string): void {
        this.movieDto.year = newYear;
  }

  ngOnInit() {
    this.dachboardService.getMoviesList().subscribe(data => {
      this.moviesDto = data;
    });
  }

  deleteMovie(imdbId: string) {
    this.dachboardService.deleteMovieByImdbId(imdbId).subscribe(data => {
      this.moviesDto = data;
    });
    window.location.reload();
  }

  showInfo(imdbId: String) {
    this.movieService.getFullInfo(imdbId).subscribe(data => {
      this.fullMovie = data;
    });
    this.router.navigate(['/movie', imdbId]);
  }
}
