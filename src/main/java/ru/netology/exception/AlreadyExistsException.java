package ru.netology.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String id) {
        super("Товар с id  " + id + "  не найден");
    }
}
