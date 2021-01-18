import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Student } from 'app/student';
import { StudentService } from 'app/student.service';
import { UserService } from 'app/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {
  constructor(private userService:UserService,private studentService:StudentService,private http: HttpClient,private modalService:NgbModal,
    private router:Router, private route : ActivatedRoute) { }
    show:boolean=true;
    
 value2:any;
  sidenavWidth = 4;
  ngStyle: string='';
  student:any;
  private adminId:any; 
  fname_readonly=true;
  mname_readonly=true;
  lname_readonly=true;
  contact_no_readonly=true;
  dob_readonly=true;
  email_id_readonly=true;
  address_readonly=true;
  clg_name_10_readonly=true;
  passing_yr_10_readonly=true;
  percent_10_readonly=true;
  clg_name_12_readonly=true;
  passing_yr_12_readonly=true;
  percent_12_readonly=true;
  degree_readonly=true;

  passing_yr_degree_readonly=true;
  percent_degree_readonly=true;
  last_org_readonly=true;
  exp_years_readonly=true;
  last_ctc_readonly=true;
  notice_period_readonly=true;

  key_skills_readonly=true;
  projects_readonly=true;
  certifications_readonly=true;






  update(){
    this.fname_readonly=false;
    this.mname_readonly=false;
    this.lname_readonly=false;
    this.contact_no_readonly=false;
    this.dob_readonly=false;
    this.email_id_readonly=false;
    this.address_readonly=false;
    this.clg_name_10_readonly=false;
    this.passing_yr_10_readonly=false;
    this.percent_10_readonly=false;
    this.clg_name_12_readonly=false;
    this.passing_yr_12_readonly=false;
    this.percent_12_readonly=false;
    this.degree_readonly=false;
  
    this.passing_yr_degree_readonly=false;
    this.percent_degree_readonly=false;
    this.last_org_readonly=false;
    this.exp_years_readonly=false;
    this.last_ctc_readonly=false;
    this.notice_period_readonly=false;
  
    this.key_skills_readonly=false;
    this.projects_readonly=false;
    this.certifications_readonly=false;
    this.show=false;
  }

  // students: Observable<Student[]> | undefined; 

  ngOnInit() {

    if((this.userService.isLoggedIn1()) )  
    {  
      this.route.paramMap.subscribe(params => {  
        this.adminId = params.get('adminId');  
        console.log("adminId=",this.adminId)
      });  
    }  
    else  
    {  
        this.router.navigate(['/login']);  
    }  

    // this.value2=this.studentService.getId();
    // console.log("id===",this.value2);
    this.studentService.getStudentData(this.adminId).subscribe(
      response =>{
          this.student=response;
          console.log(this.student);
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
  save(st:any){
    console.log("st===",st);
    this.studentService.saveUpdateStudent(st).subscribe(
      response=>{
        console.log("response=",response);
        this.router.navigate(['/view-student-profile']);
      },
      error=>{
  console.log(error);
  
      }
    )
  }

  getadminId(){
    this.router.navigate(['/view-profile' , localStorage.getItem('student_id')]);  
  }

  getSavedData(){
    this.router.navigate(['/saved-job']);  
  }





}

