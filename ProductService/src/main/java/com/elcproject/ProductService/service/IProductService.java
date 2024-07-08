package com.elcproject.ProductService.service;

import com.elcproject.ProductService.model.dto.ProductDto;
import com.elcproject.ProductService.model.dto.ResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {

    long addProduct(ProductDto productDto);

    ProductDto getProductById(long productId);

    void reduceStockById(long productId, int quantity);

    List<ProductDto> getProductsLowerPrice(BigDecimal price);

    List<ProductDto> getProductsBetweenPrice(BigDecimal price, BigDecimal max);

    List<ProductDto> getProductsHigherPrice(BigDecimal price);

    void deleteProductById(long productId);
}
