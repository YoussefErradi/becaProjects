package org.example.ecomtest.service;

import org.example.ecomtest.repository.OrderRepository;
import org.example.ecomtest.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        OrderService orderService = new OrderService(orderRepository, productRepository);
    }


    @Test
    public void createOrder() {

    }

    @Test
    void deleteOrder() {
    }

    @Test
    void findAllOrders() {
    }

    @Test
    void findOrderById() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void findProductById() {
    }

    @Test
    void findOrdersByProduct() {
    }

    @Test
    void findOrdersByStatus() {
    }
}