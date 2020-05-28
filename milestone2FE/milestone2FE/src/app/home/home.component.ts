import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from './home.service';
import { User } from './../models/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})
export class HomeComponent implements OnInit {

  loggedInUser: string;
  isAdmin: string;
  userId: string;
  approvedByAdmin: string;
  approvedByUser: string;
  notAdminUsers: User[];
  fileToUpload: File;


  constructor(private router: Router, private homeService: HomeService) { }

  ngOnInit() {
    this.loggedInUser = localStorage.getItem('loggedInUser');
    this.isAdmin = localStorage.getItem('adminFlag');
    this.userId = localStorage.getItem('userId');
    this.approvedByAdmin = localStorage.getItem('approvedByAdmin');
    this.approvedByUser = localStorage.getItem('approvedByUser');

    this.getAllNotAdminUsers();
  }

  logout() {
    localStorage.removeItem('loggedInUser');
    localStorage.removeItem('adminFlag');
    localStorage.removeItem('userId');
    localStorage.removeItem('approvedByAdmin');
    localStorage.removeItem('approvedByUser');
    this.router.navigate(['/']);
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
  }

  uploadDocument() {
    console.log('upload doc');
    const file: File = this.fileToUpload;
    console.log(file);
    console.log(this.userId);
    const formData = new FormData();
    formData.append('document', file, file.name);
    formData.append('userId', new Blob([this.userId]), 'id');
    console.log(formData);
    this.homeService.uploadDocument(+this.userId, formData).subscribe(result => {
      console.log('result', result);
      // this.getAllNotAdminUsers();
      alert('Dokumentum feltöltése sikeres volt.');
    }, error => {
      console.log(error);
      alert('Dokumentum feltöltése sikertelen volt! :(');
    });
  }

  getAllNotAdminUsers() {
    console.log('get all not admins');
    this.homeService.getAllNotAdminUsers().subscribe(result => {
      console.log('result', result);
      this.notAdminUsers = result;
    }, error => {
      console.log(error);
    });
  }

  approveDocument(studentId: number) {
    console.log('approve doc');
    console.log('stu id: ', studentId);
    console.log('admin id: ', +this.userId);
    this.homeService.approveDocument(studentId, +this.userId).subscribe(result => {
      console.log('result:', result);
      alert('Jóváhagyás sikeres! Értesítés elküldve mindkét fél részére.');
    }, error => {
      console.log(error);
      alert('Jóváhagyás sikertelen volt.');
    });
  }
}
