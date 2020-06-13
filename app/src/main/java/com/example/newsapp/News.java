package com.example.newsapp;

import android.graphics.Bitmap;

public class News {

    private String title;
    private String authorName = "";
    private String section;
    private String date;
    private Bitmap image;
    private String url;

    public News(String title, String authorName, String section, String date, Bitmap image, String url) {
        this.title = title;
        this.authorName = authorName;
        this.section = section;
        this.date = date;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
