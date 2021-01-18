import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'app/user';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.css']
})
export class ForgotpassComponent implements OnInit {

  private user =new User();
  constructor(private userservice:UserService, private router:Router) { }

  ngOnInit(): void {
  }
  form = new FormGroup({
    
    email : new FormControl('',Validators.required),
    
  });
SendOtp(){
  let pass = this.Password?.value;
  let confirmPass = this.Confirmpassword?.value;  
  if(pass == confirmPass)  
  {  
   
     this.user.email = this.Email?.value;  
    
    

     this.userservice.sendOtp(this.user).subscribe(  
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

