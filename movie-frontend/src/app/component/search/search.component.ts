import { Component } from '@angular/core';
import { HomeService } from '../home/home.service';
import { ActivatedRoute } from '@angular/router';
import { MovieDto } from '../dashboard/dashboard.model';
import { NgFor } from '@angular/common';
import { HomeMovie } from '../home/home.model';
import { SearchService } from './search.service';

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

  username: String = '';

  constructor(private searchService: SearchService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.username = this.route.snapshot.paramMap.get('username') || '';
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
      this.searchService.searchMovieByimdbId(this.searchTerm).subscribe(data => {
         if (data.length === 0) {
        alert('No movie found with the Imdb Id: ' + this.searchTerm);
      }
      this.movies = data;
      });
    } else if (this.searchType === 'title') {
      // Call the service to search by Title
      this.searchService.searchMovieByTitle(this.searchTerm).subscribe(data => {
      if (data.length === 0) {
        alert('No movie found with the title: ' + this.searchTerm);
      }
      this.movies = data;
      });
    } else if (this.searchType === 'year') {
      // Call the service to search by Year
      this.searchService.searchMovieByYear(this.searchTerm).subscribe(data => {
         if (data.length === 0) {
        alert('No movie found with Year: ' + this.searchTerm);
      }
      this.movies = data;
      });
    }
  }


  }



