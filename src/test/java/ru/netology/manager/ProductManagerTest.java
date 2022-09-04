package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    protected Book book1 = new Book(101, 900, "Тигровый, черный, золотой", "Елена Михалкова");
    protected Book book2 = new Book(102, 700, "Медвежатница", "Борис Акунин");
    protected Book book3 = new Book(103, 800, "Лисьи броды", "Анна Старобинец");
    protected Smartphone smartphone1 = new Smartphone(111, 129999, "Galaxy S22 Ultra", "Samsung");
    protected Smartphone smartphone2 = new Smartphone(222, 99999, " P50 Pocket", "Huawei");
    protected Smartphone smartphone3 = new Smartphone(333, 109999, "Xiaomi 12 Pro", "Xiaomi");

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);


    @Test
    public void shouldFindStringInProduct() {

        boolean actual = manager.matches(smartphone1, "Galaxy S22 Ultra");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItems() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Product[] actual = manager.searchBy("Xiaomi 12 Pro");
        Product[] expected = {smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveItemById() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        repository.removeById(222);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddItems() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}


