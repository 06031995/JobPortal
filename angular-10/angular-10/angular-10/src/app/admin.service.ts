import { Injectable } from '@angular/core';
import { Admin } from './admin';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  [x: string]: any;

  private baseUrl:String="http://localhost:8082/jobportal/";
  private headers = new Headers({'Content-Type':'application/json; charset=utf8'});
  private options = new RequestOptions({headers:this.headers});
  private admin:Admin =new Admin;
  constructor(private http:Http) { }


  createVacancy(admin:Admin){
     return this.http.post(this.baseUrl+'admin_login/create_vacancy',JSON.stringify(admin)).map((response:Response)=>response.json())
     .catch(this.errorHandler);
    
  }

  getList(){
    return this.http.get(this.baseUrl+'admin_login/mng_vacancy').map((response:Response)=>response.json())
    .catch(this.errorHandler); 
  }
  updateVacany(myres:any){
    return this.http.post(this.baseUrl+'admin_login/update_vacancy',JSON.stringify(myres)).map((response:Response)=>response.json())
     .catch(this.errorHandler);
  }

  deleteVacancy(delete_id:any){
    return this.http.post(this.baseUrl+'admin_login/delete_vacancy',delete_id).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }
  TotalCountOfRegister(){
    return this.http.get(this.baseUrl+'admin_login/count_of_register').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  TotalCountOfCurrentvacancy(){
    return this.http.get(this.baseUrl+'admin_login/count_of_current_vacancy').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  TotalAppliedForJob(){
    return this.http.get(this.baseUrl+'admin_login/count_of_appliedForJob').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  TotalcurrentAppliedForJob(){
    return this.http.get(this.baseUrl+'admin_login/count_of_currentappliedForJob').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  registerdStudent(){
    return this.http.get(this.baseUrl+'admin_login/registered_student').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getCompanyList(){
    return this.http.get(this.baseUrl+'admin_login/getCompanyList').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  
  getCompanyWiseList(value:any){
    return this.http.post(this.baseUrl+'admin_login/getCompanyWiseList',JSON.stringify(value)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }


  mail(upload:any){
    return this.http.post(this.baseUrl+'mail/maill',upload).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
}
