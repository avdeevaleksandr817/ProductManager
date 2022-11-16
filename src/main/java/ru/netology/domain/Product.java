package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    protected int id;
    protected int price;
    protected String title;

    public boolean matches(String search) {
        return getTitle().toUpperCase().contains(search.toUpperCase());
    }
}

