package com.example.strage.springbootdemo.comm.pojo;

import lombok.Data;

@Data
public class FastDFSFile {
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(String name, byte[] content, String ext, String md5, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.md5 = md5;
        this.author = author;
    }
}
