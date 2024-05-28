package org.example.ecomtest.service;

import org.example.ecomtest.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecomtest.model.Product;

import java.util.List;

/**
 * The ProductService class provides services related to products in the e-commerce system.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    /**
     * Constructs a new ProductService with the specified ProductRepository.
     * @param productRepository the repository for products
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Finds all products.
     * @return a list of all products
     */
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Finds a product by its ID.
     * @param productId the ID of the product to find
     * @return the found product
     * @throws RuntimeException if the product is not found
     */
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    /**
     * Creates a new product.
     * @param product the product to create
     * @return the created product
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates a product.
     * @param product the product to update
     * @return the updated product
     */
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     * @param productId the ID of the product to delete
     */
    public void deleteProduct(Long productId) {
        logger.info("Deleting product with ID: {}", productId);
        productRepository.deleteById(productId);
    }
}