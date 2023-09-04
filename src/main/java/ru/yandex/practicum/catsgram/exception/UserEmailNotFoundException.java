package ru.yandex.practicum.catsgram.exception;

public class UserEmailNotFoundException extends RuntimeException {
    public UserEmailNotFoundException(String s) {
        super(s);
    }
}
