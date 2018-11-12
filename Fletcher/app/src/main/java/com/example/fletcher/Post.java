package com.example.fletcher;

import java.io.Serializable;

public class Post implements Serializable {
    public final String id;
    public final String content;
    public final String image;
    public final String username;
    public final Comment[] comments;

    public Post(String id, String content, String image, String username, Comment[] comments) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.username = username;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return content;
    }
}