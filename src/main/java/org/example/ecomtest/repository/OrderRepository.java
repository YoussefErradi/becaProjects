package org.example.ecomtest.repository;

import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN o.products p WHERE p = :product")
    List<Order> findOrdersByProduct(@Param("product") Product product);

    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findOrdersByStatus(@Param("status") String status);
}