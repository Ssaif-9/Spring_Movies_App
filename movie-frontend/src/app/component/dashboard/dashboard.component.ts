import { Component } from '@angular/core';
import { MovieDto } from './dashboard.model';
import { AuthService } from '../login/login.service';
import { Router } from '@angular/router';
import { DachboardService } from './dachboard.service';
import { NgFor, NgIf } from '@angular/common';

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
  
  constructor(private DachboardService: DachboardService, private router: Router) { }
  
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
    this.DachboardService.getMoviesList().subscribe(data => {
      this.moviesDto = data;
    });
  }

  deleteMovie(imdbId: string) {
    this.DachboardService.deleteMovieByImdbId(imdbId).subscribe(data => {
      this.moviesDto = data;
    });
    window.location.reload();
  }




}
