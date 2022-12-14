package ru.netology.domain;

public class Product {
    protected int id;
    protected String title;
    protected int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id, int price, String title) {
        this.id = id;
        this.title = title;
        this.price = price;

    }

}


