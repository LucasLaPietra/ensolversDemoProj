import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/items/items.model';
import { Folder } from './folders.model';

@Injectable({
  providedIn: 'root'
})
export class FoldersService {

  constructor(private httpClient:HttpClient) { }

  public CreateFolder(folder:Folder): Observable<Folder> {
    return this.httpClient.post<Folder>('http://localhost:8085/api/folder',folder)
  }

  public GetFolders(): Observable<Folder[]> {
    return this.httpClient.get<Folder[]>('http://localhost:8085/api/folder');
  }

  public GetFolder(id:number): Observable<Folder> {
    return this.httpClient.get<Folder>('http://localhost:8085/api/folder/' + id);
  }

  public GetItemsFromFolder(id:number): Observable<Item[]> {
    return this.httpClient.get<Item[]>('http://localhost:8085/api/folder/items/' + id);
  }

  public UpdateFolder(folder:Folder): Observable<Folder> {
    return this.httpClient.put<Folder>('http://localhost:8085/api/folder/' + folder.idFolder, folder)
  }

  public DeleteFolder(id:number): Observable<Folder> {
    return this.httpClient.delete<Folder>('http://localhost:8085/api/folder/' + id);
  }
}
