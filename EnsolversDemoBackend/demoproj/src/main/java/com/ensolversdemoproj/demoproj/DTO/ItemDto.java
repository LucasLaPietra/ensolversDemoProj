package com.ensolversdemoproj.demoproj.DTO;

public class ItemDto {

    private Long idItem;

    private String title;

    private boolean checked;

    public Long getIdItem() {
        return idItem;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }
    
}
