package org.example.ecomtest.model;

import jakarta.persistence.*;
import org.example.ecomtest.enums.OrderStatus;

import java.util.Date;
import java.util.List;

/**
 * The Order class represents an order in the e-commerce system.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long customerId;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Double totalAmount;

    @OneToMany
    private List<Product> products;

    /**
     * Default constructor for Order.
     */
    public Order() {
    }

    /**
     * Constructs a new Order with the specified customer ID, order date, status, total amount, and products.
     * @param customerId the ID of the customer who placed the order
     * @param orderDate the date the order was placed
     * @param status the status of the order
     * @param totalAmount the total amount of the order
     * @param products the products in the order
     */
    public Order(Long customerId, Date orderDate, OrderStatus status, Double totalAmount, List<Product> products) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.products = products;
    }

    /**
     * Gets the order ID.
     * @return the order ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Sets the order ID.
     * @param orderId the new order ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the customer ID.
     * @return the customer ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     * @param customerId the new customer ID
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the order date.
     * @return the order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     * @param orderDate the new order date
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the order status.
     * @return the order status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets the order status.
     * @param status the new order status
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Gets the total amount of the order.
     * @return the total amount of the order
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount of the order.
     * @param totalAmount the new total amount of the order
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the products in the order.
     * @return the products in the order
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the products in the order.
     * @param products the new products in the order
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}