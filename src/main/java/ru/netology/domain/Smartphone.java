package ru.netology.domain;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone() {
    }

    public Smartphone(int id, int price, String title, String manufacturer) {
        super(id, price, title);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
