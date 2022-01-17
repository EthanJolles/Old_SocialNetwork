package com.solvd.socialNetwork.model.userContent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("location")
    private String location;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("isPicture")
    private Boolean isPicture;

    @JsonProperty("userId")
    private Long userId;

    public Post() {
    }

    public Post(String location, String caption, Boolean isPicture, Long userId) {
        this.location = location;
        this.caption = caption;
        this.isPicture = isPicture;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Boolean getPicture() {
        return isPicture;
    }

    public void setPicture(Boolean picture) {
        isPicture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
