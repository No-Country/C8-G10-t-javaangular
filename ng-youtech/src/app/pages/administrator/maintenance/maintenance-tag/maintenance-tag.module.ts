import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MaintenanceTagComponent } from './maintenance-tag.component';

const routes: Routes = [{ path: '', component: MaintenanceTagComponent }];

@NgModule({
  declarations: [MaintenanceTagComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class MaintenanceTagModule {}
