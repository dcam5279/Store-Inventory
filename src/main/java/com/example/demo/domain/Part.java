package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @Column(name = "MIN_INV")
    @Min(value = 0, message = "Minimum inventory cannot be below zero")
    Integer minInv;

    @Column(name = "MAX_INV")
    @Min(value = 0, message = "Maximum inventory cannot be below zero")
    Integer maxInv;


    @ManyToMany
    @JoinTable(name = "product_part", joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> products = new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int inv, int minInv, int maxInv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = minInv;
        this.maxInv = maxInv;
    }

    public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = minInv;
        this.maxInv = maxInv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public Integer getMinInv() {
        return minInv;
    }

    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }

    public Integer getMaxInv() {
        return maxInv;
    }

    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }


    public String validateInventory() {

        if (minInv == null || maxInv == null) {
            return "Inventory limits are not set properly!";
        }
        if (inv < minInv) {
            return "Inventory is below the minimum allowed!";
        }

        if (inv > maxInv) {
            return "Inventory exceeds the maximum allowed!";
        }

        return null;
    }

    public String validateInventoryOnProductUpdate() {
        if (minInv != null && inv - 1 < minInv) {
            return "Adding or updating a product will cause the inventory of this part to fall below the minimum allowed!";
        }
        return null;
    }


    public boolean isInvValid() {
        if (minInv == null || maxInv == null) {
            return false;
        }
        return inv >= minInv && inv <= maxInv;
    }

}
