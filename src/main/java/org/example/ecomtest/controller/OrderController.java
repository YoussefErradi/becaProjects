package org.example.ecomtest.controller;

import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable Long orderId) {
        return orderService.findOrderById(orderId);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/product/{productId}")
    public Map<Product, List<Order>> getOrdersByProduct(@PathVariable Long productId) {
        Product product = orderService.findProductById(productId);
        List<Order> orders = orderService.findOrdersByProduct(product);
        Map<Product, List<Order>> result = new HashMap<>();
        result.put(product, orders);
        return result;
    }

    @GetMapping("/status/{status}")
    public Map<String, List<Order>> getOrdersByStatus(@PathVariable String status) {
        List<Order> orders = orderService.findOrdersByStatus(status);
        Map<String, List<Order>> result = new HashMap<>();
        result.put(status, orders);
        return result;
    }
}