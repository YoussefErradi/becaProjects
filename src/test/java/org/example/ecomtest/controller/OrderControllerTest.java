package org.example.ecomtest.controller;

import org.example.ecomtest.enums.OrderStatus;
import org.example.ecomtest.model.Order;
import org.example.ecomtest.model.Product;
import org.example.ecomtest.service.OrderService;
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
 * The OrderControllerTest class provides tests for the OrderController class.
 */
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    /**
     * Tests the createOrder method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void createOrder() throws Exception {
        Order mockOrder = new Order();
        when(orderService.createOrder(mockOrder)).thenReturn(mockOrder);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    /**
     * Tests the findOrderById method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void findOrderById() throws Exception {
        Order mockOrder = new Order();
        when(orderService.findOrderById(1L)).thenReturn(mockOrder);

        mockMvc.perform(get("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the updateOrder method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void updateOrder() throws Exception {
        Order mockOrder = new Order();
        when(orderService.updateOrder(mockOrder)).thenReturn(mockOrder);

        mockMvc.perform(put("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    /**
     * Tests the deleteOrder method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void deleteOrder() throws Exception {
        mockMvc.perform(delete("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the findAllOrders method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void findAllOrders() throws Exception {
        when(orderService.findAllOrders()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the getOrdersByProduct method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void getOrdersByProduct() throws Exception {
        Product mockProduct = new Product();
        Order mockOrder = new Order();
        when(orderService.findProductById(1L)).thenReturn(mockProduct);
        when(orderService.findOrdersByProduct(mockProduct)).thenReturn(Collections.singletonList(mockOrder));

        mockMvc.perform(get("/orders/product/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Tests the getOrdersByStatus method of the OrderController class.
     * @throws Exception if an error occurs during the test
     */
    @Test
    void getOrdersByStatus() throws Exception {
        Order mockOrder = new Order();
        when(orderService.findOrdersByStatus(OrderStatus.PENDING)).thenReturn(Collections.singletonList(mockOrder));

        mockMvc.perform(get("/orders/status/PENDING")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}