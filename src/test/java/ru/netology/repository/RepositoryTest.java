package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {
    protected Book book1 = new Book(101, 900, "Тигровый, черный, золотой", "Елена Михалкова");
    protected Book book2 = new Book(102, 700, "Pocket", "Борис Акунин");
    protected Book book3 = new Book(103, 800, "Лисьи броды", "Анна Старобинец");

    protected Smartphone smartphone1 = new Smartphone(111, 129999, "Galaxy S22 Ultra", "Samsung");
    protected Smartphone smartphone2 = new Smartphone(222, 99999, " P50 Pocket", "Huawei");
    protected Smartphone smartphone3 = new Smartphone(333, 109999, "Xiaomi 12 Pro", "Xiaomi");

    Repository repository = new Repository();
    @BeforeEach
    public void setup() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
    }

    @Test
    @DisplayName("Сохранение товара")
    void shouldSaveItems() {

        Book book4 = new Book(104, 1500, "Волкодав", "Мария Семенова");
        repository.save(book4);

        Product[] expected = {book1,book2,book3,smartphone1,smartphone2,smartphone3,book4};
        Product[] actual = repository.getItems();

        assertArrayEquals(expected,actual);

    }

    @Test
    @DisplayName("поиск всех товаров")
    void shouldFindAllItems() {

        Product[] expected = repository.findAll();
        Product[] actual = repository.getItems();

        assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("удаление по корректному идентификатору")
    void shouldRemoveByIdItem() {

        repository.removeById(333);

        Product[] expected = {book1,book2,book3,smartphone1,smartphone2};
        Product[] actual = repository.getItems();

        assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("удаление по НЕ корректному идентификатору")
    void shouldRemoveByNoCorrectIdItem() {
    assertThrows(NotFoundException.class,
            () -> repository.removeById(4)
            );
    }

    @Test
    @DisplayName("Не удалось добавить продукт")
    void shouldAddProductFailed() {
        assertThrows(AlreadyExistsException.class, () -> {
            repository.save(book3);
        });
    }

}