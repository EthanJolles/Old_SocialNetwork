package com.solvd.socialNetwork.model.userContent;

import java.util.Date;

public class DirectMessage {
    private Long id;
    private String message;
    private Date dateSent;
    private Long recipientId;
    private Long userId;

    public DirectMessage() {
    }

    public DirectMessage(String message, Date dateSent, Long recipientId, Long userId) {
        this.message = message;
        this.dateSent = dateSent;
        this.recipientId = recipientId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
