package ru.yandex.practicum.catsgram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.yandex.practicum.catsgram.controller.PostController;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.exception.UserEmailNotFoundException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {


    private static Integer userId = 0;
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final Map<String, User> users = new HashMap<>();

    private static Integer setUserId() {
        return userId++;
    }

    public Collection<User> findAll() {
        log.debug("Текущее количество юзеров в системе: {}", users.size());
        return users.values();
    }

    public User create(User user) {
        if(user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        if(users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }
        user.setUserId(setUserId());
        users.put(user.getEmail(), user);
        return user;
    }

     public User put(User user) {
        if(user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);

        return user;
    }

    public User findUserByEmail(String email) {
        if (users.get(email) == null) {
            throw new UserEmailNotFoundException(String.format("User with email %s not found!", email));
        } else
            return users.get(email);
    }
}
