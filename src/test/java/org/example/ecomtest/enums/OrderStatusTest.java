package org.example.ecomtest.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The OrderStatusTest class provides tests for the OrderStatus enum.
 */
class OrderStatusTest {

    /**
     * Tests the values method of the OrderStatus enum.
     * This test checks if the values method returns an array of all enum constants in the order they're declared.
     */
    @Test
    void values() {
        OrderStatus[] expected = {OrderStatus.PENDING, OrderStatus.SHIPPED, OrderStatus.DELIVERED, OrderStatus.CANCELLED};
        OrderStatus[] actual = OrderStatus.values();
        assertArrayEquals(expected, actual);
    }

    /**
     * Tests the valueOf method of the OrderStatus enum.
     * This test checks if the valueOf method returns the enum constant of the specified enum type with the specified name.
     */
    @Test
    void valueOf() {
        assertEquals(OrderStatus.PENDING, OrderStatus.valueOf("PENDING"));
        assertEquals(OrderStatus.SHIPPED, OrderStatus.valueOf("SHIPPED"));
        assertEquals(OrderStatus.DELIVERED, OrderStatus.valueOf("DELIVERED"));
        assertEquals(OrderStatus.CANCELLED, OrderStatus.valueOf("CANCELLED"));
    }
}