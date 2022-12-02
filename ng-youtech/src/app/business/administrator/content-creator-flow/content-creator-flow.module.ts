import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { ContentCreatorFlowComponent } from './content-creator-flow.component';

@NgModule({
  declarations: [ContentCreatorFlowComponent],
  imports: [CommonModule, MatTableModule, MatFormFieldModule, MatInputModule],
  exports: [ContentCreatorFlowComponent],
})
export class ContentCreatorFlowModule {}
