import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { LoginComponent } from './login/login.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { MainComponent } from './main/main.component';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTabsModule} from '@angular/material/tabs';
import { PrincipleLoginComponent } from './principle-login/principle-login.component';
import { PrincipleRegisterComponent } from './principle-register/principle-register.component';

@NgModule({
  declarations: [LoginComponent, StudentLoginComponent, RegisterComponent, MainComponent, ForgotpassComponent, AdminLoginComponent, PrincipleLoginComponent, PrincipleRegisterComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,ReactiveFormsModule,FormsModule,
    MatSnackBarModule,
    MatTabsModule
    
  ]
})
export class HomeModule { }
