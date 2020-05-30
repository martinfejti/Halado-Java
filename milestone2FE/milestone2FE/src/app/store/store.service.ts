import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  user: User;

  constructor(private httpClient: HttpClient) { }

  storeUser(user: User) {
    this.user = user;
  }

  getUser(): User {
    return this.user;
  }

  getUserById(id: number) {
    return this.httpClient.post<User>('http://localhost:8080/getUserById', {
      userId: id
    });
  }
}
