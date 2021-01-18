import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { FullComponent} from '../layouts/full/full.component';
import{StudentLoginComponent} from './student-login/student-login.component';
import {RegisterComponent} from './register/register.component';
import { MainComponent } from './main/main.component';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';

import { PrincipleLoginComponent } from './principle-login/principle-login.component';
import { PrincipleRegisterComponent } from './principle-register/principle-register.component';

const routes: Routes = [
  
      
  {path:'',component:LoginComponent},
  {path:'student-login',component:StudentLoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'main',component:MainComponent},
  {path:'forgotpass',component:ForgotpassComponent},
  {path:'admin-login',component:AdminLoginComponent},
  {path:'principal-register',component:PrincipleRegisterComponent},
  {path:'principal-login',component:PrincipleLoginComponent},
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
