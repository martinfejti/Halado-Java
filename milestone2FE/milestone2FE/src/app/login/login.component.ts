import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { User } from './../models/user.model';
import { StoreService } from './../store/store.service';

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

  constructor(private loginService: LoginService, private router: Router, private storeService: StoreService) { }

  ngOnInit() {
  }

  login() {
    if (this.username && this.password) {
      this.loginService.login(this.username, this.password).subscribe(result => {
        console.log('result: ', result);
        this.user = result;
        this.storeService.storeUser(result);
        this.router.navigate(['/home']);
      }, error => {
        console.log('error', error);
        alert('Hibás felhasználónév vagy jelszó!');
      });
    } else {
      alert('Mezők kitöltése kötelező!');
    }
  }

}
