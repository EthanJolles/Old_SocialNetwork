package com.solvd.socialNetwork.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("city")
    private String city;

    @JsonProperty("stateId")
    private Long stateId;

    public City() {
    }

    public City(String city, Long stateId) {
        this.city = city;
        this.stateId = stateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
}
