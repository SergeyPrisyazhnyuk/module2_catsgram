package ru.yandex.practicum.catsgram.model;

import java.time.Instant;

public class Post {

<<<<<<< HEAD
    private Integer Id;
    private String author; // автор
=======
    private Integer id;
    private final String author; // автор
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    private final Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии

<<<<<<< HEAD
    public Post() {
    }
    public Post(String author, String description) {
        this.author = author;
        this.description = description;
    }

=======
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    public Post(String author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }

<<<<<<< HEAD
    public Post(Integer Id, String author, String description) {
        this.Id = Id;
        this.author = author;
        this.description = description;

    }
    public Post(Integer Id, String author, String description, String photoUrl) {
        this.Id = Id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
=======
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
>>>>>>> 49acd1e373f941e6e90c353bc306819e0cebb04f
    }

    public String getAuthor() {
        return author;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
