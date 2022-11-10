package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.IdNotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {

    protected Book book1 = new Book(101, 900, "Тигровый, черный, золотой", "Елена Михалкова");
    protected Book book2 = new Book(102, 700, "Pocket", "Борис Акунин");
    protected Book book3 = new Book(103, 800, "Лисьи броды", "Анна Старобинец");

    protected Smartphone smartphone1 = new Smartphone(111, 129999, "Galaxy S22 Ultra", "Samsung");
    protected Smartphone smartphone2 = new Smartphone(222, 99999, " P50 Pocket", "Huawei");
    protected Smartphone smartphone3 = new Smartphone(333, 109999, "Xiaomi 12 Pro", "Xiaomi");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    @Test
    void shouldAddItemsAndFindAll() {

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextInTitle() {

        Product[] actual = manager.searchBy("Ultra");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextInTitle2Item() {

        Product[] actual = manager.searchBy("Pocket");
        Product[] expected = {book2, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTextInTitle0Item() {
        Assertions.assertThrows(IdNotFoundException.class, () -> repository.removeById(55));
    }

    @Test
    void shouldDeterminingTheConformityOfTheGoodsToTheRequest() {

        boolean expected = manager.matches(book3, "Лисьи броды");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    //RICH
    @Test
    void shouldMatchesRichModelTrueTitle() {
        assertTrue(ProductManager.matchesRichModel(smartphone1, "Galaxy"));
    }

    @Test
    void shouldMatchesRichModelFalseTitle() {
        assertFalse(ProductManager.matchesRichModel(smartphone3, "iPhone"));
    }

    @Test
    void shouldMatchesRichModelTrueFoundAuthor() {
        assertTrue(ProductManager.matchesRichModel(book1, "Елена Михалкова"));
    }

    @Test
    void shouldMatchesRichModelFalseFoundAuthor() {
        assertFalse(ProductManager.matchesRichModel(book1, "Перов"));
    }

    @Test
    void shouldMatchesRichModelTrueFoundManufacturer() {
        assertTrue(ProductManager.matchesRichModel(smartphone2, "Huawei"));
    }

    @Test
    void shouldMatchesRichModelFalseFoundManufacturer() {
        assertFalse(ProductManager.matchesRichModel(smartphone2, "HTC"));
    }

}