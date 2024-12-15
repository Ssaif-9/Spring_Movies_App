import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SigninService {

   private baseUrl = 'http://localhost:8080/api/v1/auth'; // Adjust the base URL as per your backend API
  
    constructor(private http: HttpClient) {}
  
    signin(username: String, password: String,email:String,role:String): Observable<any> {
      const signinData = { username, password,email,role };
      return this.http.post(`${this.baseUrl}/signin`, signinData);
    }
}
