package com.solvd.socialNetwork.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("country")
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
