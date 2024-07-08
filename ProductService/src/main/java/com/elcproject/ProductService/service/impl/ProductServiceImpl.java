package com.elcproject.ProductService.service.impl;

import com.elcproject.ProductService.exception.InsufficientStockException;
import com.elcproject.ProductService.exception.ResourceNotFoundException;
import com.elcproject.ProductService.exception.ValidationException;
import com.elcproject.ProductService.model.dto.ProductDto;
import com.elcproject.ProductService.model.dto.ResponseDto;
import com.elcproject.ProductService.model.entity.Product;
import com.elcproject.ProductService.model.mapper.ProductMapper;
import com.elcproject.ProductService.repository.ProductRepository;
import com.elcproject.ProductService.service.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long addProduct(ProductDto productDto) {

        Product product = ProductMapper.mapProductDtoToProduct(productDto);
        productRepository.save(product);
        log.info("Product added successfully.");

        return product.getProductId();
    }

    @Override
    public ProductDto getProductById(long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", Long.toString(productId)));

        return ProductMapper.mapProductToProductDto(product);
    }

    @Override
    public void reduceStockById(long productId, int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", Long.toString(productId)));

        if(product.getStock() < quantity)
            throw new InsufficientStockException();

        product.setStock(product.getStock()-quantity);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getProductsLowerPrice(BigDecimal price) {

        List<Product> products = productRepository.findByPriceLessThan(price);
        if(products.isEmpty())
            throw new ResourceNotFoundException("Product", "price", price.toString());

        return ProductMapper.mapProductsToProductDTOs(products);
    }

    @Override
    public List<ProductDto> getProductsBetweenPrice(BigDecimal price, BigDecimal max) {

        if(max == null) {
            throw new IllegalArgumentException("Min and Max are required for searching products between that prices");
        }

        List<Product> products = productRepository.findByPriceBetween(price, max);
        if(products.isEmpty())
            throw new ResourceNotFoundException("Product", "prices", price.toString() + "," +max.toString());

        return ProductMapper.mapProductsToProductDTOs(products);
    }

    @Override
    public List<ProductDto> getProductsHigherPrice(BigDecimal price) {

        List<Product> products = productRepository.findByPriceGreaterThan(price);
        if(products.isEmpty())
            throw new ResourceNotFoundException("Product", "price", price.toString());

        return ProductMapper.mapProductsToProductDTOs(products);
    }

    @Override
    public void deleteProductById(long productId) {

        productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Product Id", Long.toString(productId)));

        productRepository.deleteById(productId);
    }

}
