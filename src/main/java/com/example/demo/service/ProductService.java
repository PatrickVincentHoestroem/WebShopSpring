package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void create(Product p){
        productRepository.create(p);
    }

    public Product read(long id) {
        return productRepository.read(id);
    }

    public List<Product> readAll() {
        return productRepository.readAll();
    }

    public void update(Product p) {
        productRepository.update(p);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}
