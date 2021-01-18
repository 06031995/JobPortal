import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';
import { PrincipleService } from 'app/principle.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  constructor(private adminService:AdminService,private principleService:PrincipleService) { }
    registercount:any;
    currentvacancy:any;
    appliedJob:any;
    CurrentAppliedForJob:any;
    TotalPrinciple:any;
    
     ngOnInit(): void {

      //for register count
     this.adminService.TotalCountOfRegister().subscribe(
      response=>{
        console.log("register=",response);
         this.registercount=response;
        }
      ) 

      // for current vacancy
       this.adminService.TotalCountOfCurrentvacancy().subscribe(
           response=>{
             console.log("vacancy=",response);
              this.currentvacancy=response;
      }
    )

    //for Applied for job
    this.adminService.TotalAppliedForJob().subscribe(
      response=>{
        console.log("AppliedForJob=",response);
         this.appliedJob=response;
 }
)

//for Applied for job for current
this.adminService.TotalcurrentAppliedForJob().subscribe(
  response=>{
    console.log("CurrentAppliedForJob=",response);
     this.CurrentAppliedForJob=response;
}
)

//for Applied for job for current
this.principleService.TotalPrinciple().subscribe(
  response=>{
    console.log("TotalPrinciple=",response);
     this.TotalPrinciple=response;
}
)

  
    }
}
