import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FulldemoComponent } from './fulldemo/fulldemo.component';
import { FirComponent } from './fir/fir.component';


const routes: Routes = [
  {path:'fulldemo',component:FulldemoComponent},
  {path:'fir',component:FirComponent},
  // {path:'view-student-profile',component:ViewStudentProfileComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }
