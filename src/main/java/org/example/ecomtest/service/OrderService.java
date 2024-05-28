package org.example.ecomtest.service;

import org.example.ecomtest.enums.OrderStatus;
import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.repository.OrderRepository;
import org.example.ecomtest.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The OrderService class provides services related to orders in the e-commerce system.
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * Constructs a new OrderService with the specified OrderRepository and ProductRepository.
     * @param orderRepository the repository for orders
     * @param productRepository the repository for products
     */
    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    /**
     * Creates a new order.
     * @param order the order to create
     * @return the created order
     */
    public Order createOrder(Order order) {
        logger.info("Creating order: {}", order);
        return orderRepository.save(order);
    }

    /**
     * Deletes an order by its ID.
     * @param orderId the ID of the order to delete
     */
    public void deleteOrder(Long orderId) {
        logger.info("Deleting order with ID: {}", orderId);
        orderRepository.deleteById(orderId);
    }

    /**
     * Finds all orders.
     * @return a list of all orders
     */
    public List<Order> findAllOrders() {
        logger.info("Finding all orders");
        return orderRepository.findAll();
    }

    /**
     * Finds an order by its ID.
     * @param orderId the ID of the order to find
     * @return the found order
     * @throws RuntimeException if the order is not found
     */
    public Order findOrderById(Long orderId) {
        logger.info("Finding order by id: {}", orderId);
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    /**
     * Updates an order.
     * @param order the order to update
     * @return the updated order
     */
    public Order updateOrder(Order order) {
        logger.info("Updating order: {}", order);
        return orderRepository.save(order);
    }

    /**
     * Finds a product by its ID.
     * @param productId the ID of the product to find
     * @return the found product
     * @throws RuntimeException if the product is not found
     */
    public Product findProductById(Long productId) {
        logger.info("Finding product by id: {}", productId);
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    /**
     * Finds orders by a product.
     * @param product the product to find orders by
     * @return a list of orders that contain the specified product
     */
    public List<Order> findOrdersByProduct(Product product) {
        logger.info("Finding orders by product: {}", product);
        return orderRepository.findOrdersByProduct(product);
    }

    /**
     * Finds orders by their status.
     * @param status the status to find orders by
     * @return a list of orders that have the specified status
     */
    public List<Order> findOrdersByStatus(OrderStatus status) {
        logger.info("Finding orders by status: {}", status);
        return orderRepository.findOrdersByStatus(status);
    }
}