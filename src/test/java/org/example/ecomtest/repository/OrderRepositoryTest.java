package org.example.ecomtest.repository;

import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderRepositoryTest {

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findOrdersByProductPositive() {
        Product product = new Product("Product 1", "Category 1", 10.0, 5);
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order(1L, new Date(), OrderStatus.PENDING, 100.0, List.of(product)));
        when(orderRepository.findOrdersByProduct(product)).thenReturn(mockOrders);
        List<Order> returnedOrders = orderRepository.findOrdersByProduct(product);
        assertEquals(mockOrders, returnedOrders);
    }

    @Test
    void findOrdersByProductNegative() {
        Product product = new Product("Product 2", "Category 2", 20.0, 10);
        when(orderRepository.findOrdersByProduct(product)).thenReturn(new ArrayList<>());
        List<Order> returnedOrders = orderRepository.findOrdersByProduct(product);
        assertTrue(returnedOrders.isEmpty());
    }

    @Test
    void findOrdersByStatusPositive() {
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order(1L, new Date(), OrderStatus.PENDING, 100.0, new ArrayList<>()));
        when(orderRepository.findOrdersByStatus(OrderStatus.PENDING)).thenReturn(mockOrders);
        List<Order> returnedOrders = orderRepository.findOrdersByStatus(OrderStatus.PENDING);
        assertEquals(mockOrders, returnedOrders);
    }

    @Test
    void findOrdersByStatusNegative() {
        when(orderRepository.findOrdersByStatus(OrderStatus.SHIPPED)).thenReturn(new ArrayList<>());
        List<Order> returnedOrders = orderRepository.findOrdersByStatus(OrderStatus.SHIPPED);
        assertTrue(returnedOrders.isEmpty());
    }
}