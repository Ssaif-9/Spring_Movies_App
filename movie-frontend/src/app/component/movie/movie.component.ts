import { Component } from '@angular/core';
import { MovieService } from './movie.service';
import { ActivatedRoute } from '@angular/router';
import { MovieFullInfo } from './movie.model';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-movie',
  standalone: true,
  
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css',
  imports: [NgFor]
})
export class MovieComponent {

  movie: MovieFullInfo = new MovieFullInfo();
  imdbId: string = '';
  constructor(private movieService: MovieService, private route: ActivatedRoute) { }

  setImdbId(imdbId: string) {
    this.imdbId = imdbId;
  } 
  
  ngOnInit() {
    this.imdbId = this.route.snapshot.paramMap.get('imdbId') || '';
    this.movieService.getFullInfo(this.imdbId).subscribe((data) => {
      this.movie = data;
    });
  }

}
