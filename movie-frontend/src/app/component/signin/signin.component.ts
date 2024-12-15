import { Component } from '@angular/core';
import { Signin } from './signin.model';
import { SigninService } from './signin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  standalone: true,
  
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent {
  signin: Signin = new Signin();

  constructor(private signinService: SigninService, private router: Router) { }
  
  changeUserName(newUserName: string): void {
    this.signin.username = newUserName;
  }
  changePassword(newPassword: string): void {
    this.signin.password = newPassword;
  }
  changeEmail(newEmail: string): void {
    this.signin.email = newEmail;
  }
  onSignin() {
    if (!this.signin.username || !this.signin.password || !this.signin.email) {
      alert('Please enter all the details.');
      return;
    }
    this.signinService.signin(this.signin.username, this.signin.password, this.signin.email, this.signin.role).subscribe(
      (response: any) => {
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Signin failed! Please check your credentials.');
        console.error(error);
      }
    );
  }

}
