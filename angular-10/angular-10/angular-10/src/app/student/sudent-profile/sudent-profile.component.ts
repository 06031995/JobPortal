import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Student } from '../../student';
import { StudentService } from '../../student.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-sudent-profile',
  templateUrl: './sudent-profile.component.html',
  styleUrls: ['./sudent-profile.component.css']
})
export class SudentProfileComponent implements OnInit {


  public imagePath: any;
  imgURL: any;
  public message: string="";
  show:boolean=false;
  gendr:any;
  show1:boolean=false;
  show2:boolean=true;
  value1:any;
  pnamePattern = "^[a-zA-Z\s]+$";
  id:any;

  selectedFiles!: FileList;  
  currentFileUpload: any;  
  fileData: string | Blob='';

  constructor(private _formBuilder: FormBuilder,private userService:UserService,private studentService:StudentService,private http: HttpClient,private modalService:NgbModal,
    private router:Router, private route : ActivatedRoute) { }
  private student = new Student(); 
 
  
  ngOnInit(): void {
    let register_id =localStorage.getItem('register_id');
    console.log("re_id====",register_id);
    this.studentService.checkRegisterId(register_id).subscribe(
      response =>{
        console.log(response);
        if(response>0){
          alert("your profile already exist..plz check existing profile");
          this.show2=false;
        }else{
          alert("Create Profile");
          this.show2=true;
        }
      },
      error=>{
        console.log(error);
      }
    )

  
  }



 

selectFile(event: any) {  
  const file = event.target.files.item(0);  
 
  if (file.type.match('image.*')) {  
    var size = event.target.files[0].size;  
    if(size > 1000000)  
    {  
        alert("size must not exceeds 1 MB");  
        // this.form.get('profileImage').setValue("");  
    }  
    else  
    {  
      this.selectedFiles = event.target.files;  
    }  
  } else {  
    alert('invalid format!');  
  }  

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
  onClickSubmit(value:any){
    // if(this.selectedFiles != null)  
    // {  
    //   this.currentFileUpload = this.selectedFiles.item(0);  
    //   console.log(this.currentFileUpload); 
    // } 
   
    console.log("value",value);
    var obj = {gender:this.gendr};
    var merged = Object.assign(value, obj);
    console.log(merged);
    this.studentService.createStudentProfile(merged).subscribe((student: any)=>{
      this.id=student;
      localStorage.setItem("student_id",this.id);
      console.log(student);
      // this.router.navigate(['/view-student-profile',student]);  
      // this.value1 = student;
      // this.studentService.setId(this.value1);
    },(error: any)=>{
      console.log(error);
    });
    
    }

    // moveToOthercompo(){
    //   this.router.navigate(['/view-student-profile',this.id]);  
    // }

    gender(value1: any){
      console.log(value1);
      if(value1==1)
      {
        this.gendr="Male";
      }else{
        this.gendr="Female";
      }
    }
  
 
  preview(files: string | any[]) {
    if (files.length === 0)
      return;
 
    var mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = "Only images are supported.";
      return;
    }
 
    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result; 
    }
  }

  method(){
    this.show=true;
  }
  radioYes(){
    this.show=true;
  }

  radioNo(){
    this.show=false;
  }

  moveToSelectedTab(tabName: string) {
    for (let i =0; i< document.querySelectorAll('.mat-tab-label-content').length; i++) {
    if ((<HTMLElement>document.querySelectorAll('.mat-tab-label-content')[i]).innerText == tabName) 
       {
          (<HTMLElement>document.querySelectorAll('.mat-tab-label')[i]).click();
       }
     }
  }

  moveToProfile(){
    this.show1=true;
  }

  // getData(){
  //   console.log("enter in main");
  // }

  
  
   

}