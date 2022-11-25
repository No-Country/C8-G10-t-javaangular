import { ProfileFlowComponent } from './profile-flow.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';



@NgModule({
  declarations: [ProfileFlowComponent],
  imports: [
    CommonModule,
    MatCardModule
  ],
  exports:[ProfileFlowComponent],
})
export class ProfileFlowModule { }
