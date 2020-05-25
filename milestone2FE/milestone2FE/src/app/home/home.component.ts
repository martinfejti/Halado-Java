import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from './home.service';

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


  constructor(private router: Router, private homeService: HomeService) { }

  ngOnInit() {
    this.loggedInUser = localStorage.getItem('loggedInUser');
    this.isAdmin = localStorage.getItem('adminFlag');
    this.userId = localStorage.getItem('userId');
    this.approvedByAdmin = localStorage.getItem('approvedByAdmin');
    this.approvedByUser = localStorage.getItem('approvedByUser');
    console.log(this.isAdmin);
  }

  logout() {
    localStorage.removeItem('loggedInUser');
    localStorage.removeItem('adminFlag');
    localStorage.removeItem('userId');
    localStorage.removeItem('approvedByAdmin');
    localStorage.removeItem('approvedByUser');
    this.router.navigate(['/']);
  }

  uploadDocument() {
    console.log('upload doc function');
    this.homeService.uploadDocument(+this.userId).subscribe(result => {
      console.log('result', result);
    }, error => {
      console.log(error);
    });
  }
}
