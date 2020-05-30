import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { User } from './../models/user.model';

@Injectable()
export class HomeService {

  constructor(private httpClient: HttpClient) {}

  uploadDocument(id: number, file: FormData) {
    console.log('home service');
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json'
      })
    };
    return this.httpClient.post('http://localhost:8080/uploadDocument', file, httpOptions);
  }

  getAllNotAdminUsers() {
    return this.httpClient.get<User[]>('http://localhost:8080/getAllNotAdminUsers', {});
  }

  approveDocument(studentId: number, teacherId: number) {
    console.log('home service');
    return this.httpClient.put('http://localhost:8080/approveDocument', {
      userId: studentId,
      adminId: teacherId
    });
  }

  deleteDocument(id: number) {
    console.log('home service');
    return this.httpClient.put('http://localhost:8080/deleteDocument', {
      userId: id
    });
  }
}
