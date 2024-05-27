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

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void createOrder() throws Exception {
        Order mockOrder = new Order();
        when(orderService.createOrder(mockOrder)).thenReturn(mockOrder);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void findOrderById() throws Exception {
        Order mockOrder = new Order();
        when(orderService.findOrderById(1L)).thenReturn(mockOrder);

        mockMvc.perform(get("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateOrder() throws Exception {
        Order mockOrder = new Order();
        when(orderService.updateOrder(mockOrder)).thenReturn(mockOrder);

        mockMvc.perform(put("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrder() throws Exception {
        mockMvc.perform(delete("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findAllOrders() throws Exception {
        when(orderService.findAllOrders()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

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

    @Test
    void getOrdersByStatus() throws Exception {
        Order mockOrder = new Order();
        when(orderService.findOrdersByStatus(OrderStatus.PENDING)).thenReturn(Collections.singletonList(mockOrder));

        mockMvc.perform(get("/orders/status/PENDING")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}