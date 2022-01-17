package com.solvd.socialNetwork.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Profile {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("middleInitial")
    private String middleInitial;

    @JsonProperty("birthday")
    private Date birthday;

    @JsonProperty("age")
    private Long age;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("isVerified")
    private Boolean isVerified;

    @JsonProperty("userId")
    private Long userId;

    public Profile() {
    }

    public Profile(String firstName, String lastName, String middleInitial,
                   Date birthday, Long age, String bio, Boolean isVerified, Long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.birthday = birthday;
        this.age = age;
        this.bio = bio;
        this.isVerified = isVerified;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
