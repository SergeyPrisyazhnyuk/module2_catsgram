package ru.yandex.practicum.catsgram.controller;

<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.model.FeedParams;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
@RestController
public class PostFeedController {
=======
import static ru.yandex.practicum.catsgram.Constants.SORTS;

@RestController()
@RequestMapping("/feed/friends")
public class PostFeedController {

>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    private final PostService postService;

    public PostFeedController(PostService postService) {
        this.postService = postService;
    }

<<<<<<< HEAD
    @PostMapping("/feed/friends")
    List<Post> getFriendsFeed(@RequestBody String params) {
        ObjectMapper objectMapper = new ObjectMapper();
        FriendsParams friendsParams;

        try {
            friendsParams = objectMapper.reader().forType(FriendsParams.class).readValue(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Invalid JSON format", e);
        }

        if (friendsParams != null) {
            List<Post> resultList = new ArrayList<>();

            for (String friend : friendsParams.friends) {
                resultList.addAll(postService.findAllByEmail(friend, friendsParams.size, friendsParams.sort));
            }
            return resultList;

        } else {
            throw new RuntimeException("Wrong paramaters for Friends Post Feed Controller");
        }
    }

    @Data
    @ToString
    static class FriendsParams {
        private String sort;
        private Integer size;
        private List<String> friends;

        public FriendsParams() {

        }
=======
    @PostMapping
    List<Post> getFriendsFeed(@RequestBody FeedParams feedParams) {
        if (!SORTS.contains(feedParams.getSort()) || feedParams.getFriendsEmails().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (feedParams.getSize() == null || feedParams.getSize() <= 0) {
            throw new IllegalArgumentException();
        }

        List<Post> result = new ArrayList<>();
        for (String friendEmail : feedParams.getFriendsEmails()) {
            result.addAll(postService.findAllByUserEmail(friendEmail, feedParams.getSize(), feedParams.getSort()));
        }
        return result;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    }
}
