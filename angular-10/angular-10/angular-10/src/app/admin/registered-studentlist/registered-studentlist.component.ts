import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';

@Component({
  selector: 'app-registered-studentlist',
  templateUrl: './registered-studentlist.component.html',
  styleUrls: ['./registered-studentlist.component.css']
})
export class RegisteredStudentlistComponent implements OnInit {

  constructor(private adminService:AdminService) { }

  ngOnInit(): void {

    this.adminService.registerdStudent().subscribe(
      response=>{
        console.log("registered student=",response);
      }
    )
  }

}
