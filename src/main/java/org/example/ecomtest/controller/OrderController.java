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


/**
 * The OrderController class provides RESTful API endpoints for mapping and managing orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * Constructs a new OrderController with the specified OrderService.
     * @param orderService the service to handle order operations
     */
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Creates a new order.
     * @param order the order to create
     * @return the created order
     */
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        logger.info("Creating order: {}", order);
        return orderService.createOrder(order);
    }

    /**
     * Finds an order by its ID.
     * @param orderId the ID of the order to find
     * @return the found order
     */
    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable Long orderId) {
        logger.info("Finding order by id: {}", orderId);
        return orderService.findOrderById(orderId);
    }

    /**
     * Updates an existing order.
     * @param order the order with updated information
     * @return the updated order
     */
    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        logger.info("Updating order: {}", order);
        return orderService.updateOrder(order);
    }

    /**
     * Deletes an order by its ID.
     * @param orderId the ID of the order to delete
     */
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        logger.info("Deleting order with id: {}", orderId);
        orderService.deleteOrder(orderId);
    }

    /**
     * Finds all orders.
     * @return a list of all orders
     */
    @GetMapping
    public List<Order> findAllOrders() {
        logger.info("Finding all orders");
        return orderService.findAllOrders();
    }

    /**
     * Gets orders by a product ID.
     * @param productId the ID of the product
     * @return a map of the product and its orders
     */
    @GetMapping("/product/{productId}")
    public Map<Product, List<Order>> getOrdersByProduct(@PathVariable Long productId) {
        logger.info("Getting orders by product id: {}", productId);
        Product product = orderService.findProductById(productId);
        List<Order> orders = orderService.findOrdersByProduct(product);
        return Collections.singletonMap(product, orders);
    }

    /**
     * Gets orders by their status.
     * @param status the status of the orders to find
     * @return a map of the status and its orders
     */
    @GetMapping("/status/{status}")
    public Map<OrderStatus, List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
        logger.info("Getting orders by status: {}", status);
        List<Order> orders = orderService.findOrdersByStatus(status);
        return Collections.singletonMap(status, orders);
    }
}
