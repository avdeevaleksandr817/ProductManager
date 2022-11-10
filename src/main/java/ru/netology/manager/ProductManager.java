package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;


public class ProductManager {

    Repository repository = new Repository();

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        Product[] product = repository.findAll();
        return product;
    }

    public Product[] searchBy(String text) {

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

    public static boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchByTitleRichModel(String search) {
        Product[] results = new Product[0];
        for (Product product : repository.findAll()) {
            if (matchesRichModel(product, search)) {
                Product[] tmp = new Product[results.length + 1];
                System.arraycopy(results, 0, tmp, 0, results.length);
                tmp[results.length] = product;
                results = tmp;
            }
        }
        return results;
    }

    public static boolean matchesRichModel(Product product, String search) {
        return product.matches(search);
    }
}
