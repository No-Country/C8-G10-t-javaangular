import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MaintenanceBroadcastTypeFlowComponent } from './maintenance-broadcast-type-flow.component';

@NgModule({
  declarations: [MaintenanceBroadcastTypeFlowComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCheckboxModule,
    MatTableModule,
    MatIconModule,
  ],
  exports: [MaintenanceBroadcastTypeFlowComponent],
})
export class MaintenanceBroadcastTypeFlowModule {}
