package ru.yandex.practicum.catsgram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class SimpleController {
    // создаём логер
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/home")
    public String homePage() {
        // логируем факт получения запроса
        log.debug("Получен запрос GET /home.");

        // возвращаем ответ в виде строки
        return "Котограм";
    }
}