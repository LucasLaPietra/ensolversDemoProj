import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Item } from '../items.model';
import { ItemsService } from '../items.service';

@Component({
  selector: 'app-item-page',
  templateUrl: './item-page.component.html',
  styleUrls: ['./item-page.component.css']
})
export class ItemPageComponent implements OnInit {
  items: Item[] = [];

  constructor(private itemsService:ItemsService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getItems();
  }

  getItems(): void {
    this.itemsService.GetItems()
    .subscribe(items => this.items = items);
  }

  addItem(title: string): void {
    title = title.trim();
    if (!title) { return; }
    const item: Item = { title:title };
    console.log(item)
    this.itemsService.CreateItem(item)
    .subscribe(item => {
      this.items.push(item);
    });
  }

  setChecked(item:Item): void {
    if (item.idItem) {
      item.checked=!item.checked;
      this.itemsService.UpdateItem(item)
        .subscribe();
    }
  }

  delete(item: Item): void {
    if(item.idItem){
      this.items = this.items.filter(h => h !== item);
      this.itemsService.DeleteItem(item.idItem).subscribe();
    }
  }

  openEditDialog(item:Item): void {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: item,
    });

    const aux: string|undefined = item.title;
    dialogRef.afterClosed().subscribe(result => {
      if (result.title && result.title!==aux) {
        this.itemsService.UpdateItem(result)
          .subscribe();
      }
    });
  }

}

@Component({
  selector: 'app-item-edition-dialog',
  templateUrl: 'app-item-edition-dialog.html',
})
export class DialogOverviewExampleDialog {
  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public item: Item,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
