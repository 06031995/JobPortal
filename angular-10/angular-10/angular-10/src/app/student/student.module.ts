import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { SudentProfileComponent } from './sudent-profile/sudent-profile.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { ViewStudentProfileComponent } from './view-student-profile/view-student-profile.component';
import { ViewProfileComponent } from './view-profile/view-profile.component';
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
import { AppliedJobbystudnetComponent } from './applied-jobbystudnet/applied-jobbystudnet.component';
import { AppliedJobbystudnetListComponent } from './applied-jobbystudnet-list/applied-jobbystudnet-list.component';
import { SavedJobComponent } from './saved-job/saved-job.component';

@NgModule({
  declarations: [SudentProfileComponent, ViewStudentProfileComponent, ViewProfileComponent, AppliedJobbystudnetComponent, AppliedJobbystudnetListComponent, SavedJobComponent],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatTabsModule,
    MatStepperModule,
    CommonModule,
    StudentRoutingModule,
    TabsModule,
    MatRadioModule,
    MatCheckboxModule,
    MatListModule,
    MatSidenavModule,
    MatIconModule,
    MatToolbarModule,
    MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatInputModule,
  MatRippleModule,
  MatSelectModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatTableModule,
  MatTooltipModule
  ]
})
export class StudentModule { }
