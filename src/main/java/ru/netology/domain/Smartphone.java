package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone(int id, int price, String title, String manufacturer) {
        super(id, price, title);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {

        if (super.matches(search)) {
            return true;
        } else {
            return getManufacturer().toUpperCase().contains(search.toUpperCase());
        }
}
}
