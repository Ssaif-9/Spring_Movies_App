import { Component, EventEmitter, Input, Output } from '@angular/core';
import { HomeService } from './home.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';
import { HomeMovie } from './home.model';
import { HomePage } from './home.pagination.model';

@Component({
  selector: 'app-home',
  standalone: true,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
   imports: [NgIf,NgFor]

})
export class HomeComponent {
  page: HomePage = new HomePage();
  homeMovies: HomeMovie[] = [];
  homeMovie: HomeMovie = new HomeMovie();
 
  searchCriteria: string = ''; // To hold the selected dropdown value
  searchText: string = '';     // To hold the input text 

  constructor(private homeService: HomeService, private router: Router) {
    
       this.homeService.getPagesHomeMovies(this.current_page).subscribe(data => {
       this.page = data;
    });
   }

  changeTitle(newTitle:string): void {
    this.homeMovie.title = newTitle;
  }  

   // Handle dropdown changes
  onCriteriaChange(event: Event) {
    const selectElement = event.target as HTMLSelectElement;
    this.searchCriteria = selectElement.value;
  }

  // Handle input changes
  onTextChange(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    this.searchText = inputElement.value;
  }

  // Trigger search logic
  onSearch() {
    if (this.searchCriteria === 'TITLE') {
      this.router.navigate(['/search/title/', this.searchText]);
    } else if (this.searchCriteria === 'IMDB_ID') { 
      this.router.navigate(['/search/imdbId/', this.searchText]);
    } else if (this.searchCriteria === 'YEAR') {
      this.router.navigate(['/search/year/', this.searchText]);
    }
    

    // Perform your search logic here
  }

  
  ngOnInit(): void { }


  current_page: number =1;
  rows: number = 5;
 
  onPaginateChange(pageNO: number) {
    this.current_page = pageNO;
    this.getPagesHomeMovies();
  }
  
  getHomeMovies(): void {
    this.homeService.getHomeMovies().subscribe(data => {
      this.homeMovies = data
    });
  }

  getPagesHomeMovies(): void {
    this.homeService.getPagesHomeMovies(this.current_page).subscribe(data => {
      this.page = data
      });
  }

  searchFunctionality(): void {

    }

  searchMovieByTitle() {
    this.homeService.searchMovieByTitle(this.homeMovie.title).subscribe(data => {
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

  generatePagesArray(totalPages: number): number[] {
  return Array.from({ length: totalPages }, (_, index) => index + 1); // Generates an array [1, 2, ..., totalPages]
}

  
  
}