package com.example.mai_funstory.model;

public class StoryEntity {

    private String title;
    private String content;

    public StoryEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }

    public String getContent() { return content; }
}
