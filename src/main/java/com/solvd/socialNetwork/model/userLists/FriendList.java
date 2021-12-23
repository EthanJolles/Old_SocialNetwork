package com.solvd.socialNetwork.model.userLists;

import com.solvd.socialNetwork.model.profile.Profile;

import java.util.List;

public class FriendList {

    private Long id;
    private Long userId;
    private Long friendProfileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendProfileId() {
        return friendProfileId;
    }

    public void setFriendProfileId(Long friendProfileId) {
        this.friendProfileId = friendProfileId;
    }
}
