package org.example.ecomtest.controller;

import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ProductController class provides RESTful API endpoints for mapping andd managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * Constructs a new ProductController with the specified ProductService.
     * @param productService the service to handle product operations
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Creates a new product.
     * @param product the product to create
     * @return the created product
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        logger.info("Creating product: {}", product);
        return productService.createProduct(product);
    }

    /**
     * Finds a product by its ID.
     * @param productId the ID of the product to find
     * @return the found product
     */
    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable Long productId) {
        logger.info("Finding product by id: {}", productId);
        return productService.findProductById(productId);
    }

    /**
     * Updates an existing product.
     * @param product the product with updated information
     * @return the updated product
     */
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        logger.info("Updating product: {}", product);
        return productService.updateProduct(product);
    }

    /**
     * Deletes a product by its ID.
     * @param productId the ID of the product to delete
     */
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        logger.info("Deleting product with id: {}", productId);
        productService.deleteProduct(productId);
    }

    /**
     * Finds all products.
     * @return a list of all products
     */
    @GetMapping
    public List<Product> findAllProducts() {
        logger.info("Finding all products");
        return productService.findAllProducts();
    }
}