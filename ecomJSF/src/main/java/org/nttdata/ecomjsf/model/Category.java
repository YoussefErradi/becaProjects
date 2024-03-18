package org.nttdata.ecomjsf.model;

import jakarta.persistence.*;
import org.nttdata.ecomjsf.model.Product;


import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String catName;
    private String catDescription;
    private byte[] catImage;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public byte[] getCatImage() {
        return catImage;
    }

    public void setCatImage(byte[] catImage) {
        this.catImage = catImage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}