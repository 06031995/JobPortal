import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';
import { ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-created-list',
  templateUrl: './created-list.component.html',
  styleUrls: ['./created-list.component.css']
})
export class CreatedListComponent implements OnInit {
  index=1;
  myresponse:any;
  searchText:any;
  id:any;
  i:number=0;
  myresponse1:any;
  
 
  constructor(private _snackBar: MatSnackBar,private adminService:AdminService,private modalService:NgbModal,private router:Router) { }

  ngOnInit(): void {
    this.adminService.getList().subscribe(
      response=>{
        console.log('vacancy==',response);
        this.myresponse=response;
      },
      error =>{
        console.log(error);
      }
    );
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

  viewVacancy(cv_id:any){

    for(this.i=0;this.i<this.myresponse.length;this.i++){
    if(cv_id==this.myresponse[this.i].cv_id){
      var data={
        "cv_id":this.myresponse[this.i].cv_id,
        "post":this.myresponse[this.i].post,
        "company_name":this.myresponse[this.i].company_name,
        "year_of_exp":this.myresponse[this.i].year_of_exp,
        "vacancy":this.myresponse[this.i].vacancy,
        "location":this.myresponse[this.i].location,
        "salary":this.myresponse[this.i].salary,
        "required_skill":this.myresponse[this.i].required_skill,
        "job_desc":this.myresponse[this.i].job_desc,
        "industry_type":this.myresponse[this.i].industry_type,
        "function_area":this.myresponse[this.i].function_area,
        "role":this.myresponse[this.i].role,
        "employment_type":this.myresponse[this.i].employment_type,
        "education":this.myresponse[this.i].education,
        "website":this.myresponse[this.i].website,
        "address":this.myresponse[this.i].address,

      }
      this.myresponse1=data;
      console.log(this.myresponse1);
      break;
    }
  }

  }

  updateVacancy(cv_id:any){
    for(this.i=0;this.i<this.myresponse.length;this.i++){
      if(cv_id==this.myresponse[this.i].cv_id){
        var data={
          "cv_id":this.myresponse[this.i].cv_id,
          "post":this.myresponse[this.i].post,
          "company_name":this.myresponse[this.i].company_name,
          "year_of_exp":this.myresponse[this.i].year_of_exp,
          "vacancy":this.myresponse[this.i].vacancy,
          "location":this.myresponse[this.i].location,
          "salary":this.myresponse[this.i].salary,
          "required_skill":this.myresponse[this.i].required_skill,
          "job_desc":this.myresponse[this.i].job_desc,
          "industry_type":this.myresponse[this.i].industry_type,
          "function_area":this.myresponse[this.i].function_area,
          "role":this.myresponse[this.i].role,
          "employment_type":this.myresponse[this.i].employment_type,
          "education":this.myresponse[this.i].education,
          "website":this.myresponse[this.i].website,
          "address":this.myresponse[this.i].address,
  
        }
        this.myresponse1=data;
        console.log(this.myresponse1);
        break;
      }
  }
}

  deleteVacancy(){
  //  console.log(cv_id);
    // this.id = cv_id;
    var delete_id={
      "delete_id":this.id,
    }
    this.adminService.deleteVacancy(delete_id).subscribe(
      response=>{
          console.log("done");
          this.openSnackBar();
          window.location.reload();
      },
      error=>{
        console.log(" not done");
      }

    )
  }

  getDeletId(cv_id:any){
    console.log(cv_id);
    this.id = cv_id;
  }

  
  openSnackBar(){
    this._snackBar.open('Data deleted successfully', '', {
      duration: 3000,
    });

  }
  openSnackBar1(){
    this._snackBar.open('Data updated successfully', '', {
      duration: 3000,
    });

  }

  UpdateCVacancy(myres:any){
    console.log(myres);
    this.adminService.updateVacany(myres).subscribe(
      response=>{
        console.log(response);
        
        window.location.reload();
        // this.openSnackBar1();
      },
      error=>{
        console.log(error);
      }
    )
    
  }

  generatePdf(data: HTMLElement) {
    html2canvas(data, { allowTaint: true }).then(canvas => {
     let HTML_Width = canvas.width;
     let HTML_Height = canvas.height;
     let top_left_margin = 15;
     let PDF_Width = HTML_Width + (top_left_margin * 2);
     let PDF_Height = (PDF_Width * 1.5) + (top_left_margin * 2);
     let canvas_image_width = HTML_Width;
     let canvas_image_height = HTML_Height;
     let totalPDFPages = Math.ceil(HTML_Height / PDF_Height) - 1;
     canvas.getContext('2d');
     let imgData = canvas.toDataURL("image/jpeg", 1.0);
     let pdf = new jspdf.jsPDF('p', 'pt', [PDF_Width, PDF_Height]);
     pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin, canvas_image_width, canvas_image_height);
     for (let i = 1; i <= totalPDFPages; i++) {
       pdf.addPage([PDF_Width, PDF_Height], 'p');
       pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height * i) + (top_left_margin * 4), canvas_image_width, canvas_image_height);
     }
      pdf.save("HTML-Document.pdf");
   });
 }
  

}
