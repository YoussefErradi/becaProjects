package org.example.ecomtest.model;

import jakarta.persistence.*;

/**
 * The Product class represents a product in the e-commerce system.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private String category;
    private Double price;
    private Integer stockQuantity;

    /**
     * Default constructor for Product.
     */
    public Product() {
    }

    /**
     * Constructs a new Product with the specified name, category, price, and stock quantity.
     * @param name the name of the product
     * @param category the category of the product
     * @param price the price of the product
     * @param stockQuantity the stock quantity of the product
     */
    public Product(String name, String category, Double price, Integer stockQuantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    /**
     * Gets the product ID.
     * @return the product ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the product ID.
     * @param productId the new product ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets the name of the product.
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the product.
     * @return the category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     * @param category the new category of the product
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price of the product.
     * @return the price of the product
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the new price of the product
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the stock quantity of the product.
     * @return the stock quantity of the product
     */
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets the stock quantity of the product.
     * @param stockQuantity the new stock quantity of the product
     */
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}