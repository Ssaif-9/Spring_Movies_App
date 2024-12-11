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

  searchMovieByTitle(title: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${title}`);
  }

  searchMovieByimdbId(imdbId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${imdbId}`);
  }

  searchMovieByYear(year: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${year}`);
  }
} 
