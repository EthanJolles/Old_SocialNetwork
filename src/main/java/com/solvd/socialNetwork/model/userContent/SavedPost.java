package com.solvd.socialNetwork.model.userContent;

public class SavedPost {

    private Long id;
    private String name;
    private Long postId;

    public SavedPost() {
    }

    public SavedPost(String name, Long postId) {
        this.name = name;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
