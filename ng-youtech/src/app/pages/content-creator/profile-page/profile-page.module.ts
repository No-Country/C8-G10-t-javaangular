import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilePageComponent } from './profile-page.component';

const routes: Routes = [{ path: '', component: ProfilePageComponent }];

@NgModule({
  declarations: [ProfilePageComponent],
  imports: [RouterModule.forChild(routes)],
})
export class ProfilePageModule {}
