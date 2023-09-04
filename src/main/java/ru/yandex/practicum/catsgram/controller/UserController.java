package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return List.copyOf(userService.findAll());
    }

    @PostMapping(value = "/user")
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping(value = "/user")
    public User put(@RequestBody User user) {
        userService.put(user);
        return user;
    }

    @GetMapping("/user/{email}")
    public User getUser(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }
}