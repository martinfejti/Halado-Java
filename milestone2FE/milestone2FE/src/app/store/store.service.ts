import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  user: User;

  constructor() { }

  storeUser(user: User) {
    this.user = user;
  }

  getUser(): User {
    return this.user;
  }
}
