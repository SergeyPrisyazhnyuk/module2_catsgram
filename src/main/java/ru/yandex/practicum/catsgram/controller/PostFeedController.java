package ru.yandex.practicum.catsgram.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostFeedController {
    private final PostService postService;

    public PostFeedController(PostService postService) {
        this.postService = postService;
    }

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
    }
}
