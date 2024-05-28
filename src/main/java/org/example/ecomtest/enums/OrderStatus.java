package org.example.ecomtest.enums;

/**
 * The OrderStatus enumeration represents the various states an order can be in.
 */
public enum OrderStatus {
    /**
     * The order has been placed but not yet shipped.
     */
    PENDING,

    /**
     * The order has been shipped but not yet delivered to the customer.
     */
    SHIPPED,

    /**
     * The order has been delivered to the customer.
     */
    DELIVERED,

    /**
     * The order has been cancelled.
     */
    CANCELLED
}