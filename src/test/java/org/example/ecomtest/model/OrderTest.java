package org.example.ecomtest.model;

import org.example.ecomtest.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testParameterizedConstructor() {
        Date date = new Date();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "Category 1", 10.0, 5));
        Order order = new Order(1L, date, OrderStatus.PENDING, 100.0, products);
        assertEquals(1L, order.getCustomerId());
        assertEquals(date, order.getOrderDate());
        assertEquals(OrderStatus.PENDING, order.getStatus());
        assertEquals(100.0, order.getTotalAmount());
        assertEquals(products, order.getProducts());
    }

    @Test
    void getStatus() {
        OrderStatus status = OrderStatus.PENDING;
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }

    @Test
    void setStatus() {
        OrderStatus status = OrderStatus.SHIPPED;
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }

    @Test
    void getOrderId() {
        Long id = 1L;
        order.setOrderId(id);
        assertEquals(id, order.getOrderId());
    }

    @Test
    void setOrderId() {
        Long id = 1L;
        order.setOrderId(id);
        assertEquals(id, order.getOrderId());
    }

    @Test
    void getCustomerId() {
        Long customerId = 1L;
        order.setCustomerId(customerId);
        assertEquals(customerId, order.getCustomerId());
    }

    @Test
    void setCustomerId() {
        Long customerId = 1L;
        order.setCustomerId(customerId);
        assertEquals(customerId, order.getCustomerId());
    }

    @Test
    void getOrderDate() {
        Date date = new Date();
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    void setOrderDate() {
        Date date = new Date();
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }



    @Test
    void getTotalAmount() {
        Double totalAmount = 100.0;
        order.setTotalAmount(totalAmount);
        assertEquals(totalAmount, order.getTotalAmount());
    }

    @Test
    void setTotalAmount() {
        Double totalAmount = 100.0;
        order.setTotalAmount(totalAmount);
        assertEquals(totalAmount, order.getTotalAmount());
    }

    @Test
    void getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "Category 1", 10.0, 5));
        order.setProducts(products);
        assertEquals(products, order.getProducts());
    }

    @Test
    void setProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "Category 1", 10.0, 5));
        order.setProducts(products);
        assertEquals(products, order.getProducts());
    }
}