import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HomeMovie } from './home.model';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private baseUrl = 'http://localhost:8080/api/v1/home';
 
  constructor(private http: HttpClient) { }
 
  getHomeMovies(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }
  getPagesHomeMovies(page:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/page/${page}`);
  }

  searchMovieByTitle(title: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/search/byTitle/${title}`);
  }

  searchMovieByimdbId(imdbId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/search/byImdbId/${imdbId}`);
  }

  searchMovieByYear(year: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/search/byYear/${year}`);
  }
} 
