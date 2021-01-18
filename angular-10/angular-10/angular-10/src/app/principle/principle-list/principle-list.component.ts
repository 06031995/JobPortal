import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PrincipleService } from 'app/principle.service';

@Component({
  selector: 'app-principle-list',
  templateUrl: './principle-list.component.html',
  styleUrls: ['./principle-list.component.css']
})
export class PrincipleListComponent implements OnInit {

    myresponse:any;
    index=1;
    i:number=0;
    myresponse1:any;
      constructor(private modalService:NgbModal,private principleService:PrincipleService) { }

  ngOnInit(): void {
    this.principleService.getPrincipleList().subscribe(
      response=>{
        console.log(response);
        this.myresponse=response;
      },error=>{
        console.log(error);
      }
    )
  }


  closeResult: string | undefined;
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result:any) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason:any) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  viewPrinciple(principle_id:any){
    for(this.i=0;this.i<this.myresponse.length;this.i++){
      if(principle_id==this.myresponse[this.i].principle_id){
        var data={
          "principle_id":this.myresponse[this.i].principle_id,
          "college_code":this.myresponse[this.i].college_code,
          "college_name":this.myresponse[this.i].college_name,
          "college_ph":this.myresponse[this.i].college_ph,
          "email":this.myresponse[this.i].email,
          "principle_name":this.myresponse[this.i].principle_name,
          "principle_ph":this.myresponse[this.i].principle_ph,
        }
        this.myresponse1=data;
        console.log(this.myresponse1);
        break;
      }


    }
  }


}
