package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product p) {
        jdbcTemplate.update("INSERT INTO products (name, price) VALUES (?,?)", p.getName(), p.getPrice());
    }

    @Override
    public Product read(long id) {
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?", rowMapper, id);
    }

    @Override
    public List<Product> readAll() {
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query("SELECT * FROM products", rowMapper);
    }

    @Override
    public void update(Product p) {
        jdbcTemplate.update("UPDATE products SET name=?, price=? WHERE id=?", p.getName(), p.getPrice(), p.getId());
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM products WHERE id=?", id);
    }
}
