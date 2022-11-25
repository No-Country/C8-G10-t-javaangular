import { CardHomeCreatorContentModule } from './../card-home-creator-content/card-home-creator-content.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { LoginFlowModule } from '../../../business/auth/login-flow/login-flow.module';
import { CreatorContentDetailModule } from '../../../business/home/home-flow/components/creator-content-detail/creator-content-detail.module';
import { AvatarComponent } from '../avatar/avatar.component';
import { ContainerComponent } from './container.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [ContainerComponent, HeaderComponent],
  imports: [
    CommonModule,
    MatButtonModule,
    AvatarComponent,
    RouterModule,
    MatMenuModule,
    LoginFlowModule,
    CreatorContentDetailModule,
    CardHomeCreatorContentModule
  ],
  exports: [ContainerComponent],
})
export class ContainerModule {}
