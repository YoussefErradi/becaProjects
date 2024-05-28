package org.example.ecomtest.controller;

import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        logger.info("Creating product: {}", product);
        return productService.createProduct(product);
    }

    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable Long productId) {
        logger.info("Finding product by id: {}", productId);
        return productService.findProductById(productId);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        logger.info("Updating product: {}", product);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        logger.info("Deleting product with id: {}", productId);
        productService.deleteProduct(productId);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        logger.info("Finding all products");
        return productService.findAllProducts();
    }
}