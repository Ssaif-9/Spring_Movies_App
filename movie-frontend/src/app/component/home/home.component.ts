import { Component } from '@angular/core';
import { HomeService } from './home.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';
import { HomeMovie } from './home.model';

@Component({
  selector: 'app-home',
  standalone: true,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
   imports: [NgIf,NgFor]

})
export class HomeComponent {

  homeMovies: HomeMovie[] = [];
  homeMovie: HomeMovie = new HomeMovie();
  selectedOption: number = 0;
  
  constructor(private homeService: HomeService, private router: Router) { }

  changeTitle(newTitle:string): void {
        this.homeMovie.title = newTitle;
    }
  ngOnInit(): void {
    this.homeService.getHomeMovies().subscribe(data => {
      this.homeMovies = data;
    });
  }

  searchMovieByTitle(title: string) {
    this.homeService.searchMovieByTitle(title).subscribe(data => {
      this.homeMovies = data;
    });
  }

  searchMovieByimdbId(imdbId: string) {
    this.homeService.searchMovieByimdbId(imdbId).subscribe(data => {
      this.homeMovies = data;
    });
  }

  searchMovieByYear(year: string) {
    this.homeService.searchMovieByYear(year).subscribe(data => {
      this.homeMovies = data;
    });
  }


  
  
}
