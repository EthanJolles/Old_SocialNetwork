package com.solvd.socialNetwork.model.userLists;

public class FriendList {

    private Long id;
    private Long profileId;
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
