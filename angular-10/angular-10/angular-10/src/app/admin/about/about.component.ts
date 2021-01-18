import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(private adminService:AdminService) { }

 
  sidenavWidth = 4;
  ngStyle: string='';
  

  ngOnInit() {

  }

  
}
