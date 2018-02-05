package com.riri.grocerystore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cosmetics{

    @NotNull
    @Size(min=2,message="Enter at least {min} characters")
    private String brand;

    @NotNull
    @Size(min=2,message="Enter at least {min} characters")
    private String popularity;

    @NotNull
    @Min(0)
    private int quantity;

    @NotNull
    @Min(0)
    private double price;

    @NotNull
    @Min(0)
    private double total;

    @NotNull
    @Min(0)
    private double revenue;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getTotal() {
        total = price * quantity;
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
