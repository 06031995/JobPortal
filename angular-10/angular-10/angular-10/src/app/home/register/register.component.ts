import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User} from '../../user';
import {UserService} from '../../user.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

 private user = new User();
  
  constructor( private userservice:UserService,private router : Router) { }  
  
  ngOnInit() {  
  } 
  
  form = new FormGroup({
    name :  new FormControl('',Validators.required),
    email : new FormControl('',Validators.required),
    password : new FormControl('',Validators.required),
    confirmpassword : new FormControl('' , Validators.required),  
  });
  userForm(){
    let pass = this.Password?.value;
    let confirmPass = this.Confirmpassword?.value;  
    if(pass == confirmPass)  
    {  
      this.user.name=this.Name?.value;
       this.user.email = this.Email?.value;  
       this.user.password = this.Password?.value;  
       this.user.confirmpassword = this.Confirmpassword?.value;

       var email={
         "email":this.user.email
       }
   this.userservice.checkUser(email).subscribe(
     response=>{

       console.log(response);
       if(response>0){
         alert("Email already exists");
       }else{
        this.userservice.saveUser(this.user).subscribe(  
          response => {  
              let result = response;  
  
              if(result > 0)  
              {  
                this.router.navigate(['/student-login']);  
              }  
              else  
              {  
                  alert("error occur while registring User. please try after sometime.");
              }  
          },  
          error => {  
            alert("error occur while registring User. please try after sometime.");  
          }  
        ); 
       }
     },
     error=>{
       console.log(error);
     }
   )
        
         
    }  
    else  
    {  
       alert("Password and confirm password not match.");  
    }

  }
  
  get Name(){  
    return this.form.get('name');  
  } 
  get Email(){
      return this.form.get('email');
  }
  get Password(){
    return this.form.get('password');
}
get Confirmpassword(){
  return this.form.get('confirmpassword');
}
}  
