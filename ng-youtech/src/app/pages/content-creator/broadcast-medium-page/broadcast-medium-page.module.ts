import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BroadcastMediumPageComponent } from './broadcast-medium-page.component';
const routes: Routes = [{ path: '', component: BroadcastMediumPageComponent }];

@NgModule({
  declarations: [BroadcastMediumPageComponent],
  imports: [RouterModule.forChild(routes)],
})
export class BroadcastMediumPageModule {}
