import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { AdministratorRoutingModule } from './administrator-routing.module';
import { AdministratorComponent } from './administrator.component';
import { CreatorContentPageComponent } from './creator-content-page/creator-content-page.component';

@NgModule({
  declarations: [AdministratorComponent, CreatorContentPageComponent],
  imports: [
    CommonModule,
    AdministratorRoutingModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
  ],
})
export class AdministratorModule {}
