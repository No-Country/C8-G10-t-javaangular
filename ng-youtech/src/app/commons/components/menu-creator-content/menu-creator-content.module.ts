import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatRippleModule } from '@angular/material/core';
import { MenuCreatorContentComponent } from './menu-creator-content.component';

@NgModule({
  declarations: [MenuCreatorContentComponent],
  imports: [CommonModule, MatRippleModule],
})
export class MenuCreatorContentModule {}
