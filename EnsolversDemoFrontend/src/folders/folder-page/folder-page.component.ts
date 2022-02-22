import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Folder } from '../folders.model';
import { FoldersService } from '../folders.service';

@Component({
  selector: 'app-folder-page',
  templateUrl: './folder-page.component.html',
  styleUrls: ['./folder-page.component.css']
})
export class FolderPageComponent implements OnInit {
  folders: Folder[] = [];

  constructor(private foldersService:FoldersService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getFolders();
  }

  getFolders(): void {
    this.foldersService.GetFolders()
    .subscribe(folders => this.folders = folders);
  }

  addFolder(title: string): void {
    title = title.trim();
    if (!title) { return; }
    const folder: Folder = { title:title };
    this.foldersService.CreateFolder(folder)
    .subscribe(folder => {
      this.folders.push(folder);
    });
  }

  delete(folder: Folder): void {
    if(folder.idFolder){
      this.folders = this.folders.filter(h => h !== folder);
      this.foldersService.DeleteFolder(folder.idFolder).subscribe();
    }
  }

  openEditDialog(folder:Folder): void {
    const dialogRef = this.dialog.open(EditFolderDialog, {
      width: '250px',
      data: folder,
    });

    const aux: string|undefined = folder.title;
    dialogRef.afterClosed().subscribe(result => {
      if (result.title && result.title!==aux) {
        this.foldersService.UpdateFolder(result)
          .subscribe();
      }
    });
  }

}

@Component({
  selector: 'app-folder-edition-dialog',
  templateUrl: 'app-folder-edition-dialog.html',
})
export class EditFolderDialog {
  constructor(
    public dialogRef: MatDialogRef<EditFolderDialog>,
    @Inject(MAT_DIALOG_DATA) public folder: Folder,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
