package com.solvd.socialNetwork.model.user;

public class User {
    private Long id;
    private String username;
    private Long encryptedPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(Long encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
