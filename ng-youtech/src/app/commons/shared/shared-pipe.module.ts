import { NgModule } from '@angular/core';
import { BroadcastTypeImagePipe } from '../pipes/broadcast-type.pipe';

@NgModule({
	declarations: [BroadcastTypeImagePipe],
	exports: [BroadcastTypeImagePipe]
})
export class SharedPipeModule {}
