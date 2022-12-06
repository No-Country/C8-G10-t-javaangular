import { ScrollingModule } from '@angular/cdk/scrolling';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { BroadcastTypeImagePipe } from './../../../commons/pipes/broadcast-type.pipe';
import { BroadcastMediumComponent } from './broadcast-medium.component';
import { CardContentCreatorComponent } from './card-content-creator/card-content-creator.component';

@NgModule({
	declarations: [BroadcastMediumComponent, CardContentCreatorComponent, BroadcastTypeImagePipe],
	imports: [
		CommonModule,
		MatCardModule,
		MatIconModule,
		MatButtonModule,
		MatChipsModule,
		MatInputModule,
		MatFormFieldModule,
		ScrollingModule
	],
	exports: [BroadcastMediumComponent]
})
export class BroadcastMediumModule {}
