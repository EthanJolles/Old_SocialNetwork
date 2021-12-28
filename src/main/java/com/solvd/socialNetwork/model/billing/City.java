package com.solvd.socialNetwork.model.billing;

public class City {
    private Long id;
    private String city;
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
