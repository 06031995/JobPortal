import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from './user';

import { JwtHelperService } from '@auth0/angular-jwt'; 

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // Base URL  
  private  baseUrl = "http://localhost:8082/jobportal/user/";  
  private  baseUrl1 = "http://localhost:8082/jobportal/admin_login/"; 

  constructor(private http: HttpClient, private router : Router) { }  
  
  saveUser(user : User) : Observable<any>  
  {  
      let url = this.baseUrl + "saveUserDetail";  
      return this.http.post(url,user);  
  }  
  sendOtp(user : User) : Observable<any>  
  {  
      let url = this.baseUrl + "sendOtp";  
      let otp = this.http.post(url,user);  
      return otp;
  } 
  saveLogin(user : User) : Observable<any>
   {
    let url = this.baseUrl + "saveLogin";  
    return this.http.post(url,user);
  }

  setNewPass(user : User) : Observable<any>{
    let url = this.baseUrl + "newPass";  
    return this.http.post(url,user);
  }


  adminLogin(user : User) : Observable<any>
   {
    let url = this.baseUrl1 + "adminLogin";  
    return this.http.post(url,user);
  }
  adminSendOtp(user : User) : Observable<any>
  {
    let url = this.baseUrl1 + "adminSendOtp";  
    return this.http.post(url,user);
  }
  setAdminNewPass(user : User) : Observable<any>
  {
    let url = this.baseUrl1 + "adminNewPass";  
    return this.http.post(url,user);
  }

 

  token(){
    let token = localStorage.getItem('token');
    console.log("token=",token);
    return token;
  }
  isLoggedIn(){
      // create an instance of JwtHelper class.  
      let jwtHelper = new JwtHelperService();  
  
      // get the token from the localStorage as we have to work on this token.  
      let token = localStorage.getItem('token');  
    console.log("tok=",token);
      // check whether if token have something or it is null.  
      if(!token)  
      {  
        console.log("meghaservices");
        return false;  
      }  
    
      // get the Expiration date of the token by calling getTokenExpirationDate(String) method of JwtHelper class. this method accepts a string value which is nothing but a token.  
    
      if(token)  
      {  
        let expirationDate = jwtHelper.getTokenExpirationDate(token);  
        console.log("expirationDate=",expirationDate);
    
        // check whether the token is expired or not by calling isTokenExpired() method of JwtHelper class.  
    
        let isExpired = jwtHelper.isTokenExpired(token);  
        console.log("isExpired",isExpired)
    
        return !isExpired;      
      }     
  }

  isLoggedIn1(){
    return true;
  }

  principleRegister(user : User) : Observable<any>  
  {
    let url = this.baseUrl + "prinipleRegister";  
      return this.http.post(url,user);
  }
  savePrincipleLogin(user : User) : Observable<any>
  {
    let url = this.baseUrl + "prinipleLogin";  
      return this.http.post(url,user);
  }
  sendPrincipleOtp(user : User) : Observable<any>
  {
    let url = this.baseUrl + "sendPrincipleOtp";  
    return this.http.post(url,user);
  }
  setNewPrinciplePass(user : User) : Observable<any>
  {
    let url = this.baseUrl + "setNewPrinciplePass";  
    return this.http.post(url,user);
  }
  checkUser (email:any) : Observable<any>
  {
    let url = this.baseUrl + "checkeuser";  
    return this.http.post(url,email);
  }
}
