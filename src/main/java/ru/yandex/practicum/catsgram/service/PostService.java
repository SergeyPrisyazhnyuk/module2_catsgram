package ru.yandex.practicum.catsgram.service;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.controller.PostController;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
import ru.yandex.practicum.catsgram.exception.PostNotFoundException;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
@Service
public class PostService {

    private final UserService userService;
    public final List<Post> posts = new ArrayList<>();

    private static Integer postId = 0;
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

=======
import static ru.yandex.practicum.catsgram.Constants.DESCENDING_ORDER;

@Service
public class PostService {
    private final UserService userService;
    private final List<Post> posts = new ArrayList<>();

    private static Integer globalId = 0;

    @Autowired
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    public PostService(UserService userService) {
        this.userService = userService;
    }

<<<<<<< HEAD
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


=======
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    public Post create(Post post) {
        User postAuthor = userService.findUserByEmail(post.getAuthor());
        if (postAuthor == null) {
            throw new UserNotFoundException(String.format(
                    "Пользователь %s не найден",
                    post.getAuthor()));
        }
<<<<<<< HEAD
        post.setId(setPostId());
=======

        post.setId(getNextId());
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
        posts.add(post);
        return post;
    }

<<<<<<< HEAD
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
=======
    public Post findPostById(Integer postId) {
        return posts.stream()
                .filter(p -> p.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException(String.format("Пост № %d не найден", postId)));
    }

    public List<Post> findAll(Integer size, Integer from, String sort) {
        return posts.stream()
                .sorted((p0, p1) -> compare(p0, p1, sort))
                .skip(from)
                .limit(size)
                .collect(Collectors.toList());
    }

    public List<Post> findAllByUserEmail(String email, Integer size, String sort) {
        return posts.stream()
                .filter(p -> email.equals(p.getAuthor()))
                .sorted((p0, p1) -> compare(p0, p1, sort))
                .limit(size)
                .collect(Collectors.toList());
    }

    private static Integer getNextId() {
        return globalId++;
    }

    private int compare(Post p0, Post p1, String sort) {
        int result = p0.getCreationDate().compareTo(p1.getCreationDate()); //прямой порядок сортировки
        if (sort.equals(DESCENDING_ORDER)) {
            result = -1 * result; //обратный порядок сортировки
        }
        return result;
    }
}
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
