package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

class ProductManagerTest {
    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    //подготовка данных
    Book book1 = new Book(101, 900, "Тигровый, черный, золотой", "Елена Михалкова");
    Book book2 = new Book(102, 700, "Pocket", "Борис Акунин");
    Book book3 = new Book(103, 800, "Лисьи броды", "Анна Старобинец");

    Smartphone smartphone1 = new Smartphone(111, 129999, "Galaxy S22 Ultra", "Samsung");
    Smartphone smartphone2 = new Smartphone(222, 99999, " P50 Pocket", "Huawei");
    Smartphone smartphone3 = new Smartphone(333, 109999, "Xiaomi 12 Pro", "Xiaomi");

    //аннотация перед каждым
    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    @DisplayName("должен добавить элементы и найти все продукты")
    void shouldAddItemsAndFindAll() {

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("поиск по тексту в названии продукта")
    public void shouldSearchByTextInTitle() {
        //тестируем метод поиска
        Product[] actual = manager.searchBy("Тигровый, черный, золотой");
        Product[] expected = {book1};
        //сравнение
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("поиск по тексту в названии продукта 2 элемента")
    void shouldSearchByTextInTitle2Item() {

        Product[] actual = manager.searchBy("Pocket");
        Product[] expected = {book2, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("поиск Товара нет в списке товаров")
    void searchProductNotInTheProductList() {

        String name = "Гарри Поттер";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Определение соответствия товара запросу")
    void shouldDeterminingTheConformityOfTheGoodsToTheRequest() {

        boolean expected = manager.matches(book3, "Лисьи броды");
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Определение НЕ соответствия товара запросу")
    void theDefinitionOfNonComplianceOfTheGoodsWithTheRequestFollows() {

        boolean expected = manager.matches(book3, "Гарри Поттер");
        boolean actual = false;

        Assertions.assertEquals(expected, actual);
    }

}