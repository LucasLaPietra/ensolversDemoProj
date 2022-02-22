package com.ensolversdemoproj.demoproj.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private String title;

    private boolean checked;

    @ManyToOne
    @JoinColumn(name="idFolder")
    private Folder folder;

    public Long getIdItem() {
        return idItem;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setIdItem(Long idItem) {
            this.idItem = idItem;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Item(Long idItem, String title, boolean checked) {
        this.idItem = idItem;
        this.title = title;
        this.checked = checked;
    }

    public Item() {
    }

}
