import { Component, OnInit } from '@angular/core';
import {AdminService} from '../../admin.service';
@Component({
  selector: 'app-create-vacancy',
  templateUrl: './create-vacancy.component.html',
  styleUrls: ['./create-vacancy.component.css']
})
export class CreateVacancyComponent implements OnInit {

  constructor(private adminService:AdminService) { }

  sidenavWidth = 4;
  ngStyle: string='';
  

  ngOnInit() {

  }

  increase() {
    this.sidenavWidth = 15;
    console.log('increase sidenav width');
  }
  decrease() {
    this.sidenavWidth = 4;
    console.log('decrease sidenav width');
  }
  // sidenavToggle() {
  //   this.ngStyle = 'this.sidenavWidth = 15';
  //   console.log('sidenav width incrases');
  // }
  moveToSelectedTab(tabName: string) {
    for (let i =0; i< document.querySelectorAll('.mat-tab-label-content').length; i++) {
    if ((<HTMLElement>document.querySelectorAll('.mat-tab-label-content')[i]).innerText == tabName) 
       {
          (<HTMLElement>document.querySelectorAll('.mat-tab-label')[i]).click();
       }
     }
  }

  onClickSubmit(value: any){
    console.log("value",value);
    this.adminService.createVacancy(value).subscribe((student: any)=>{
      console.log(student);
    },(error: any)=>{
      console.log(error);
    });
  }
}
