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
  uploadedFile: File;


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

  uploadDocument(uploadedFile: File) {
    console.log('upload doc');
    console.log(uploadedFile);
    this.homeService.uploadDocument(+this.userId, uploadedFile).subscribe(result => {
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
