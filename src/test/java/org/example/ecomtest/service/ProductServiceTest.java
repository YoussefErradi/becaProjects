package org.example.ecomtest.service;

import org.example.ecomtest.model.Product;
import org.example.ecomtest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
        void createProduct() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        Product returnedProduct = productService.createProduct(mockProduct);
        assertEquals(mockProduct, returnedProduct);
    }

    @Test
    void deleteProduct() {
        Long productId = 1L;
        doNothing().when(productRepository).deleteById(productId);
        productService.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void findAllProducts() {
        Product mockProduct = new Product();
        when(productRepository.findAll()).thenReturn(Arrays.asList(mockProduct));
        assertEquals(1, productService.findAllProducts().size());
    }

    @Test
    void findProductById() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(mockProduct));
        Product returnedProduct = productService.findProductById(1L);
        assertEquals(mockProduct, returnedProduct);
    }

    @Test
    void updateProduct() {
        Product mockProduct = new Product();
        mockProduct.setProductId(1L);
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        Product returnedProduct = productService.updateProduct(mockProduct);
        assertEquals(mockProduct, returnedProduct);
    }
}