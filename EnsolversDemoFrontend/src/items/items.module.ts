import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditItemDialog, ItemPageComponent } from './item-page/item-page.component';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { TopBarModule } from 'src/top-bar/top-bar.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    ItemPageComponent,
    EditItemDialog
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatCheckboxModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    TopBarModule,
    RouterModule
  ],
  exports:[
    ItemPageComponent
  ]
})
export class ItemsModule { }
