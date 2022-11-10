package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    protected String author;

    public Book(int id, int price, String title, String author) {
        super(id, price, title);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        } else {
        return getAuthor().toUpperCase().contains(search.toUpperCase());
    }
}
}

