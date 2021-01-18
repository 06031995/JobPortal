import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'app/admin.service';

@Component({
  selector: 'app-mail',
  templateUrl: './mail.component.html',
  styleUrls: ['./mail.component.css']
})
export class MailComponent implements OnInit {
  selectedFiles: any;

  constructor(private router: Router,private _http: HttpClient,private adminService:AdminService) { }
  readonly APP_URL = 'http://localhost:8082/jobportal/';
  loading = false;
  buttionText = "Submit";
  element: HTMLElement | undefined;
  logo:any;
  //selectedFiles: FileList;
  fileName: string | undefined;
  
  ngOnInit(): void {
  }
  detectFiles(event:any) {
    this.selectedFiles = event.target.files;
    this.fileName = this.selectedFiles[0].name;
    console.log('selectedFiles: ' + this.fileName) ;
    alert(this.fileName);
  }
  mail(data:any){
    var urlName="C:/Users/Admin/Desktop/JobPrtal/jobportal/src/main/webapp/"+this.fileName;
    var upload={"to":data.to, "gmailuser":data.gmailuser,"subject":data.subject,"message":data.message,"file":urlName}
    // this._http.post(this.APP_URL +'mail/maill', JSON.stringify(upload))
    //   .subscribe(res => {
    //          console.log('inside postmehtod of sub.function', res);//only objects
    //       })
    this.adminService.mail(JSON.stringify(upload)).subscribe(
    response=>{
        console.log(response);
    },error =>{
      console.log(error);
    }
    )

  }

}
