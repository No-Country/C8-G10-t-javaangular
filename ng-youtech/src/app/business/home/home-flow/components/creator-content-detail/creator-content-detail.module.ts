import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { AvatarComponent } from '../../../../../commons/components/avatar/avatar.component';
import { CreatorContentDetailComponent } from './creator-content-detail.component';
import { DetailComponent } from './detail/detail.component';

@NgModule({
  declarations: [CreatorContentDetailComponent, DetailComponent],
  imports: [CommonModule, MatTabsModule, AvatarComponent],
  exports: [CreatorContentDetailComponent],
})
export class CreatorContentDetailModule {}
