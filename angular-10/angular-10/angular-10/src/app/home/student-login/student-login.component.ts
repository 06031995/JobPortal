import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { User } from 'app/user';
import { UserService } from 'app/user.service';
import {ForgotpassComponent} from '../forgotpass/forgotpass.component';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {ModalDirective} from 'ngx-bootstrap/modal';

import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {
 

  pnamePattern = "^[a-zA-Z\s]+$";
  show:boolean=true;
  result:any;
  show1:boolean=false;
  show2:boolean=true;

  constructor(private _snackBar: MatSnackBar,private router:Router,private userService:UserService,public dialog: MatDialog,private modalService:NgbModal) { }
  
      
  private user = new User();  

  ngOnInit(): void {
  
    if(this.userService.isLoggedIn())   
    {  
        this.router.navigate(['/main']);  
    }  
    else  
    {  
        this.router.navigate(['/login']);  
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


  form= new FormGroup({
   // email: ['', [Validators.required, Validators.email]],
    email : new FormControl('',Validators.required,),
    password: new FormControl('',Validators.required),
    otp:new FormControl('',Validators.required),
    confirmpassword: new FormControl('',Validators.required),
  });


  UserLogin(){

      this.user.email= this.Email?.value;
      this.user.password = this.Password?.value;

      this.userService.saveLogin(this.user).subscribe(
        response =>{
          let result = response;
          console.log("response="+response);
          if(result>0){

         let token = this.userService.token(); 
         console.log("token="+token);
        //  if(token!=null){
        //       localStorage.setItem("token",token);  
        //       localStorage.setItem("id" , result); 
        //       console.log("Id==",result);
        //  }
         //localStorage.setItem("token",token);  
         localStorage.setItem("register_id" , result); 
         console.log("Id==",result);
              this.router.navigate(['/student-profile']);  
            }  
            if(result == -1)  
            {  
              alert("please register before login Or Invalid combination of Email and password");  
            }  
             
        },  
        error => {  
            console.log("Error in authentication");  
        }  
            );  


  }


  get Email(){
    return this.form.get('email');
  }

  get Password(){
    return this.form.get('password');
  }
  get Otp(){
    return this.form.get('otp');
  }

  get ConfirmPassword(){
    return this.form.get('confirmpassword');
  }

  UserEmail(){
    this.user.email= this.Email?.value;

    console.log("mail=",this.user.email);

    this.userService.sendOtp(this.user).subscribe(
      
      response =>{
        if(response>0){
          this.openSnackBar();
        this.show=false;
        this.result=response;
        console.log("response=",response);     
        }
        else{
            this.openSnackBar1();
        }
      }
      
    )
  }
  getOtp(){
    let otp = this.Otp?.value;
    if(this.result==otp){
      this.show=true;
      this.show2=false;
        this.show1=true;
    }
    else{
      this.openSnackBar2();
    }

      
  }

  newPass(){
    let pass = this.Password?.value;
    let confirmpass = this.ConfirmPassword?.value;
    if(pass==confirmpass){
      this.openSnackBar4();
      this.user.email= this.Email?.value;
      this.user.password = this.Password?.value;
      this.userService.setNewPass(this.user).subscribe(
        response =>{
          if(response<=0){
              console.log("res==",response);
          }else{
            console.log("res==",response);
          }

        }
      )
    }
    else{
      this.openSnackBar3();
    }

  }

  openSnackBar(){
    this._snackBar.open('OTP is sent on your mail', '', {
      duration: 3000,
    });

  }
  openSnackBar1(){
    this._snackBar.open('please enter valid mail', '', {
      duration: 3000,
    });

  }
  openSnackBar2(){
    this._snackBar.open('please enter valid otp', '', {
      duration: 3000,
    });

  }
  openSnackBar3(){
    this._snackBar.open('password and confirm password is not matched', '', {
      duration: 3000,
    });

  }
  openSnackBar4(){
    this._snackBar.open('Password is set...you can login with new Password', '', {
      duration: 3000,
    });

  }
  
  
   
  
  }
  
 

