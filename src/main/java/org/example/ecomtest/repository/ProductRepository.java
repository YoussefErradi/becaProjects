package org.example.ecomtest.repository;

import org.example.ecomtest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The ProductRepository interface provides methods for querying the products in the e-commerce system.
 * It extends JpaRepository to inherit methods like save, delete, findAll etc.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}