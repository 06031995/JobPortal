import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { User } from 'app/user';
import { UserService } from 'app/user.service';
import {ForgotpassComponent} from '../forgotpass/forgotpass.component';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  result:any;
  show : boolean=true;
  show1 : boolean=false;
  show2 : boolean=true;
  constructor(private router:Router,private userService:UserService,public dialog: MatDialog,private modalService:NgbModal,private _snackBar: MatSnackBar) { }
  
      
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
    email : new FormControl('',Validators.required),
    password: new FormControl('',Validators.required),
    otp:new FormControl('',Validators.required),
    confirmpass:new FormControl('',Validators.required)
  });


  UserLogin(){

      this.user.email= this.Email?.value;
      this.user.password = this.Password?.value;

      this.userService.adminLogin(this.user).subscribe(
        response =>{
          let result = response;
          console.log("response="+response);
          if (result>0) {
            alert("successfully Login ");
            this.router.navigate(['/dash']);  
          } else {
            alert("please enter registered Email and password");
            window.location.reload();
          }
          
             
        },  
        
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
    return this.form.get('confirmpass');
  }
  AdminEmail(){
    this.user.email=this.Email?.value;
    this.userService.adminSendOtp(this.user).subscribe(
      response=>{
        if (response>0) {
          this.show=false;
          this.result=response;
          console.log("otp=",this.result);
        } else {
          this.openSnackBar();
        }
      }
    )
  }
  AdminOtp(){
    let otp = this.Otp?.value;
    if (this.result==otp) {
      this.show=true;
      this.show2=false;
        this.show1=true;
    } else {
      
    }
  }
  AdminNewPass(){
    let pass = this.Password?.value;
    let confirmpass = this.ConfirmPassword?.value;
    if(pass==confirmpass){
      this.openSnackBar4();
      this.user.email= this.Email?.value;
      this.user.password = this.Password?.value;
      this.userService.setAdminNewPass(this.user).subscribe(
        response =>{ 
          if(response<=0){
              console.log("res==",response);
              this.router.navigate(['/admin_login']);

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
  
 


