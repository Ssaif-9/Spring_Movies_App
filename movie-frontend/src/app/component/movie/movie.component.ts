import { Component } from '@angular/core';
import { MovieService } from './movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieFullInfo } from './movie.model';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-movie',
  standalone: true,
  
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css',
  imports: [NgIf,NgFor]
})
export class MovieComponent {
  movieRate : number = 0;
  movie: MovieFullInfo = new MovieFullInfo();
  imdbId: string = '';
  username: string = '';
  constructor(private movieService: MovieService, private route: ActivatedRoute, private router: Router) { }

  setImdbId(imdbId: string) {
    this.imdbId = imdbId;
  } 
  
  ngOnInit() {
    this.username = this.route.snapshot.paramMap.get('username') || '';
    this.imdbId = this.route.snapshot.paramMap.get('imdbId') || '';
    this.movieService.getFullInfo(this.imdbId).subscribe((data) => {
      this.movie = data;
    });
    this.getRated();
  }

  rateMovie(rate: number) {
    this.movieService.rateMovie(this.username,this.imdbId, rate).subscribe((data) => {
      this.movie = data;
    });
  }

  getRated() {
    this.movieService.getRated(this.username,this.imdbId).subscribe((data) => {
      this.movieRate = data;
    });
  }

   navigateToPage() {
    if (this.username === 'admin') {
      this.router.navigate(['/dashboard']);
    } else {
      this.router.navigate(['/home'], { queryParams: { username: this.username } });
    }
  }

}
