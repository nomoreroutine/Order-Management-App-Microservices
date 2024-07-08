package com.elcproject.ProductService.repository;

import com.elcproject.ProductService.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal price, BigDecimal max);

    List<Product> findByPriceGreaterThan(BigDecimal price);
}
