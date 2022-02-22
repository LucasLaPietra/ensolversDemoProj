import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditFolderDialog, FolderPageComponent } from './folder-page/folder-page.component';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ItemPageComponent } from 'src/items/item-page/item-page.component';
import { TopBarModule } from 'src/top-bar/top-bar.module';



@NgModule({
  declarations: [
    FolderPageComponent,
    EditFolderDialog
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
    RouterModule,
    TopBarModule
  ],
  exports: [
    FolderPageComponent
  ]
})
export class FoldersModule { }
