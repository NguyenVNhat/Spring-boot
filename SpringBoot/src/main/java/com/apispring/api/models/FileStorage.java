package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "filestorage")
@Data
public class FileStorage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "filename")
    private String filename;
    @Column(name = "filetype")
    private String filetype;
    @Column(name = "filebase64")
    private String filebase64;

    public FileStorage() {
    }

    public FileStorage(Integer id, String filename, String filetype,  String filebase64) {
        this.id = id;
        this.filename = filename;
        this.filetype = filetype;
        this.filebase64 = filebase64;
    }
}
