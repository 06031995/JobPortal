import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'app/student.service';

@Component({
  selector: 'app-applied-jobbystudnet',
  templateUrl: './applied-jobbystudnet.component.html',
  styleUrls: ['./applied-jobbystudnet.component.css']
})
export class AppliedJobbystudnetComponent implements OnInit {
  sidenavWidth = 4;
  len:any;
  myresponse:any;
  constructor(private studentService:StudentService,private router:Router) { }

  ngOnInit(): void {
let student_id=localStorage.getItem('id');

    this.studentService.getStudentAppliedJob(student_id).subscribe(
      response =>{
        console.log(response);
        this.myresponse=response;
        console.log(this.myresponse);
        console.log(this.myresponse.length);
        this.len=this.myresponse.length;
      },
      error=>{
        console.log(error);
      }
    )
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
    console.log("asdasd=",localStorage.getItem('student_id'))
    this.router.navigate(['/view-profile' , localStorage.getItem('student_id')]);  
  }

  getSavedData(){
    this.router.navigate(['/saved-job']);  
  }

}
