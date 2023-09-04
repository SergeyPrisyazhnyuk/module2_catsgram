package ru.yandex.practicum.catsgram.controller;

<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;

<<<<<<< HEAD
=======
import static ru.yandex.practicum.catsgram.Constants.DESCENDING_ORDER;
import static ru.yandex.practicum.catsgram.Constants.SORTS;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f

@RestController
public class PostController {
    private final PostService postService;

<<<<<<< HEAD
    @Autowired
=======
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    public PostController(PostService postService) {
        this.postService = postService;
    }

<<<<<<< HEAD
/*
    @GetMapping("/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }
*/

    @GetMapping("/posts")
    public List<Post> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

        return postService.findAll(size, page, sort);
    }



=======
    @GetMapping("/posts")
    public List<Post> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size,
            @RequestParam(defaultValue = DESCENDING_ORDER, required = false) String sort
    ) {
        if (!SORTS.contains(sort) || page < 0 || size <= 0) {
            throw new IllegalArgumentException();
        }

        Integer from = page * size;
        return postService.findAll(size, from, sort);
    }

>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/post/{postId}")
<<<<<<< HEAD
    public Post findById(@PathVariable int postId) {
        //return postService.posts.stream().filter(x -> x.getId() == postId).findFirst();
        return postService.findById(postId);
    }
}
=======
    public Post findPost(@PathVariable("postId") Integer postId) {
        return postService.findPostById(postId);
    }
}
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
