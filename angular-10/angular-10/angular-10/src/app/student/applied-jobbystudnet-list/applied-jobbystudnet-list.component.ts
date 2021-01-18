import { Component, OnInit } from '@angular/core';
import { StudentService } from 'app/student.service';
import { ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
  selector: 'app-applied-jobbystudnet-list',
  templateUrl: './applied-jobbystudnet-list.component.html',
  styleUrls: ['./applied-jobbystudnet-list.component.css']
})
export class AppliedJobbystudnetListComponent implements OnInit {

  sidenavWidth = 4;
  myresponse:any;
  index=1;
  i:number=0;
  myresponse1:any;

  constructor(private studentService:StudentService,private modalService:NgbModal,private router:Router) { }

  ngOnInit(): void {
    let student_id=localStorage.getItem('id');

    this.studentService.getStudentAppliedJob(student_id).subscribe(
      response =>{
        console.log(response);
        this.myresponse=response;
        console.log(this.myresponse);
        console.log(this.myresponse.length);
       // this.len=this.myresponse.length;
      },
      error=>{
        console.log(error);
      }
    )
  }

  closeResult: string | undefined;
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result:any) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason:any) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }


  
  viewVacancy(cv_id:any){

    for(this.i=0;this.i<this.myresponse.length;this.i++){
    if(cv_id==this.myresponse[this.i].cv_id){
      var data={
        "cv_id":this.myresponse[this.i].cv_id,
        "post":this.myresponse[this.i].post,
        "company_name":this.myresponse[this.i].company_name,
        "year_of_exp":this.myresponse[this.i].year_of_exp,
        "vacancy":this.myresponse[this.i].vacancy,
        "location":this.myresponse[this.i].location,
        "salary":this.myresponse[this.i].salary,
        "required_skill":this.myresponse[this.i].required_skill,
        "job_desc":this.myresponse[this.i].job_desc,
        "industry_type":this.myresponse[this.i].industry_type,
        "function_area":this.myresponse[this.i].function_area,
        "role":this.myresponse[this.i].role,
        "employment_type":this.myresponse[this.i].employment_type,
        "education":this.myresponse[this.i].education,
        "website":this.myresponse[this.i].website,
        "address":this.myresponse[this.i].address,

      }
      this.myresponse1=data;
      console.log(this.myresponse1);
      break;
    }
  }

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
