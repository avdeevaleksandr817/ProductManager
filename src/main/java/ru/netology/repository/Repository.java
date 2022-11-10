package ru.netology.repository;

import ru.netology.domain.IdNotFoundException;
import ru.netology.domain.Product;

public class Repository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int lenght = items.length + 1;
        Product[] tmp = new Product[lenght];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {

        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new IdNotFoundException(
                    "Element with id: " + id + " not found"
            );

        }

        Product[] tmp = new Product[items.length - 1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] getItems() {
        return items;
    }

    public void setItems(Product[] items) {
        this.items = items;
    }
}
