package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    Product product;

    @MockBean
    ProductService productService;

    @BeforeEach
    void setup() {
        product = new Product(0, "Apples", 20);
    }

    @Test
    void read() {
        Mockito.when(productService.read(0)).thenReturn(product);
        assertEquals(product, productService.read(0));
    }
}