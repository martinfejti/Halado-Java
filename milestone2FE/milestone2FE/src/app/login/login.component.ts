import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { User } from './../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  user: User;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    console.log(this.username);
    console.log(this.password);
    if (this.username && this.password) {
      this.loginService.login(this.username, this.password).subscribe(result => {
        console.log('result: ', result);
        this.user = result;
        localStorage.setItem('loggedInUser', this.user.username);
        localStorage.setItem('adminFlag', JSON.stringify(this.user.isAdmin));
        localStorage.setItem('userId', JSON.stringify(this.user.id));
        localStorage.setItem('approvedByAdmin', JSON.stringify(this.user.documentIsApprovedByAdmin));
        localStorage.setItem('approvedByUser', JSON.stringify(this.user.documentIsApprovedByUser));
        this.router.navigate(['/home']);
      }, error => {
        console.log('error', error);
      });
    }
  }

}
