package ru.netology.exception;

public class NotFoundException extends RuntimeException{
    //для передачи идентификатора товара который не найден
    public NotFoundException(int id) {
        super("Товар с id  " + id + "  не найден");
    }
}
