package com.solvd.socialNetwork.model.order;

import javax.xml.bind.annotation.*;
import java.util.Date;

//Not good enough right now, should be able to handle many
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "name", "price", "desc", "dateListed",
        "sku", "modelNumber", "isOutOfStock"})

public class Product {
    private Long id;
    private String name;
    private Double price;
    private String desc;
    private Date dateListed;
    private Long sku;
    private String modelNumber;
    private byte[] isOutOfStock;

    public Product() {
    }

    public Product(String name, Double price, String desc,
                   Date dateListed, Long sku, String modelNumber, byte[] isOutOfStock) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.dateListed = dateListed;
        this.sku = sku;
        this.modelNumber = modelNumber;
        this.isOutOfStock = isOutOfStock;
    }
    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlElement(name = "dateListed")
    public Date getDateListed() {
        return dateListed;
    }

    public void setDateListed(Date dateListed) {
        this.dateListed = dateListed;
    }

    @XmlElement(name = "sku")
    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    @XmlElement(name = "modelNumber")
    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @XmlElement(name = "isOutOfStock")
    public byte[] getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(byte[] isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", desc=" + desc +
                ", dateListed=" + dateListed +
                ", sku=" + sku +
                ", modelNumber=" + modelNumber +
                ", isOutOfStock='" + isOutOfStock + '\'' +
                '}';
    }

}
