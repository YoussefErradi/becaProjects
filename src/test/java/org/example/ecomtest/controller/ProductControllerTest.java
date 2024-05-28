package org.example.ecomtest.controller;

import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The ProductControllerTest class provides tests for the ProductController class.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    /**
     * Tests the createProduct method of the ProductController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void createProduct() throws Exception {
        Product mockProduct = new Product();
        when(productService.createProduct(mockProduct)).thenReturn(mockProduct);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    /**
     * Tests the findProductById method of the ProductController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void findProductById() throws Exception {
        Product mockProduct = new Product();
        when(productService.findProductById(1L)).thenReturn(mockProduct);

        mockMvc.perform(get("/products/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the updateProduct method of the ProductController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void updateProduct() throws Exception {
        Product mockProduct = new Product();
        when(productService.updateProduct(mockProduct)).thenReturn(mockProduct);

        mockMvc.perform(put("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    /**
     * Tests the deleteProduct method of the ProductController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(delete("/products/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the findAllProducts method of the ProductController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void findAllProducts() throws Exception {
        when(productService.findAllProducts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}