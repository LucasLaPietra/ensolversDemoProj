package com.ensolversdemoproj.demoproj.DTO;

import java.util.List;

public class FolderDto {

    private Long idFolder;

    private String title;

    private List<ItemDto> items;
    

    public Long getIdFolder() {
        return idFolder;
    }

    public void setIdFolder(Long idFolder) {
        this.idFolder = idFolder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

}
