import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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
    return this.http.post(`${this.baseUrl}/addList/imdbId`, imdbIdList);
  }

  deleteMovieByImdbIdList(imdbIdList:String[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/deleteList/imdbId`,imdbIdList);
  }

  
  deleteMovieByTitle(title: String, year: string): Observable<any> {
    const searchData = { title, year };
    return this.http.post(`${this.baseUrl}/delete/title`, searchData);
  }
  
  addMoviesByTitleList(titleList:[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/add/titleList`, titleList);
  }

  deleteMovieByTitleList(titleList:[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/delete/titleList`, titleList);
  }
}
