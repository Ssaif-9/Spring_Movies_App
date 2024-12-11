import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovieOperation } from './movie-operation.model';

@Injectable({
  providedIn: 'root'
})
export class MovieOperationService {

  private baseUrl = 'http://localhost:8080/api/v1/admin';

  constructor(private http: HttpClient) { }

  addMovieByImdbId(imdbId:String): Observable<any> {
    return this.http.post(`${this.baseUrl}/add/imdbId`, imdbId);
  }

  addMovieByTitle(title: String, year: String): Observable<any> {
    const searchData = { title, year };
    return this.http.post(`${this.baseUrl}/add/title`, searchData);
  }

  deleteMovieByImdbId(imdbId:String): Observable<any> {
    return this.http.post(`${this.baseUrl}/delete/imdbId`, imdbId);
  }
  

  
  addMoviesImdbIdList(imdbIdList:String[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/add/imdbIdList`, imdbIdList);
  }

  deleteMovieByImdbIdList(imdbIdList:String[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/delete/imdbIdList`, imdbIdList);
  }

  
  deleteMovieByTitle(title: String, year: string): Observable<any> {
    const searchData = { title, year };
    return this.http.post(`${this.baseUrl}/delete/title`, searchData);
  }
  
  addMoviesByTitleList(titleList:MovieOperation[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/add/titleList`, titleList);
  }

  deleteMovieByTitleList(titleList:MovieOperation[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/delete/titleList`, titleList);
  }
}
