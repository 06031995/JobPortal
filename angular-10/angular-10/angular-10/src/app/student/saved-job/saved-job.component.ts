import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-saved-job',
  templateUrl: './saved-job.component.html',
  styleUrls: ['./saved-job.component.css']
})
export class SavedJobComponent implements OnInit {
  sidenavWidth = 4;
  myresponse:any;
  myresponse1:any;
  constructor(private router:Router) { }

  ngOnInit(): void {
this.myresponse=localStorage.getItem('create_vacancy');
this.myresponse1=JSON.parse(this.myresponse);
console.log('this.myresponse1=',this.myresponse1);

  }
  increase() {
    this.sidenavWidth = 15;
    console.log('increase sidenav width');
  }
  decrease() {
    this.sidenavWidth = 4;
    console.log('decrease sidenav width');
  }

  getadminId(){
    this.router.navigate(['/view-profile' , localStorage.getItem('id')]);  
  }

  getSavedData(){
    this.router.navigate(['/saved-job']);  
  }


}
