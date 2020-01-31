package com.example.demo.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public long getId() {
    	return this.id;
    }
    public void setId(long id) {
    	this.id = id;
    }

    @Column(name = "name", nullable = false)
    private String name;


    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    }

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;


    public String getSerialNumber() {
    	return this.serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
    	this.serialNumber = serialNumber;
    }

    @Column(name = "description", nullable = false)
    private String description;


    public String getDescription() {
    	return this.description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }

    @Column(name = "price", nullable = false)
    private float price;


    public float getPrice() {
    	return this.price;
    }
    public void setPrice(float price) {
    	this.price = price;
    }

    @Column(name = "stock", nullable = false)
    private int stock;


    public int getStock() {
    	return this.stock;
    }
    public void setStock(int stock) {
    	this.stock = stock;
    }

    @Column(name = "weight", nullable = false)
    private int weight;


    public int getWeight() {
    	return this.weight;
    }
    public void setWeight(int weight) {
    	this.weight = weight;
    }

    @Column(name = "picture", nullable = false)
    private String picture;


    public String getPicture() {
    	return this.picture;
    }
    public void setPicture(String picture) {
    	this.picture = picture;
    }
    
    @Column(name = "brand_id", nullable = false)
    private int brandId;


    public int getBrandId() {
    	return this.brandId;
    }
    public void setBrandId(int brandId) {
    	this.brandId = brandId;
    }
}
