import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router, RouterEvent } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { StudentService } from 'app/student.service';
import { UserService } from 'app/user.service';
import { ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-view-student-profile',
  templateUrl: './view-student-profile.component.html',
  styleUrls: ['./view-student-profile.component.css']
})
export class ViewStudentProfileComponent implements OnInit {
  [x: string]: any;
  constructor(private userService:UserService,private studentService:StudentService,private http: HttpClient,private modalService:NgbModal,
    private router:Router, private route : ActivatedRoute) { }
  value2:any;
  private adminId:any;
  myresponse1:any;
  myresponse2:any;
  sidenavWidth = 4;
  ngStyle: string='';
  i:number=0;
  cv_id:any;
  student_id:any;
  

  ngOnInit() {

    // if((this.userService.isLoggedIn1()) )  
    // {  
    //   this.router.navigate(['/view-profile' , localStorage.getItem('id')]);   
    // }  
    // else  
    // {  
    //     this.router.navigate(['/login']);  
    // }  

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

  getadminId(){
    console.log("asdasd=",localStorage.getItem('student_id'))
    this.router.navigate(['/view-profile' , localStorage.getItem('student_id')]);  
  }
  onClickSubmit(value:any){
    console.log(value); 
    this.studentService.getVacancy(value).subscribe(

      response=>{

        if(response!=null){
          console.log(response);
        this.myresponse=response;
        }else{
          alert("Field Not Search");
        }
       
      },
      error=>{
console.log(error);
      }
    )

  }

  getData(id: any){
    console.log("id=",id);
    console.log(localStorage.getItem('student_id'));
    //console.log(this.myresponse[0]);
    for(this.i=0;this.i<this.myresponse.length;this.i++){
      // console.log(this.myresponse[this.i].cv_id);
    if(id==this.myresponse[this.i].cv_id){
      this.cv_id= this.myresponse[this.i].cv_id;
      this.student_id=localStorage.getItem('student_id');
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
        // "student_id":localStorage.getItem('id')

      }
      this.myresponse1=data;
     
      console.log(this.myresponse1);
      console.log("tadt");
      break;
    }
  }
}

saveid(){
  var applied={
    "cv_id":this.cv_id,
    "student_id":this.student_id

  }
  console.log("student_id:",this.student_id);

  //let id1= JSON.stringify({"cv_id": this.cv_id, "student_id": this.student_id}); //used for variable merge into json
  //console.log(id1);
  this.studentService.saveId(JSON.stringify(applied)).subscribe(
    response=>{
      console.log(response);
      alert("succssefully applied for this job");
      location.reload();
    },error=>{
      console.log(error);
    }
  )
  // var merged = Object.assign(this.cv_id,  this.student_id); // used for object merging
  //    console.log(merged); 
}

getSavedData(){
  this.router.navigate(['/saved-job']);  
}

saveData(id:any){
  console.log("id=",id);
  for(this.i=0;this.i<this.myresponse.length;this.i++){
  if(id==this.myresponse[this.i].cv_id){
     //this.cv_id= this.myresponse[this.i].cv_id;
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
      // "student_id":localStorage.getItem('id')

    }
    this.myresponse2=data;
   
    console.log(this.myresponse2);
    localStorage.setItem("create_vacancy",JSON.stringify(this.myresponse2));
    console.log("tadt");
    break;
  }
}
}

}
