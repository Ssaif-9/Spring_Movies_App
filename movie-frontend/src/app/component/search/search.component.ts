import { Component } from '@angular/core';
import { HomeService } from '../home/home.service';
import { ActivatedRoute } from '@angular/router';
import { MovieDto } from '../dashboard/dashboard.model';
import { NgFor } from '@angular/common';
import { HomeMovie } from '../home/home.model';

@Component({
  selector: 'app-search',
  standalone: true,
  
  templateUrl: './search.component.html',
  styleUrl: './search.component.css',
  imports: [NgFor]

})
export class SearchComponent {

  movies: HomeMovie[] = [];
  
  searchType: String = '';
  searchTerm: String = '';

  constructor(private homeService: HomeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      // Check if a parameter exists and assign it accordingly
      if (params.has('imbdId')) {
        this.searchType = 'imbdId';
        this.searchTerm = params.get('imbdId')!;
      } else if (params.has('title')) {
        this.searchType = 'title';
        this.searchTerm = params.get('title')!;
      } else if (params.has('year')) {
        this.searchType = 'year';
        this.searchTerm = params.get('year')!;
      }

      // Call search function with the search term
      this.searchFunction(this.searchTerm);
    });
  }
   searchFunction(search: String): void {
    if (this.searchType === 'imbdId') {
      // Call the service to search by IMDB ID
      this.homeService.searchMovieByimdbId(this.searchTerm).subscribe(data => {
      this.movies = data;
      });
    } else if (this.searchType === 'title') {
      // Call the service to search by Title
      this.homeService.searchMovieByTitle(this.searchTerm).subscribe(data => {
      this.movies = data;
      });
    } else if (this.searchType === 'year') {
      // Call the service to search by Year
      this.homeService.searchMovieByYear(this.searchTerm).subscribe(data => {
      this.movies = data;
      });
    }
  }


  }



