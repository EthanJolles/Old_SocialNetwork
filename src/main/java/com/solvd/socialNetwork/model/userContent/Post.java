package com.solvd.socialNetwork.model.userContent;

public class Post {

    private Long id;
    private String location;
    private String caption;
    private Boolean isPicture;
    private Long userId;

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
