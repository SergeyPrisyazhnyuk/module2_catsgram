package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
=======
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    public UserController(UserService userService) {
        this.userService = userService;
    }

<<<<<<< HEAD
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
=======
    @GetMapping
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/user/{userMail}")
    public User getUser(@PathVariable("userMail") String userMail){
        return userService.findUserByEmail(userMail);
    }
}
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
