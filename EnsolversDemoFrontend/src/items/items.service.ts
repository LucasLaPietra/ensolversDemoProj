import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './items.model';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private httpClient:HttpClient) { }

  public CreateItem(item:Item): Observable<Item> {
    return this.httpClient.post<Item>('http://localhost:8085/api/item',item)
  }

  public GetItems(): Observable<Item[]> {
    return this.httpClient.get<Item[]>('http://localhost:8085/api/item');
  }

  public GetItem(id:number): Observable<Item> {
    return this.httpClient.get<Item>('http://localhost:8085/api/item/' + id);
  }

  public UpdateItem(item:Item): Observable<Item> {
    return this.httpClient.put<Item>('http://localhost:8085/api/item/' + item.idItem, item)
  }

  public DeleteItem(id:number): Observable<Item> {
    return this.httpClient.delete<Item>('http://localhost:8085/api/item/' + id);
  }
}
