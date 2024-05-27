package org.example.ecomtest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testParameterizedConstructor() {
        Product product = new Product("Product 1", "Category 1", 10.0, 5);

        assertEquals("Product 1", product.getName());
        assertEquals("Category 1", product.getCategory());
        assertEquals(10.0, product.getPrice());
        assertEquals(5, product.getStockQuantity());
    }

    @Test
    void getProductId() {
        Long id = 1L;
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void setProductId() {
        Long id = 1L;
        product.setProductId(id);
        assertEquals(id, product.getProductId());
    }

    @Test
    void getName() {
        String name = "Product 1";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    void setName() {
        String name = "Product 1";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    void getCategory() {
        String category = "Category 1";
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }

    @Test
    void setCategory() {
        String category = "Category 1";
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }

    @Test
    void getPrice() {
        Double price = 10.0;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void setPrice() {
        Double price = 10.0;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void getStockQuantity() {
        Integer stockQuantity = 5;
        product.setStockQuantity(stockQuantity);
        assertEquals(stockQuantity, product.getStockQuantity());
    }

    @Test
    void setStockQuantity() {
        Integer stockQuantity = 5;
        product.setStockQuantity(stockQuantity);
        assertEquals(stockQuantity, product.getStockQuantity());
    }
}