import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DialogOverviewExampleDialog, ItemPageComponent } from './item-page/item-page.component';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ItemPageComponent,
    DialogOverviewExampleDialog
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatCheckboxModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
    MatDialogModule,
    FormsModule
  ],
  exports:[
    ItemPageComponent
  ]
})
export class ItemsModule { }
