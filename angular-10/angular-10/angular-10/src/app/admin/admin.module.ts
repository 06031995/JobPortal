import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { SidebarComponent } from './sidebar/sidebar.component';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
} from '@angular/material';
import { AboutComponent } from './about/about.component';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreatedListComponent } from './created-list/created-list.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { UpdateCreateVacancyComponent } from './update-create-vacancy/update-create-vacancy.component';
import { RegisteredStudentlistComponent } from './registered-studentlist/registered-studentlist.component';
import { AppliedStudentsComponent } from './applied-students/applied-students.component';
import { MailComponent } from './mail/mail.component';
import { GenerateStudentPdfComponent } from './generate-student-pdf/generate-student-pdf.component';



@NgModule({
  declarations: [SidebarComponent, AboutComponent, CreateVacancyComponent, DashboardComponent, CreatedListComponent, UpdateCreateVacancyComponent, RegisteredStudentlistComponent, AppliedStudentsComponent, MailComponent, GenerateStudentPdfComponent],
  imports: [
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    AdminRoutingModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
  ]
})
export class AdminModule { }
