import { Folder } from "src/folders/folders.model";

export interface Item
{
  idItem?: number,
  title?: string,
  checked?: boolean,
  folder?: Folder,
}
