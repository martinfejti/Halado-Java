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
    console.log(this.userFromService);

    this.getAllNotAdminUsers();
  }

  logout() {
    this.router.navigate(['/']);
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
  }

  uploadDocument() {
    console.log('upload doc');
    const file: File = this.fileToUpload;
    console.log(file);
    const formData = new FormData();
    formData.append('document', file, file.name);
    formData.append('userId', new Blob([this.userFromService.id.toString()]), 'id');
    console.log(formData);
    this.homeService.uploadDocument(this.userFromService.id, formData).subscribe(result => {
      console.log('result', result);
      // this.getAllNotAdminUsers();
      alert('Dokumentum feltöltése sikeres volt.');
    }, error => {
      console.log(error);
      alert('Dokumentum feltöltése sikertelen volt! :(');
    });
  }

  deleteDocument() {
    console.log('delete doc');
    console.log(this.userFromService.id);

    this.homeService.deleteDocument(this.userFromService.id).subscribe(result => {
      console.log('result: ', result);
      alert('Dokumentum törlése sikeres volt');
    }, error => {
      console.log(error);
    });
  }

  downloadFile(file: Blob) {
    const blob = new Blob([file], {type: 'text/csv'});
    saveAs(blob, 'test.txt');
    /*
    const url = window.URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = 'test.txt';
    link.click();
    */
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
    console.log('admin id: ', this.userFromService.id);
    this.homeService.approveDocument(studentId, this.userFromService.id).subscribe(result => {
      console.log('result:', result);
      alert('Jóváhagyás sikeres! Értesítés elküldve mindkét fél részére.');
    }, error => {
      console.log(error);
      alert('Jóváhagyás sikertelen volt.');
    });
  }
}
