import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'app/user';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-principle-register',
  templateUrl: './principle-register.component.html',
  styleUrls: ['./principle-register.component.css']
})
export class PrincipleRegisterComponent implements OnInit {
 
  private user = new User();
  constructor(private userService : UserService,private router:Router) { }

  ngOnInit(): void {
  }
  form = new FormGroup({
    name :  new FormControl('',Validators.required),
    email : new FormControl('',Validators.required),
    password : new FormControl('',Validators.required),
    confirmpassword : new FormControl('' , Validators.required),  
  });

  userForm(){
    let pass = this.Password?.value;
    let confirmpassword = this.Confirmpassword?.value;
    if(pass == confirmpassword){
      this.user.name = this.Name?.value;
      this.user.email = this.Email?.value;
      this.user.password = this.Password?.value;
      this.userService.principleRegister(this.user).subscribe(
        response=>{
          console.log(response);
          let result = response;  
 
          if(result > 0)  
          {  
           this.router.navigate(['/principal-login']);  
          }  
          else  
          {  
              alert("error occur while registring User. please try after sometime.");
          } 
        },
        error=>{
          console.log(error);
        }
      )
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
