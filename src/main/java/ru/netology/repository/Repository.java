package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class Repository {
    private Product[] items = new Product[0];

    //метод позволяющий сохранять Product
    public void save(Product item) {

        if (findById(item.getId()) != null) {
            throw new AlreadyExistsException("Element with id " + item.getId() + " alredy exist.");
        } else {
            Product[] tmp = new Product[items.length + 1];

            for (int i = 0; i < items.length; i++) {
                tmp[i] = items[i];
            }
            tmp[tmp.length - 1] = item;
            items = tmp;
        }
    }
    //метод получать все сохранённые Product
    public Product[] findAll() {

        return items;
    }

    //метод удаления по идентификатору
    public void removeById(int id) {

        if (findById(id) == null){
            throw new NotFoundException(id);
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
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
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