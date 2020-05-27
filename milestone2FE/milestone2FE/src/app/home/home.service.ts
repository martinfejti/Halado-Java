import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './../models/user.model';

@Injectable()
export class HomeService {

  constructor(private httpClient: HttpClient) {}

  uploadDocument(id: number, uploadedFile: File) {
    console.log('home service');
    return this.httpClient.put('http://localhost:8080/uploadDocument', {
      userId: id,
      document: uploadedFile
    });
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
}
