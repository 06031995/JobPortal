import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';


@Component({
  selector: 'app-applied-students',
  templateUrl: './applied-students.component.html',
  styleUrls: ['./applied-students.component.css']
})
export class AppliedStudentsComponent implements OnInit {

 

  constructor(private adminService:AdminService) { }
  myresponse:any;
  myresponse1:any;
  ngOnInit(): void {

    this.adminService.getCompanyList().subscribe(
      response =>{
        console.log(response);
        this.myresponse=response;
      },
      error=>{
        console.log(error);
      }
    )
  }

  onClickSubmit(value: any){

console.log("afasf",value);

this.adminService.getCompanyWiseList(value).subscribe(
  response =>{
    console.log(response);
    this.myresponse1=response;
    let data =value['company_name'];
    localStorage.setItem("company_name",data); 
    console.log("value="+localStorage.getItem('company_name'));
  },
  error=>{
    console.log(error);
  }
)
  }

}
