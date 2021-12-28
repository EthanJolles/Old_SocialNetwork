package com.solvd.socialNetwork.model.billing;

public class State {
    private Long id;
    private String state;
    private Long countryId;

    public State() {
    }

    public State( String state, Long countryId) {
        this.state = state;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
