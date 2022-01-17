package com.solvd.socialNetwork.model.userList;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class FriendList {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("profileId")
    private Long profileId;

    @JsonProperty("friendProfileId")
    private Long friendProfileId;

    public FriendList() {
    }

    public FriendList(Long userId, Long friendProfileId) {
        this.profileId = userId;
        this.friendProfileId = friendProfileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getFriendProfileId() {
        return friendProfileId;
    }

    public void setFriendProfileId(Long friendProfileId) {
        this.friendProfileId = friendProfileId;
    }
}
