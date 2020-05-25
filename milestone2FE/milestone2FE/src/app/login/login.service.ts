import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './../models/user.model';

@Injectable()
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  login(usernameParam: string, passwordParam: string) {
    console.log('service: ', usernameParam);
    console.log('service: ', passwordParam);
    // HTTP type CHECK!!!!
    return this.httpClient.post<User>('http://localhost:8080/login', {
      username: usernameParam,
      password: passwordParam
    });
  }
}
