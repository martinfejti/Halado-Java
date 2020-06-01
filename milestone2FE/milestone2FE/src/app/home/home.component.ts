import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeService } from './home.service';
import { User } from './../models/user.model';
import { saveAs } from 'file-saver';
import { StoreService } from './../store/store.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})
export class HomeComponent implements OnInit {

  userFromService: User;
  notAdminUsers: User[];
  fileToUpload: File;


  constructor(private router: Router, private homeService: HomeService, private storeService: StoreService) { }

  ngOnInit() {
    this.userFromService = this.storeService.getUser();
    this.getAllNotAdminUsers();
  }

  logout() {
    this.router.navigate(['/']);
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
  }

  uploadDocument() {
    const file: File = this.fileToUpload;
    const formData = new FormData();
    formData.append('document', file, file.name);
    formData.append('userId', new Blob([this.userFromService.id.toString()]), 'id');
    this.homeService.uploadDocument(this.userFromService.id, formData).subscribe(result => {
      console.log('result', result);
      alert('Dokumentum feltöltése sikeres volt.');
      this.storeService.getUserById(this.userFromService.id).subscribe(newResult => {
        console.log('new result: ', newResult);
        this.userFromService = newResult;
      }, error => {
        console.log(error);
        alert('Hiba történt az oldal újratöltése közben');
      });
    }, error => {
      alert('Dokumentum feltöltése sikertelen volt');
    });
  }

  deleteDocument() {
    this.homeService.deleteDocument(this.userFromService.id).subscribe(result => {
      console.log('result: ', result);
      alert('Dokumentum törlése sikeres volt');
      this.storeService.getUserById(this.userFromService.id).subscribe(newResult => {
        console.log('new result: ', newResult);
        this.userFromService = newResult;
      }, error => {
        console.log(error);
        console.log('Hiba történt az oldal újratöltése közben');
      });
    }, error => {
      console.log(error);
      alert('Dokumentum törlése sikertelen volt');
    });
  }

  downloadFile(file: Blob) {
    const blob = new Blob([file], {type: 'text/csv'});
    saveAs(blob, 'downloaded_file.txt');
  }

  getAllNotAdminUsers() {
    this.homeService.getAllNotAdminUsers().subscribe(result => {
      console.log('result', result);
      this.notAdminUsers = result;
    }, error => {
      console.log(error);
    });
  }

  approveDocument(studentId: number) {
    this.homeService.approveDocument(studentId, this.userFromService.id).subscribe(result => {
      console.log('result:', result);
      alert('Jóváhagyás sikeres! Értesítés elküldve mindkét fél részére.');
      this.getAllNotAdminUsers();
    }, error => {
      console.log(error);
      alert('Jóváhagyás sikertelen volt.');
    });
  }

  refuseDocument(id: number) {
    this.homeService.refuseDocument(id).subscribe(result => {
      console.log('result: ', result);
      alert('Értesítés sikeresen elküldve');
    }, error => {
      console.log(error);
      alert('Hiba történt az értesítés elküldése közben');
    });
  }
}
