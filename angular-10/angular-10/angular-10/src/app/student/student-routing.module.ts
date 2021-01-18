import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SudentProfileComponent } from './sudent-profile/sudent-profile.component';
import { ViewStudentProfileComponent } from './view-student-profile/view-student-profile.component';

import { ViewProfileComponent } from './view-profile/view-profile.component';
import { AppliedJobbystudnetComponent } from './applied-jobbystudnet/applied-jobbystudnet.component';
import { AppliedJobbystudnetListComponent } from './applied-jobbystudnet-list/applied-jobbystudnet-list.component';
import { SavedJobComponent } from './saved-job/saved-job.component';


const routes: Routes = [
  {path:'student-profile',component:SudentProfileComponent},
  {path:'view-student-profile',component:ViewStudentProfileComponent},
  {path:'view-profile/:adminId' ,component:ViewProfileComponent},
  {path:'applied-Job-By-student' ,component:AppliedJobbystudnetComponent},
  {path:'applied-Job-By-student-list' ,component:AppliedJobbystudnetListComponent},
  {path:'saved-job' ,component:SavedJobComponent},
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
