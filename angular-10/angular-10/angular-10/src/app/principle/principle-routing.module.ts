import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrincipleProfileComponent } from './principle-profile/principle-profile.component';
import { PrincipleListComponent } from './principle-list/principle-list.component';


const routes: Routes = [
   {path:'principal-profile',component:PrincipleProfileComponent},
   {path:'principal-list',component:PrincipleListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PrincipleRoutingModule { }
