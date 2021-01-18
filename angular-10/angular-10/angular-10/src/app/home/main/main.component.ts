import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private adminId:any; 

  constructor(private router:Router,private userService:UserService, private route : ActivatedRoute) { }

  ngOnInit(): void {

    if((this.userService.isLoggedIn()) )  
    {  
      this.route.paramMap.subscribe(params => {  
        this.adminId =this.adminId + params.get('adminId');  
      });  
    }  
    else  
    {  
        this.router.navigate(['/login']);  
    }  
  }


  getData(){
    console.log("enter in main");
  }
 

}
