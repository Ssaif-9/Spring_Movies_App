import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
 private baseUrl = 'http://localhost:8080/api/v1/home';
  constructor(private http: HttpClient) { }


  getFullInfo(imdbId:String): Observable<any> {
    return this.http.get(`${this.baseUrl}/gat/allInfo/${imdbId}`);
  }

  rateMovie(imdbId:String,rate:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/rate/${imdbId}/${rate}`);
  } 

  getRated(imdbId:String): Observable<any> {
    return this.http.get(`${this.baseUrl}/rate/${imdbId}`);
  }


}
