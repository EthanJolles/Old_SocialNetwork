package com.solvd.socialNetwork.model.userList;

public class BlockedList {

    private Long id;
    private Long profileId;
    private Long blockedProfileId;

    public BlockedList() {
    }

    public BlockedList(Long profileId, Long blockedProfileId) {
        this.profileId = profileId;
        this.blockedProfileId = blockedProfileId;
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

    public Long getBlockedProfileId() {
        return blockedProfileId;
    }

    public void setBlockedProfileId(Long blockedProfileId) {
        this.blockedProfileId = blockedProfileId;
    }
}
