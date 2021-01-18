import { Injectable } from '@angular/core';
import { Student } from './student';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl:String="http://localhost:8082/jobportal/";
  private headers = new Headers({'Content-Type':'application/json; charset=utf8'});
  private options = new RequestOptions({headers:this.headers});
  private student:Student =new Student;
  value2:any;
  constructor(private http:Http) { }

  createStudentProfile(student:Student){
    // var merged = Object.assign(file, student);
    // console.log(merged); 
     return this.http.post(this.baseUrl+'student/save_student',JSON.stringify(student)).map((response:Response)=>response.json())
     .catch(this.errorHandler);
    
  }

  setId(value1: any){
this.value2=value1;
  }

  getId(){
    return this.value2;
  }

  getStudentData(value:number): Observable<Object> {  
    return this.http.get(`${this.baseUrl}student/get_student/${value}`).map((response:Response)=>response.json())
     .catch(this.errorHandler);
    // return this.http.get(`${this.baseUrl}student/getstudent/${value}`);  
  }  
  saveUpdateStudent(st:any){
    return this.http.post(this.baseUrl+'student/save_update_student',JSON.stringify(st)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  getVacancy(value:any){
    console.log(value);
    //let post =value['post'];
    //let loc = value['location'];
    return this.http.post(this.baseUrl+'student/getVacancy',JSON.stringify(value)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  saveId(id1:any){
    return this.http.post(this.baseUrl+'student/save_Applied',id1).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  checkRegisterId(register_id:any){
    console.log("reg_id=",register_id);
    let id={
      "register_id":register_id
    }
    console.log(" json id=",id);
    return this.http.post(this.baseUrl+'student/checkRegisterId',id).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  getAppliedJobDataforStudent(student_id:any){
    let value={
      "student_id":student_id
    }
    return this.http.post(this.baseUrl+'student/getAppliedJobDataforStudent',value).map((response:Response)=>response.json())
    .catch(this.errorHandler);

  }

  getStudentAppliedJob(student_id:any){
    let id={
      'student_id':student_id
    }
    return this.http.post(this.baseUrl+'student/getStudentAppliedJob',id).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
}
