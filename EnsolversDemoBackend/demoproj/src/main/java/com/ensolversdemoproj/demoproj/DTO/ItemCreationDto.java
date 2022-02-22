package com.ensolversdemoproj.demoproj.DTO;

public class ItemCreationDto {

    private String title;

    private boolean checked;

    private FolderDto folder;

    public boolean isChecked() {
        return checked;
    }

    public FolderDto getFolder() {
        return folder;
    }

    public void setFolder(FolderDto folder) {
        this.folder = folder;
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
}
