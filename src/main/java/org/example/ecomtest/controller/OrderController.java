package org.example.ecomtest.controller;

import org.example.ecomtest.enums.OrderStatus;
import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        logger.info("Creating order: {}", order);
        return orderService.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable Long orderId) {
        logger.info("Finding order by id: {}", orderId);
        return orderService.findOrderById(orderId);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        logger.info("Updating order: {}", order);
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        logger.info("Deleting order with id: {}", orderId);
        orderService.deleteOrder(orderId);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        logger.info("Finding all orders");
        return orderService.findAllOrders();
    }

    @GetMapping("/product/{productId}")
    public Map<Product, List<Order>> getOrdersByProduct(@PathVariable Long productId) {
        logger.info("Getting orders by product id: {}", productId);
        Product product = orderService.findProductById(productId);
        List<Order> orders = orderService.findOrdersByProduct(product);
        return Collections.singletonMap(product, orders);
    }

    @GetMapping("/status/{status}")
    public Map<OrderStatus, List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
        logger.info("Getting orders by status: {}", status);
        List<Order> orders = orderService.findOrdersByStatus(status);
        return Collections.singletonMap(status, orders);
    }
}