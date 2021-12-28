package com.solvd.socialNetwork.model.userContent;

public class LikedPost {
    private Long id;
    private String title;
    private Long postId;

    public LikedPost() {
    }

    public LikedPost(String title, Long postId) {
        this.title = title;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
