package com.auribises.gw2019android1.model;

public class Book {

    public String price;
    public String name;
    public String author;

    public Book(){

    }

    public Book(String price, String name, String author) {
        this.price = price;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
