package com.solvd.socialNetwork.model.billing;

public class Country {
    private Long id;
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
