package org.example.ecomtest.service;

import org.example.ecomtest.enums.OrderStatus;
import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.repository.OrderRepository;
import org.example.ecomtest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
         void createOrder() {
        Order mockOrder = new Order();
        mockOrder.setOrderId(1L);
        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);
        Order returnedOrder = orderService.createOrder(mockOrder);
        assertEquals(mockOrder, returnedOrder);
    }

    @Test
    void deleteOrder() {
        Long orderId = 1L;
        doNothing().when(orderRepository).deleteById(orderId);
        orderService.deleteOrder(orderId);
        verify(orderRepository, times(1)).deleteById(orderId);
    }

    @Test
    void findAllOrders() {
        Order mockOrder = new Order();
        when(orderRepository.findAll()).thenReturn(Arrays.asList(mockOrder));
        assertEquals(1, orderService.findAllOrders().size());
    }

    @Test
    void findOrderById() {
        Order mockOrder = new Order();
        mockOrder.setOrderId(1L);
        when(orderRepository.findById(any(Long.class))).thenReturn(Optional.of(mockOrder));
        Order returnedOrder = orderService.findOrderById(1L);
        assertEquals(mockOrder, returnedOrder);
    }

    @Test
    void updateOrder() {
        Order mockOrder = new Order();
        mockOrder.setOrderId(1L);
        when(orderRepository.save(any(Order.class))).thenReturn(mockOrder);
        Order returnedOrder = orderService.updateOrder(mockOrder);
        assertEquals(mockOrder, returnedOrder);
    }

    @Test
    void findProductById() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(mockProduct));
        Product returnedProduct = orderService.findProductById(1L);
        assertEquals(mockProduct, returnedProduct);
    }

    @Test
    void findOrdersByProduct() {
        Product mockProduct = new Product();
        Order mockOrder = new Order();
        when(orderRepository.findOrdersByProduct(any(Product.class))).thenReturn(Arrays.asList(mockOrder));
        assertEquals(1, orderService.findOrdersByProduct(mockProduct).size());
    }

    @Test
    void findOrdersByStatus() {
        Order mockOrder = new Order();
        when(orderRepository.findOrdersByStatus(any(OrderStatus.class))).thenReturn(Arrays.asList(mockOrder));
        assertEquals(1, orderService.findOrdersByStatus(OrderStatus.PENDING).size());
    }
}