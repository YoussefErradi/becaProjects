package org.example.ecomtest.repository;

import org.example.ecomtest.enums.OrderStatus;
import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The OrderRepository interface provides methods for querying the orders in the e-commerce system.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * Finds orders that contain the specified product.
     * @param product the product to search for in orders
     * @return a list of orders that contain the specified product
     */
    @Query("SELECT o FROM Order o JOIN o.products p WHERE p = :product")
    List<Order> findOrdersByProduct(@Param("product") Product product);

    /**
     * Finds orders that have the specified status.
     * @param status the status to search for in orders
     * @return a list of orders that have the specified status
     */
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findOrdersByStatus(@Param("status") OrderStatus status);
}