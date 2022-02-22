import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ItemsModule } from 'src/items/items.module';
import { FoldersModule } from 'src/folders/folders.module';
import { RouterModule } from '@angular/router';
import { ItemPageComponent } from 'src/items/item-page/item-page.component';
import { FolderPageComponent } from 'src/folders/folder-page/folder-page.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', component: FolderPageComponent },
      {path: 'items/:id', component: ItemPageComponent},
    ]),
    HttpClientModule,
    BrowserAnimationsModule,
    ItemsModule,
    FoldersModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
