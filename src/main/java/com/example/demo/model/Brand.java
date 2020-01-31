package com.example.demo.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "brand")
@EntityListeners(AuditingEntityListener.class)
public class Brand {

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



    @Column(name = "country", nullable = false)
    private String country;
    
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
    	this.country = country;
    }

    
}