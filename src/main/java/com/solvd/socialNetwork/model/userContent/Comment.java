package com.solvd.socialNetwork.model.userContent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("contents")
    private String contents;

    @JsonProperty("postId")
    private Long postId;

    public Comment() {
    }

    public Comment(String contents, Long postId) {
        this.contents = contents;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
