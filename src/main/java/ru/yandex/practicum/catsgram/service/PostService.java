package ru.yandex.practicum.catsgram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.controller.PostController;
import ru.yandex.practicum.catsgram.exception.PostNotFoundException;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final UserService userService;
    public final List<Post> posts = new ArrayList<>();

    private static Integer postId = 0;
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    public PostService(UserService userService) {
        this.userService = userService;
    }

    private static Integer setPostId() {
        return postId++;
    }

/*
    public List<Post> findAll() {
        log.debug("Текущее количество постов: {}", posts.size());
        return posts;
    }
*/

    public List<Post> findAll(Integer size, Integer from, String sort) {

        int finalSize = size < 0 ? 10 : size;
        String finalDesc = sort == null ? "desc" : sort ;

        return posts.stream().skip(from).limit(finalSize).sorted((x0, x1) -> {
                    int result = x0.getCreationDate().compareTo(x1.getCreationDate());
                    if (finalDesc.equals("desc")){
                         result = -1 * result;
                    }
                    return result;
                }
        ).collect(Collectors.toList());
    }


    public Post create(Post post) {
        User postAuthor = userService.findUserByEmail(post.getAuthor());
        if (postAuthor == null) {
            throw new UserNotFoundException(String.format(
                    "Пользователь %s не найден",
                    post.getAuthor()));
        }
        post.setId(setPostId());
        posts.add(post);
        return post;
    }

    public Post findById(Integer postFId) {
        return posts.stream()
                .filter(x -> x.getId().equals(postFId))
                .findFirst()
                .orElseThrow(() ->new PostNotFoundException(String.format("Post %s not found!", postFId.toString())));
    }

    public List<Post> findAllByEmail(String fremail, Integer size, String sort) {
        return posts.stream().filter(x -> fremail.equals(x.getAuthor())).sorted((x0, x1) -> {
            int result = x0.getCreationDate().compareTo(x1.getCreationDate());
            if (sort.equals("desc")){
                result = -1 * result;
            }
            return result;
        }).limit(size).collect(Collectors.toList());
    }
}