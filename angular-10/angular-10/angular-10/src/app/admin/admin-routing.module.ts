import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AboutComponent } from './about/about.component';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreatedListComponent } from './created-list/created-list.component';
import { RegisteredStudentlistComponent } from './registered-studentlist/registered-studentlist.component';
import { AppliedStudentsComponent } from './applied-students/applied-students.component';
import { MailComponent } from './mail/mail.component';
import { GenerateStudentPdfComponent } from './generate-student-pdf/generate-student-pdf.component';


const routes: Routes = [
  {path:'sidebar',component:SidebarComponent},
  {path:'about',component:AboutComponent},
  {path:'create-vacancy',component:CreateVacancyComponent},
  {path:'dash',component:DashboardComponent},
  {path:'created-list',component:CreatedListComponent},
  {path:'registered-student',component:RegisteredStudentlistComponent},
  {path:'applied-student',component:AppliedStudentsComponent},
  {path:'mail',component:MailComponent},
  {path:'student-pdf',component:GenerateStudentPdfComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
