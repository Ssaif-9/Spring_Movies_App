import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DachboardService {

  private baseUrl = 'http://localhost:8080/api/v1/admin';
  constructor(private http: HttpClient) { }

  getMoviesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteMovieByImdbId(imdbId:String): Observable<any> {
    return this.http.post(`${this.baseUrl}/delete/imdbId`, imdbId);
  }

  
}
