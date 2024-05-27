package org.example.ecomtest.service;

import org.example.ecomtest.model.Order;
import org.example.ecomtest.repository.OrderRepository;
import org.example.ecomtest.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
        Order mockOrder = new Order();
        mockOrder.setOrderId(1L);
        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);
        OrderService orderService = new OrderService(orderRepository, productRepository);
        Order returnedOrder = orderService.createOrder(mockOrder);
        assertEquals(mockOrder, returnedOrder);
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