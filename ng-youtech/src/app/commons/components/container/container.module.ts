import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { AvatarComponent } from '../avatar/avatar.component';
import { ContainerComponent } from './container.component';
import { HeaderComponent } from './header/header.component';


@NgModule({
  declarations: [ContainerComponent, HeaderComponent],
  imports: [CommonModule, MatButtonModule, AvatarComponent, RouterModule],
  exports: [ContainerComponent],
})
export class ContainerModule {}
