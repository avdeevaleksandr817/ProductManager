package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;


public class ProductManager {

    private Repository repository;

    //ProductManager конструктор которого будет принимать параметром репозиторий
    public ProductManager(Repository repository) {

        this.repository = repository;
    }

    //метод добавления продуктов в репозиторий
    public void add(Product product) {

        repository.save(product);
    }

    //метод searchBy(String text), который возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        // тут будем хранить подошедшие запросу продукты
        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (ProductManager.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public static boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
