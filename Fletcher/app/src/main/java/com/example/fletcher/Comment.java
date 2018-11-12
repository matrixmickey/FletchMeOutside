package com.example.fletcher;

import java.io.Serializable;

public class Comment implements Serializable {
    public final String id;
    public final String content;
    public final String image;
    public final String username;

    public Comment(String id, String content, String image, String username) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.username = username;
    }
}
