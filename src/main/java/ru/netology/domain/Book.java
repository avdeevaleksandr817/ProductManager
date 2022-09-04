package ru.netology.domain;

public class Book extends Product {

    private String author;

    public Book() {

    }

    public Book(int id, int price, String title, String author) {
        super(id, price, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
