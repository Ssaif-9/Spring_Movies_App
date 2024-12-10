import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './login.service';
import { Login } from './login.model';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  login:Login =new Login();

  constructor(private authService: AuthService, private router: Router) {}

  changeUserName(newUserName:string): void {
        this.login.username = newUserName;
  }
   changePassword(newPassword:string): void {
        this.login.password = newPassword;
    }

  onLogin() {
    if (!this.login.username || !this.login.password) {
      alert('Please enter both username and password.');
      return;
    }
    this.authService.login(this.login.username, this.login.password).subscribe(
      (response: any) => {
        const role = response?.role;  // Safely extract 'role'
        const username = response?.username;  // Safely extract 'username'
        
        if (role === 'ADMIN') {
          this.router.navigate(['/dashboard']);
        } else if (role === 'USER') {
          this.router.navigate(['/home']);
        } else {
          alert('Unauthorized role!');
        }
      },
      (error) => {
        alert('Login failed! Please check your credentials.');
        console.error(error);
      }
    );
  }
}


