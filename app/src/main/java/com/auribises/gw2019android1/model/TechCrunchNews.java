package com.auribises.gw2019android1.model;

public class TechCrunchNews {

    public String author;
    public String title;
    public String urlToImage;
    public String publishedAt;

    public TechCrunchNews(){

    }

    public TechCrunchNews(String author, String title, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "TechCrunchNews{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
