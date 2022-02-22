import { Item } from "src/items/items.model";

export interface Folder
{
  idFolder?: number,
  title?: string,
  items?: Item[],
}
