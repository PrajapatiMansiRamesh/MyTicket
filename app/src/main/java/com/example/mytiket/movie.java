package com.example.mytiket;

public class movie {
    private int id;
    private String title,language,type;
    private int image;

    public movie(int id, String title, String language, String type, int image) {

        this.id = id;
        this.title = title;
        this.language = language;
        this.type = type;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return type;
    }

    public int getImage() {
        return image;
    }
}
