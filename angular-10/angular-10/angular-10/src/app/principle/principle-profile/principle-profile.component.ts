import { Component, OnInit } from '@angular/core';
import { PrincipleService} from '../../principle.service';
@Component({
  selector: 'app-principle-profile',
  templateUrl: './principle-profile.component.html',
  styleUrls: ['./principle-profile.component.css']
})
export class PrincipleProfileComponent implements OnInit {

  constructor(private principleService: PrincipleService) { }

  ngOnInit(): void {
  }
  clickOnSubmit(value:any){
     this.principleService.createPrincipleProfile(value).subscribe(
       response=>{
         console.log(response);
         
       },
       error=>{
         console.log(error);
       }
     )
  }
}
