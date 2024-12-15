import { Component, EventEmitter, Input, Output } from '@angular/core';
import { HomeService } from './home.service';
import { Router, ActivatedRoute } from '@angular/router';
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
  username: String='';

  page: HomePage = new HomePage();
  homeMovies: HomeMovie[] = [];
  homeMovie: HomeMovie = new HomeMovie();

  current_page: number =1;
  rows: number = 5;
 
  searchCriteria: string = ''; // To hold the selected dropdown value
  searchText: string = '';     // To hold the input text 

  constructor(private homeService: HomeService, private router: Router, private route: ActivatedRoute) {
    
       this.homeService.getPagesHomeMovies(this.current_page).subscribe(data => {
       this.page = data;
    });
  }

   ngOnInit() {
    // Use queryParamMap to retrieve the query parameter
    this.route.queryParamMap.subscribe(params => {
      this.username = params.get('username') || '';
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
      this.router.navigate(['/search', this.username, 'title', this.searchText]);
    } else if (this.searchCriteria === 'IMDB_ID') { 
      this.router.navigate(['/search', this.username, 'imdbId', this.searchText]);
    } else if (this.searchCriteria === 'YEAR') {
      this.router.navigate(['/search', this.username, 'year', this.searchText]);
    }
  }


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

  generatePagesArray(totalPages: number): number[] {
  return Array.from({ length: totalPages }, (_, index) => index + 1); // Generates an array [1, 2, ..., totalPages]
}

  
  
}
