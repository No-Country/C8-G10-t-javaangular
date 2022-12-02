import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MaintenanceBroadcastTypeComponent } from './maintenance-broadcast-type.component';

import { RouterModule, Routes } from '@angular/router';
const routes: Routes = [
  { path: '', component: MaintenanceBroadcastTypeComponent },
];

@NgModule({
  declarations: [MaintenanceBroadcastTypeComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class MaintenanceBroadcastTypeModule {}
