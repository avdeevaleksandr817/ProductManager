package ru.netology.domain;

public class Smartphone extends Product {
    protected String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, int price, String title, String manufacturer) {
        super(id, price, title);
        this.manufacturer = manufacturer;
    }

}
