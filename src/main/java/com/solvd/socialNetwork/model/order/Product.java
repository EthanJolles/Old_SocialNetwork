package com.solvd.socialNetwork.model.order;

import javax.xml.bind.annotation.*;

import java.util.Date;
public class Product {
    private Long id;

    private String name;

    private Double price;

    private String desc;

    private Date dateListed;

    private Long sku;

    private String modelNumber;

    @XmlElement (name="isOutOfStock")
    private Boolean isOutOfStock;

    public Product() {
    }

    public Product(String name, Double price, String desc,
                   Date dateListed, Long sku, String modelNumber, Boolean isOutOfStock) {

        this.name = name;
        this.price = price;
        this.desc = desc;
        this.dateListed = dateListed;
        this.sku = sku;
        this.modelNumber = modelNumber;
        this.isOutOfStock = isOutOfStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDateListed() {
        return dateListed;
    }

    public void setDateListed(Date dateListed) {
        this.dateListed = dateListed;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Boolean getOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(Boolean outOfStock) {
        isOutOfStock = outOfStock;
    }
}
