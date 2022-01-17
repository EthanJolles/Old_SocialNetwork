package com.solvd.socialNetwork.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty
    private Long id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("productId")
    private Long productId;

    public Order() {
    }

    public Order(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
