import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/admin.service';
import html2canvas from 'html2canvas';
import * as jspdf from 'jspdf';
@Component({
  selector: 'app-generate-student-pdf',
  templateUrl: './generate-student-pdf.component.html',
  styleUrls: ['./generate-student-pdf.component.css']
})
export class GenerateStudentPdfComponent implements OnInit {
  myresponse:any;
  show=true;
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    let value=localStorage.getItem('company_name');
    var data={
      "company_name":value
    }
    console.log(value);
    this.adminService.getCompanyWiseList(data).subscribe(
      response=>{
        console.log("response=",response);
        this.myresponse=response;
      },
      error=>{
        console.log(error);
      }
    )
  }
  generatePdf(data: HTMLElement) {
   
    html2canvas(data, { allowTaint: true }).then(canvas => {
      this.show=false;
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
