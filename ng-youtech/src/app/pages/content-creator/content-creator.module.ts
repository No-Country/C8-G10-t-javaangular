import { NgModule } from '@angular/core';
import { ContentCreatorRoutingModule } from './content-creator-routing.module';
import { ContentCreatorComponent } from './content-creator.component';

@NgModule({
  declarations: [ContentCreatorComponent],
  imports: [ContentCreatorRoutingModule],
})
export class ContentCreatorModule {}
