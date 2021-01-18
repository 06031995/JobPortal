import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Principle } from './principle';
@Injectable({
  providedIn: 'root'
})
export class PrincipleService {

  private baseUrl:String="http://localhost:8082/jobportal/";
  private headers = new Headers({'Content-Type':'application/json; charset=utf8'});
private principle = new Principle();
  constructor(private http : Http) { }

  createPrincipleProfile(principle:Principle){
    // var merged = Object.assign(file, student);
    // console.log(merged); 
     return this.http.post(this.baseUrl+'principle/save_principle',JSON.stringify(principle)).map((response:Response)=>response.json())
     .catch(this.errorHandler);
    
  }

  TotalPrinciple(){
    return this.http.get(this.baseUrl+'principle/totalPrinciple').map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getPrincipleList(){
    return this.http.get(this.baseUrl+'principle/principle_list').map((response:Response)=>response.json())
    .catch(this.errorHandler); 
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
}
