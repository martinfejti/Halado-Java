import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HomeService {

  constructor(private httpClient: HttpClient) {}

  uploadDocument(id: number) {
    console.log('service: ', id);
    return this.httpClient.put('http://localhost:8080/uploadDocument', {
      userId: id
    });
  }
}
