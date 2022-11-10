package ru.netology.domain;

public class Book extends Product {
    protected String author;

    public Book(int id, int price, String title, String author) {
        super(id, price, title);
        this.author = author;
    }
}

